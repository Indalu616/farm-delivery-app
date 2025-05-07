package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import model.Cart;
import model.Product;

import java.util.ArrayList;

public class CartController {
    public ImageView productImage;

    @FXML
    private ArrayList<Product> cartProducts;
    @FXML
    public FlowPane cartContainer;

    @FXML
    public void handleDashBoard(ActionEvent actionEvent) {

    }

    @FXML
    public void initialize(){
        Cart cart=new Cart();
        cartProducts=cart.getCartProducts();
        System.out.println(cartProducts.size());
        for (Product product : cartProducts) {
            try {
                System.out.println("Product Name: "+product.getName());
                System.out.println("Product Price: "+product.getPrice());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/cart-card.fxml"));
                HBox productCard = loader.load();
                CartCard controller = loader.getController();
                controller.setProductDetails(product);
                cartContainer.getChildren().add(productCard);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void addItemToCart(Product product){
        System.out.println("Product Name: "+product.getName());
        System.out.println("Product Price: "+product.getPrice());
        this.cartProducts.add(product);
    }
}
