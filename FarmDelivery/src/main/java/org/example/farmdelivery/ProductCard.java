package org.example.farmdelivery;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductCard {
    public ImageView productImage;
    public Label productName;
    public Label productPrice;
    public Label productDescription;

    public void setProduct(Product product) {
       productName.setText(product.getName());
       productPrice.setText(product.getPrice() + " AED");
       productDescription.setText("This is a long product description that needs to wrap inside the card.");
       Image image=new Image(product.getImageUrl());
       productImage.setImage(image);
    }
}
