package model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> cartProducts=new ArrayList<>();

    public void addToCartProducts(int productId){
        ProductInventory product=new ProductInventory();
        this.cartProducts.add(product.getProduct(productId));
    }

    public ArrayList<Product> getCartProducts(){
        return cartProducts;
    }
}
