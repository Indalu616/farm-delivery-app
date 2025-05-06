package org.example.farmdelivery;


import javafx.event.ActionEvent;
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
    private void loadHomeContent() {
        Label homeLabel = new Label("Welcome to the Dashboard Home!");
        mainContent.getChildren().setAll(homeLabel);
    }

    @FXML
    private void loadUploadContent() {
        DatePicker calendar = new DatePicker();
        VBox uploadBox = new VBox(10, new Label("Choose a date:"), calendar);
        uploadBox.setPadding(new Insets(20));
        mainContent.getChildren().setAll(uploadBox);
    }

    public void showImageUploader(ActionEvent actionEvent) {
    }

    public void showCalendar(ActionEvent actionEvent) {
    }

    public void showHome(ActionEvent actionEvent) {
    }
}
