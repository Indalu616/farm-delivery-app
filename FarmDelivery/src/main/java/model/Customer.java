package model;
import java.util.ArrayList;

public class Customer extends User {
    private String deliveryAddress;
    private ArrayList<Product> shoppingCart;

    public Customer(int id, String name, String email,String deliveryAddress){
        super(id,name,email);
        this.deliveryAddress = deliveryAddress;
        shoppingCart = new ArrayList<>();
    }
    @Override
    public void showDetails() {
        System.out.println("Name: " + this.getName() + " ID: " + this.getId() + " Email: " + this.getEmail() + " Address: " + deliveryAddress);
    }
}
