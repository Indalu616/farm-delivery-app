package org.example.farmdelivery;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Product;

public class CartCard {
    public ImageView productImage;
    public Label productName;
    public Label productPrice;
    public Label productQuantity;

    public void setProductDetails(Product product){
        productName.setText(product.getName());
        productPrice.setText(product.getPrice() + " AED");
        Image image=new Image(product.getImageUrl());
        productImage.setImage(image);
        System.out.println("Product ID: "+product.getProductId());
    }
}
