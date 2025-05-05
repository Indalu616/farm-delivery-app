package org.example.farmdelivery;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductCard {
    public ImageView productImage;
    public Label productName;
    public Label productPrice;
    public void setProduct(Product product) {
       productName.setText(product.getName());
       productPrice.setText(product.getPrice() + " AED");
       Image image=new Image(product.getImageUrl());
       productImage.setImage(image);
    }
}
