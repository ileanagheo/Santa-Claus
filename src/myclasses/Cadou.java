package myclasses;

import enums.Category;

public class Cadou {
    //Clasa de tip Cadou ce contine datele unui cadou.

    private String productName;
    private double price;
    private Category category;

    public Cadou() {
    }

    public Cadou(String productName, double price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public final String getProductName() {
        return productName;
    }

    public final double getPrice() {
        return price;
    }

    public final Category getCategory() {
        return category;
    }

    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    public final void setPrice(final double price) {
        this.price = price;
    }

    public final void setCategory(final Category category) {
        this.category = category;
    }

    public int compareTo(Cadou o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
