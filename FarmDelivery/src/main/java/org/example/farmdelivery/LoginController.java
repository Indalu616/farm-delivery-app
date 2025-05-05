package org.example.farmdelivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField usernameField;
    public PasswordField passwordField;

    public void handleLoginButtonAction(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
//        we have a model which stores logged in users
//        UserModel userModel = new UserModel();
//        check if the user have an account and validate the password
        // Perform login logic here
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
//            redirect to the next screen
            // For example, you can load a new FXML file for the next screen
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/farmdelivery/shopping-page.fxml"));
             Parent root = loader.load();
                // Set the new scene to the current stage
            String loginCss = getClass().getResource("/org/example/farmdelivery/styles.css").toExternalForm();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(loginCss);
             Stage stage = (Stage) usernameField.getScene().getWindow();
             stage.setScene(scene);
             stage.show();
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            // Proceed to the next screen or perform any other action
        } else {
            System.out.println("Invalid username or password.");
            // Show an error message or take appropriate action
        }
    }
}
