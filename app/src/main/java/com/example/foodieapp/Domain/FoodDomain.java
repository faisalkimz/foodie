package com.example.foodieapp.Domain;

public class FoodDomain {
    private String title;
    private String pic;
    private String description;
    private int fee;
    private int numberincart;

    public FoodDomain(String title, String pic, String description, int fee) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
    }

    public FoodDomain(String title, String pic, String description, int fee, int numberincart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.numberincart = numberincart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getNumberincart() {
        return numberincart;
    }

    public void setNumberincart(int numberincart) {
        this.numberincart = numberincart;
    }
}
