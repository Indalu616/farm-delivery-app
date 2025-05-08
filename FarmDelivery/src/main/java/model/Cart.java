package model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Cart {

    private ArrayList<MyCartProduct> cartProducts=new ArrayList<>();

    public void addToCartProducts(int productId){
//        ProductInventory product=new ProductInventory();
//        this.cartProducts.add(product.getProduct(productId));
        try(InputStream inputStream = getClass().getResourceAsStream("/files/products.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        ){
            String line;
            while((line=reader.readLine())!=null){
                String[] strArr=line.split(",");
                int prodId=Integer.parseInt(strArr[0]);
                String prodName=strArr[1];

                String prodDes=strArr[2];

                int prodPrice=Integer.parseInt(strArr[3]);
                int prodQuantity=Integer.parseInt(strArr[4]);
                String imageUrl=strArr[5];

                Product prod=new Product(prodId,prodName,prodDes,prodPrice,prodQuantity, LocalDate.now(),imageUrl);
                if(prod.getProductId()==productId){
                    saveCartProducts(prod);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<MyCartProduct> getCartProducts(){

        try(InputStream inputStream = getClass().getResourceAsStream("/files/cart.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        ){
            String line;
            while((line=reader.readLine())!=null){
                String[] strArr=line.split(",");
                System.out.println(Arrays.toString(strArr));
                if(strArr.length == 5){
                    String prodName=strArr[0];
                    int prodPrice=Integer.parseInt(strArr[1]);
                    int prodQuantity=Integer.parseInt(strArr[2]);
                    int prodId=Integer.parseInt(strArr[3]);
                    String imageUrl=strArr[4];
                    MyCartProduct myCartProduct=new MyCartProduct(prodName,imageUrl,prodQuantity,prodPrice,prodId);
                    boolean isAlreadyAdded=false;
                    for(MyCartProduct prod:cartProducts){
                        if(prod.getId()==prodId){
                            prod.increaseQuantity();
                            System.out.println("found");
                            isAlreadyAdded=true;
                            System.out.println(prod.getQuantity());
                            break;
                        }
                    }
                    if(!isAlreadyAdded){
                        cartProducts.add(myCartProduct);
                    }
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return this.cartProducts;
    }
//    save products to cart
    public void saveCartProducts(Product prod){
        String prodName=prod.getName();
        String prodDes=prod.getDescription();
        int price=prod.getPrice();
        int quantity=prod.getQuantityAvailable();
        String imageUrl=prod.getImageUrl();
        int prodId=prod.getProductId();
        String filePath = "src/main/resources/files/cart.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write(prodName+","+price+","+quantity+","+prodId+","+imageUrl+"\n");
            System.out.println("Written");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
