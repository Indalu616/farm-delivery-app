package org.example.farmdelivery;


import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class DashboardController {

    @FXML
    private StackPane mainContent;


    @FXML
    private void loadUploadContent() {
        DatePicker calendar = new DatePicker();
        VBox uploadBox = new VBox(10, new Label("Choose a date:"), calendar);
        uploadBox.setPadding(new Insets(20));
        mainContent.getChildren().setAll(uploadBox);
    }

    @FXML
    private void showAddPage() {
        Label addLabel = new Label("Add Product Page");
        mainContent.getChildren().setAll(addLabel);
    }

    @FXML
    private void showProducts() {
        Label productsLabel = new Label("List of Products");
        mainContent.getChildren().setAll(productsLabel);
    }

    @FXML
    private void showOrders() {
        Label ordersLabel = new Label("Order List");
        mainContent.getChildren().setAll(ordersLabel);
    }

    @FXML
    private void showLogOut() {
        Label logoutLabel = new Label("You are logged out.");
        mainContent.getChildren().setAll(logoutLabel);
    }

}
