package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ProductCard {
    public ImageView productImage;
    public Label productName;
    public Label productPrice;
    public Label productDescription;
    public Button addToCartButton;

    public void setProduct(Product product) {
       productName.setText(product.getName());
       productPrice.setText(product.getPrice() + " AED");
       productDescription.setText("This is a long product description that needs to wrap inside the card.");
       Image image=new Image(product.getImageUrl());
       productImage.setImage(image);
    }
    public void addToCart(ActionEvent actionEvent) throws IOException {
        // Logic to add the product to the cart
        Product product = new Product(productName.getText(),productImage.getImage().getUrl(),Double.parseDouble(productPrice.getText()));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/cart.fxml"));
        CartController controller = loader.getController();
        controller.addItemToCart(product);
//        System.out.println("Product added to cart: " + productName.getText());
//        System.out.println("Price: " + productPrice.getText());
//        System.out.println("Description: " + productDescription.getText());
        // You can also update the cart UI here if needed
        // For example, you might want to disable the button after adding to cart
    }
}
