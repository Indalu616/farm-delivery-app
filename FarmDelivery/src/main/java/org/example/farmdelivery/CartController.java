package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import model.Product;

import java.util.ArrayList;

public class CartController {

private ArrayList<Product> cartProducts = new ArrayList<>();
    public FlowPane cartContainer;

    public void handleDashBoard(ActionEvent actionEvent) {

    }

//    public void initialize(){
//        for (Product product : cartProducts) {
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/product-card.fxml"));
//                HBox productCard = loader.load();
//                ProductCard controller = loader.getController();
//                controller.setProduct(product);
//                cartContainer.getChildren().add(productCard);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public void addItemToCart(Product product){
        System.out.println("Product Name: "+product.getName());
        System.out.println("Product Price: "+product.getPrice());
        this.cartProducts.add(product);
    }
}
