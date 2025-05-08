package model;

public class MyCartProduct {
    private String name;
    private int id;
    private String imgUrl;
    private int quantity;
    private int price;
    MyCartProduct(String name,String imgUrl,int quantity,int price,int id){
        this.name=name;
        this.imgUrl=imgUrl;
        this.quantity=quantity;
        this.price=price;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getImgUrl() {
        return imgUrl;
    }

}
