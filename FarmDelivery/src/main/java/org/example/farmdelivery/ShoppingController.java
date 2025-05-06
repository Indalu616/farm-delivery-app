package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import javafx.scene.layout.HBox;

public class ShoppingController {
    public FlowPane productList;

    private ArrayList<Product> products=new ArrayList<>();
    Product product=new Product("Cherry Tomato",
            "https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg",
            20.00);
    Product product1=new Product("Strawberry",
            "https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg",
            20.00);
    Product product2=new Product("Blueberry",
            "https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg",
            20.00);
    Product product3=new Product("Blackberry",
            "https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg",
            20.00);
    Product product4=new Product("Raspberry",
            "https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg",
            20.00);

    public void initialize() {
        productList.getChildren().clear();
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        for (Product product : products) {
          try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/product-card.fxml"));
                HBox productCard = loader.load();
                ProductCard controller = loader.getController();
                controller.setProduct(product);
                productList.getChildren().add(productCard);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void handleAddItem(ActionEvent actionEvent) {
    }

    public void handleViewCart(ActionEvent actionEvent) {
    }


    public void handleHome(ActionEvent actionEvent) {
    }

    public void handleProducts(ActionEvent actionEvent) {
    }

    public void handleCart(ActionEvent actionEvent) {
    }

    public void handleProfile(ActionEvent actionEvent) {
    }

    public void handleLogout(ActionEvent actionEvent) {
    }
}