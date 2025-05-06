package model;
import java.util.ArrayList;

public class Customer extends User {
    private String deliveryAddress;
    private ArrayList<Product> shoppingCart;

    public Customer(int id, String name, String email){
        super(id,name,email);
        shoppingCart = new ArrayList<>();
    }

    public void setDeliveryAddress(String deliveryAddress) {
        if(deliveryAddress == null || deliveryAddress.trim().equals("")){
            throw new IllegalArgumentException("Delivery address can't be empty");
        }
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: " + this.getName() + " ID: " + this.getId() + " Email: " + this.getEmail() + " Address: " + deliveryAddress);
    }
}
