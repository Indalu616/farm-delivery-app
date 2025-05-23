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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CartController {
    public ImageView productImage;
    public Label grandTotal;

    @FXML
    private ArrayList<MyCartProduct> cartProducts=new ArrayList<>();
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
        getCartProducts();
        System.out.println("Clicked");

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



    public void getCartProducts(){
        System.out.println("Called");

        try(InputStream inputStream = getClass().getResourceAsStream("/files/cart.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        ){
            String line;
            while((line=reader.readLine())!=null){
                String[] strArr=line.split(",");
                System.out.println(Arrays.toString(strArr));
                if(strArr.length == 5){
                    String prodName=strArr[0];
                    int prodPrice=Integer.parseInt(strArr[1]);
                    int prodQuantity=Integer.parseInt(strArr[2]);
                    int prodId=Integer.parseInt(strArr[3]);
                    String imageUrl=strArr[4];
                    MyCartProduct myCartProduct=new MyCartProduct(prodName,imageUrl,prodQuantity,prodPrice,prodId);
                    boolean isAlreadyAdded=false;
                    for(MyCartProduct prod:cartProducts){
                        if(prod.getId()==prodId){
                            prod.increaseQuantity();
                            System.out.println("found");
                            isAlreadyAdded=true;
                            System.out.println(prod.getQuantity());
                            break;
                        }
                    }
                    if(!isAlreadyAdded){
                        cartProducts.add(myCartProduct);
                    }
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
