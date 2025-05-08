package org.example.farmdelivery;
import model.Cart;
import model.Product;
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
       productDescription.setText(product.getDescription());
//       Image image=new Image(product.getImageUrl());
//       productImage.setImage(image);
       addToCartButton.setUserData(product.getProductId());
    }
    public void addToCart(ActionEvent event) throws IOException {
        int id = (int) ((Button) event.getSource()).getUserData();
        Cart cart=new Cart();
        cart.addToCartProducts(id);
    }
}
