package org.example.farmdelivery;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class LoginController {
    public TextField usernameField;
    public PasswordField passwordField;
    public boolean isSigningUp = true;
    public TextField emailField;
    public HBox emailHBox;
    public VBox listOfFields;
    public HBox headerLogin;
    public Button loginAccBtn;
    public Button createAccBtn;
    @FXML
    private ComboBox<String> comboSelect;


    @FXML
    private void initialize() {
        handleCreateAccount(null);
    }
    public void handleLoginButtonAction(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String selectedRole = comboSelect.getSelectionModel().getSelectedItem();



        if (!isSigningUp && authenticate(username, password)){

           loadMainPage(selectedRole);
        }
        else if(isSigningUp){
            registerUser(username, password,email);
            loadMainPage(selectedRole);
        }
        else {
            System.out.println("Invalid username or password.");
        }
    }

    private void loadMainPage(String comboValue) throws IOException {
        FXMLLoader loader;
        String loginCss;
        if(comboValue.equals("Farmer")){
            loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/farmer-dashboard.fxml"));
            loginCss = getClass().getResource("/org/example/farmdelivery/dashboard.css").toExternalForm();
        }
        else{
            loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/shopping-page.fxml"));
            loginCss = getClass().getResource("/org/example/farmdelivery/styles.css").toExternalForm();
        }
        Parent root = loader.load();
        // Set the new scene to the current stage
        Scene scene = new Scene(root);
        scene.getStylesheets().add(loginCss);
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    private static boolean authenticate(String username, String password) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Documents\\Programming-files\\Java\\farm-delivery-app\\FarmDelivery\\src\\main\\resources\\org\\example\\farmdelivery\\data\\credentials.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 3) {
                    if (parts[0].equals(username) && parts[1].equals(password)) {
                        reader.close();
                        return true;
                    }

                }
            }
            reader.close();
            return false;
        }

    private static void registerUser(String username, String password,String email) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\DELL\\Documents\\Programming-files\\Java\\farm-delivery-app\\FarmDelivery\\src\\main\\resources\\org\\example\\farmdelivery\\data\\credentials.txt", true);
        writer.write(username + ":" + password + ":" + email + "\n");
        writer.close();
    }

    public void handleCreateAccount(ActionEvent actionEvent) {
        if(!isSigningUp) {
            isSigningUp = true;
            listOfFields.getChildren().add(1,emailHBox);
            loginAccBtn.setText("Create Account");
            createAccBtn.setText("Login");
        }
        else {
            isSigningUp = false;
            listOfFields.getChildren().remove(emailHBox);
            loginAccBtn.setText("Login");
            createAccBtn.setText("Create Account");
        }
    }
}
