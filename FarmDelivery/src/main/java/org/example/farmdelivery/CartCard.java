package org.example.farmdelivery;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MyCartProduct;
import model.Product;

public class CartCard {
    public ImageView productImage;
    public Label productName;
    public Label productPrice;
    public Label productQuantity;

    public void setProductDetails(MyCartProduct product){
        productName.setText(product.getName());
        productPrice.setText("Total Price: "+product.getPrice() + " AED");
        Image image=new Image(product.getImgUrl());
        productImage.setImage(image);
        productQuantity.setText("Quantity: "+product.getQuantity());
        System.out.println("Product ID: "+product.getId());
    }
    public void setProductDetails(Product product){
        productName.setText(product.getName());
        productPrice.setText("Total Price: "+product.getPrice() + " AED");
        Image image=new Image(product.getImageUrl());
        productImage.setImage(image);
        productQuantity.setText("Quantity: "+product.getQuantityAvailable());
        System.out.println("Product ID: "+product.getProductId());
    }
}
