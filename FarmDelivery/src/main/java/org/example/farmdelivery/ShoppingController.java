package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
<<<<<<< HEAD
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
=======
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
>>>>>>> 2d282f805c369c30b1656550d77a7757769f781e
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ShoppingController {
    public FlowPane productList;
    public ComboBox categoryComboBox;
    public ComboBox sortComboBox;
    public ComboBox searchComboBox;
    public ComboBox sortNameComboBox;
    public Button searchButton;
    public TextField searchBox;

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
        categoryComboBox.getItems().addAll("All","Milk Products","Fruits","Vegetables","Cereal Products");
        sortComboBox.getItems().addAll("Descending","Ascending");


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


<<<<<<< HEAD
    @FXML
    private void handleDashBoard(ActionEvent event) throws IOException, IOException {
        BorderPane dashboardRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/farmdelivery/farmer-dashboard.fxml")));
        Scene dashboardScene = new Scene(dashboardRoot);

        String dashboardCss = getClass().getResource("/org/example/farmdelivery/styles.css").toExternalForm();
        dashboardScene.getStylesheets().add(dashboardCss);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(dashboardScene);
        stage.setTitle("Dashboard");
        stage.show();
=======
    public void handleHome(ActionEvent actionEvent) {
    }

    public void handleProducts(ActionEvent actionEvent) {
    }

    public void handleCart(ActionEvent actionEvent) {
    }

    public void handleProfile(ActionEvent actionEvent) {
    }

    public void handleLogout(ActionEvent actionEvent) {
>>>>>>> 2d282f805c369c30b1656550d77a7757769f781e
    }
}