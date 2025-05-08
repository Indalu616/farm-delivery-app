package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;
import model.Cart;
import model.MyCartProduct;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CartController {
    public ImageView productImage;
    public Label grandTotal;

    @FXML
    private ArrayList<MyCartProduct> cartProducts;
    @FXML
    public FlowPane cartContainer;
    private int totalPrice=0;

    @FXML
    public void handleDashBoard(ActionEvent event) throws IOException {
        Parent shoppingRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/farmdelivery/shopping-page.fxml")));
        Scene shoppingScene = new Scene(shoppingRoot);

        String shoppingCss = getClass().getResource("/org/example/farmdelivery/shopping.css").toExternalForm();
        shoppingScene.getStylesheets().add(shoppingCss);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(shoppingScene);
        stage.setTitle("UAE FARM");
        stage.show();
    }
    @FXML
    public void initialize(){
        Cart cart=new Cart();
        cartProducts=cart.getCartProducts();

        System.out.println(cartProducts.size());
        for (MyCartProduct product : cartProducts) {
            try {
                totalPrice+=product.getPrice();
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
        grandTotal.setText("Grand Total: AED "+totalPrice);
    }
//    public void addItemToCart(Product product){
//        System.out.println("Product Name: "+product.getName());
//        System.out.println("Product Price: "+product.getPrice());
//        this.cartProducts.add(product);
//    }
}
