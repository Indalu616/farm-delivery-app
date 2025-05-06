package model;

import org.example.farmdelivery.Product;

import java.util.ArrayList;

public class DeliverySystem {
     private ArrayList<Product> seasonalProducts=new ArrayList<>();
     private ArrayList<Farmer> farmers=new ArrayList<>();

     private ArrayList<Order> orders=new ArrayList<>();

//     a method to add a product to the seasonal products list
     public void addSeasonalProduct(Product product) {
         seasonalProducts.add(product);
     }
//      a method to get list of products
        public ArrayList<Product> getSeasonalProducts() {
            return seasonalProducts;
        }
//        a method to add Farmer
        public void addFarmer(Farmer farmer) {
            farmers.add(farmer);
        }
//        a method to get list of farmers
        public ArrayList<Farmer> getFarmers() {
            return farmers;
        }
//        a method that processes an order
        public void processOrder(Order order) {
            orders.add(order);
        }

}
