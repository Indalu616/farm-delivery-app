package org.example.farmdelivery;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML
    public TextField productNameField;
    @FXML
    public TextArea descriptionField;
    @FXML
    public ImageView imagePreview;
    @FXML
    public Button uploadImageBtn;
    @FXML
    public Button addBtn;
    @FXML
    public Button selectCalendar;
    @FXML
    public StackPane imageCalendarUploadBox;
    @FXML
    private StackPane mainContent;



    public void initialize() {

    }
    @FXML
    private void loadCalendarSelect() {
        DatePicker calendar = new DatePicker();
        VBox calendarBox = new VBox(5,calendar);
        calendarBox.setPadding(new Insets(20));
        calendarBox.setStyle("-fx-background-color: #E8F5E9; -fx-border-color: #ccc; -fx-border-radius: 5px; -fx-alignment: start; -fx-max-width: 200px;");
        imageCalendarUploadBox.getChildren().add(calendarBox);
    }
    @FXML
    private void showAddPage() throws IOException {
        AnchorPane addPage = FXMLLoader.load(getClass().getResource("add-product.fxml"));
        String addPageCss = getClass().getResource("dashboard.css").toExternalForm();
        mainContent.getChildren().setAll(addPage);
        mainContent.getStylesheets().add(addPageCss);
    }

    @FXML
    private void showProducts() throws IOException {
        AnchorPane addPage = FXMLLoader.load(getClass().getResource("product-list.fxml"));
        String addPageCss = getClass().getResource("dashboard.css").toExternalForm();
        mainContent.getChildren().setAll(addPage);
        mainContent.getStylesheets().add(addPageCss);
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

    @FXML
    private void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        Stage stage = (Stage) uploadImageBtn.getScene().getWindow();
        var file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imagePreview.setImage(image);
        }
    }


}
