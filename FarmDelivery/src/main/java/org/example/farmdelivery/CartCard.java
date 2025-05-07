package org.example.farmdelivery;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MyCartProduct;

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
        System.out.println("Product ID: "+product.getId());
    }
}
