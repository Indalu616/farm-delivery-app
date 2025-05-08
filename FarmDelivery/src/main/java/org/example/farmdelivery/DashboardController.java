package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Product;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

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
    public TableView productTable;
    public TextField productPriceField;
    @FXML
    public FlowPane mainContent;

    private ArrayList<Product> products = new ArrayList<>();

    DatePicker calendar;

    public void initialize() {
        showProducts();
    }

    @FXML
    private void loadCalendarSelect() {
        calendar = new DatePicker();
        VBox calendarBox = new VBox(5, calendar);
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

//    @FXML
//    private void showProducts() throws IOException {
//        AnchorPane addPage = FXMLLoader.load(getClass().getResource("product-list.fxml"));
//        String addPageCss = getClass().getResource("dashboard.css").toExternalForm();
//        mainContent.getChildren().setAll(addPage);
//        mainContent.getStylesheets().add(addPageCss);
//    }

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

    @FXML
    public void handleAddProduct(ActionEvent actionEvent) {
        try {
            String productName = productNameField.getText().trim();
            String description = descriptionField.getText().trim();
            String priceText = productPriceField.getText().trim();

            // Null check for calendar and image
            if (calendar == null || calendar.getValue() == null) {
                showAlert(Alert.AlertType.ERROR, "Please select a harvest date.");
                return;
            }

            if (imagePreview.getImage() == null || imagePreview.getImage().getUrl() == null) {
                showAlert(Alert.AlertType.ERROR, "Please upload a product image.");
                return;
            }

            if (productName.isEmpty() || description.isEmpty() || priceText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Please fill in all fields.");
                return;
            }

            double price = Double.parseDouble(priceText);
            if (price <= 0) {
                showAlert(Alert.AlertType.ERROR, "Price must be greater than zero.");
                return;
            }

            String imageUrl = imagePreview.getImage().getUrl();
            String harvestDate = calendar.getValue().toString();
            String quantity = "5";

            // Define path once and reuse it
            String filePath = "C:\\Users\\DELL\\Documents\\Programming-files\\Java\\farm-delivery-app\\FarmDelivery\\src\\main\\resources\\org\\example\\farmdelivery\\data\\products.txt";
            Path productPath = Paths.get(filePath);

            // Count the existing lines to assign product ID
            long lines = Files.lines(productPath, StandardCharsets.ISO_8859_1).count();
            String productId = String.valueOf(lines + 1);

            // Write new product to file
            try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                fileWriter.write(productId + "," + productName + "," + description + "," + price + "," + quantity + "," + harvestDate + "," + imageUrl + "\n");
            }

            // Clear the form
            productNameField.clear();
            descriptionField.clear();
            productPriceField.clear();
            imagePreview.setImage(null);
            calendar.setValue(null);

            showAlert(Alert.AlertType.INFORMATION, "Product added successfully!");

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid price. Please enter a valid number.");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Failed to save product. Error: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message, ButtonType.OK);
        alert.showAndWait();
    }

    private void getProducts(){
        String path = "C:\\Users\\DELL\\Documents\\Programming-files\\Java\\farm-delivery-app\\FarmDelivery\\src\\main\\resources\\org\\example\\farmdelivery\\data\\products.txt";

        try(BufferedReader Reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = Reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                int productId = Integer.parseInt(productDetails[0]);
                String name = productDetails[1];
                String description = productDetails[2];
                double price = Double.parseDouble(productDetails[3]);
                int quantityAvailable = Integer.parseInt(productDetails[4]);
                LocalDate harvestDate = LocalDate.parse(productDetails[5]);
                String imageUrl = productDetails[6];

                Product product = new Product(productId, name, description, price, quantityAvailable, harvestDate,imageUrl);
                products.add(product);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    @FXML
    private void showProducts() {
        getProducts();
        for (Product product : products) {
            try {
                System.out.println("Product Name: "+product.getName());
                System.out.println("Product Price: "+product.getPrice());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/cart-card.fxml"));
                HBox productCard = loader.load();
                CartCard controller = loader.getController();
                controller.setProductDetails(product);
                mainContent.getChildren().add(productCard);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


