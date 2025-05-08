package model;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductInventory {
    private final ArrayList<Product> productInventory=new ArrayList<>();

//    Product prod=new Product(1,"Cherry","Cherry is amazing",20,1, LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
//    Product prod1=new Product(2,"Tomato","Tomato is super sweet",21,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
//
//    Product prod3=new Product(4,"Potato","Potato is amazing",28,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
//    Product prod4=new Product(5,"StrawBerry","Strawberry is amazing",40,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");

    public ProductInventory(){
        productInventory.clear();
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

                 Product product=new Product(prodId,prodName,prodDes,prodPrice,prodQuantity,LocalDate.now(),imageUrl);
                 this.productInventory.add(product);
                System.out.println(imageUrl);
                System.out.println("Name: "+prodName);
                System.out.println("Price: "+prodPrice);
                System.out.println("Description: "+prodDes);
                System.out.println("Quantity: "+prodQuantity);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void storeProducts(Product prod){
        this.productInventory.add(prod);
    }

    public ArrayList<Product> getProductInventory(){
        return this.productInventory;
    }

    public ArrayList<Product> getIncreasinglySortedProducts(){
        productInventory.sort((p1,p2)->Double.compare(p1.getPrice(),p2.getPrice()));
        return productInventory;
    }
//    sort in decreasing way
public ArrayList<Product> getDecreasingSortedProducts(){
    productInventory.sort((p1,p2)->Double.compare(p2.getPrice(),p1.getPrice()));
    return productInventory;
}
public Product getProduct(int productId){
        for(Product prod:productInventory){
            if(prod.getProductId()==productId){
                return prod;
            }
        }
        return null;
}
}
