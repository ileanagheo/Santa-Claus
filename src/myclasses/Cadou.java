package myclasses;

import enums.Category;

public class Cadou {
    //Clasa de tip Cadou ce contine datele unui cadou.
    private String productName;
    private double price;
    private Category category;

    /**
     */
    public Cadou() {
    }

    /**
     * @param productName
     * @param price
     * @param category
     */
    public Cadou(final String productName, final double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    /**
     * @return
     */
    public final String getProductName() {
        return productName;
    }

    /**
     * @return
     */
    public final double getPrice() {
        return price;
    }

    /**
     * @return
     */
    public final Category getCategory() {
        return category;
    }

    /**
     * @param productName
     */
    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * @param price
     */
    public final void setPrice(final double price) {
        this.price = price;
    }

    /**
     * @param category
     */
    public final void setCategory(final Category category) {
        this.category = category;
    }

    /**
     * @param o
     * @return
     */
    public int compareTo(final Cadou o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
