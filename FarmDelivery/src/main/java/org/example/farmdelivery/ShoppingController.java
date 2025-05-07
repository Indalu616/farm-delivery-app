package org.example.farmdelivery;

import model.Product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.ProductInventory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ShoppingController {
    ProductInventory productInventory=new ProductInventory();
    private ArrayList<Product> displayProduct;
    public FlowPane productList;
    public ComboBox categoryComboBox;
    public ComboBox sortComboBox;
    public ComboBox searchComboBox;
    public ComboBox sortNameComboBox;
    public Button searchButton;
    public TextField searchBox;

    private ArrayList<Product> products;
    private List<Product> searchedProducts=new ArrayList<>();

    private ArrayList<Product> decreasingList;
    private String howToSort;

//        this.productId = productId;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.quantityAvailable = quantityAvailable;
//        this.harvestDate = harvestDate;
//        this.imageUrl=imageUrl;
    Product prod=new Product(1,"Cherry","Cherry is amazing",20,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod1=new Product(2,"Tomato","Tomato is super sweet",21,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod2=new Product(3,"Avocado","Avocado is amazing",100,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod3=new Product(4,"Potato","Potato is amazing",28,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");
    Product prod4=new Product(5,"StrawBerry","Strawberry is amazing",40,1,LocalDate.now(),"https://i.pinimg.com/736x/26/6c/82/266c82c35ea3e95a62a0ab7a46b55212.jpg");


    public void initialize() {
        productList.getChildren().clear();
        products= productInventory.getProductInventory();

        if(howToSort!=null && howToSort.equals("increasing")){
            displayProduct=productInventory.getIncreasinglySortedProducts();
        } else if (howToSort!=null && howToSort.equals("decreasing")) {
            displayProduct=productInventory.getDecreasingSortedProducts();
        }else{
            displayProduct=productInventory.getProductInventory();
        }

        System.out.println(searchBox.getText());
        if(!searchedProducts.isEmpty()){
            for (int i=0;i<searchedProducts.size();i++) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/product-card.fxml"));
                    HBox productCard = loader.load();
                    ProductCard controller = loader.getController();
                    controller.setProduct(searchedProducts.get(i));
                    productList.getChildren().add(productCard);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            for (int j=0;j<products.size();j++) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/product-card.fxml"));
                    HBox productCard = loader.load();
                    ProductCard controller = loader.getController();
                    controller.setProduct(products.get(j));
                    productList.getChildren().add(productCard);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @FXML

    public void handleAddItem(ActionEvent actionEvent) {
        // Add item logic here
    }

    public void handleViewCart(ActionEvent actionEvent) {
        // View cart logic here
    }

    @FXML
    private void handleDashBoard(ActionEvent event) throws IOException {
        BorderPane dashboardRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/farmdelivery/farmer-dashboard.fxml")));
        Scene dashboardScene = new Scene(dashboardRoot);

        String dashboardCss = getClass().getResource("/org/example/farmdelivery/dashboard.css").toExternalForm();
        dashboardScene.getStylesheets().add(dashboardCss);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(dashboardScene);
        stage.setTitle("Dashboard");
        stage.show();
    }

    public void handleHome(ActionEvent actionEvent) {
        // Home button logic
    }

    public void handleProducts(ActionEvent actionEvent) {
        // Products button logic
    }

    public void handleCart(ActionEvent event) throws IOException {
        // Cart button logic
        Parent cartRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/farmdelivery/cart.fxml")));
        Scene cartScene = new Scene(cartRoot);

        String cartCss = getClass().getResource("/org/example/farmdelivery/cart.css").toExternalForm();
        cartScene.getStylesheets().add(cartCss);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(cartScene);
        stage.setTitle("Cart Summary");
        stage.show();
    }

    public void handleProfile(ActionEvent actionEvent) {
        // Profile button logic
    }

    public void handleLogout(ActionEvent actionEvent) {
        // Logout logic
    }


//    a method to search products by their Name
    public void handleSearch(ActionEvent event) {
        searchedProducts=products.stream().filter(product->product.getName().toLowerCase().contains(searchBox.getText().toLowerCase()))
                .collect(Collectors.toList());
//        products.clear();
        initialize();
    }

//    a method to sort products in increasing order of price
    public void sortInIncreasingPrice(){
         howToSort="increasing";
        productList.getChildren().clear();
        initialize();
    }
    public void sortDecreasingPrice(){
        howToSort="decreasing";
        productList.getChildren().clear();
        initialize();

    }
}
