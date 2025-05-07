package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductInventory {
    private ArrayList<Product> productInventory=new ArrayList<>();

    Product prod=new Product(1,"Cherry","Cherry is amazing",20,1, LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod1=new Product(2,"Tomato","Tomato is super sweet",21,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod2=new Product(3,"Avocado","Avocado is amazing",100,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod3=new Product(4,"Potato","Potato is amazing",28,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod4=new Product(5,"StrawBerry","Strawberry is amazing",40,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    public ProductInventory(){
        productInventory.clear();
        this.productInventory.add(prod);
        this.productInventory.add(prod1);
        this.productInventory.add(prod2);
        this.productInventory.add(prod3);
        this.productInventory.add(prod4);
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
