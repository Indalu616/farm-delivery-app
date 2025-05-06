package model;
import java.time.LocalDate;
import java.util.Date;

public class Product {
    private int productId;
    private String name;
    private String description;
    private int price;
    private int quantityAvailable;
    private String imageUrl;
    private LocalDate harvestDate;

    public Product(int productId, String name, String description, int price, int quantityAvailable, LocalDate harvestDate,String imageUrl){
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.harvestDate = harvestDate;
        this.imageUrl=imageUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId){
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price > 0){
            this.price = price;
        }
        else{
            throw new IllegalArgumentException("Price has to be greater than 0");
        }
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        if(harvestDate.isAfter(LocalDate.now())){
            this.harvestDate = harvestDate;
        }
        else{
            throw new IllegalArgumentException("Harvest date has to be after today(in the future)");
        }
    }
}
