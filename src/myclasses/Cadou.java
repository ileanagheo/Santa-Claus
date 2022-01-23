package myclasses;

import enums.Category;

public class Cadou {
    private String productName;
    private double price;
    private Category category;
    private Integer quantity;

    public Cadou() {
    }

    /**
     * @param productName : name of the product
     * @param price : price of the product
     * @param category : category of the product
     * @param quantity : quantity of the product
     */
    public Cadou(final String productName, final double price, final Category category,
                 final Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     * @return productName
     */
    public final String getProductName() {
        return productName;
    }

    /**
     * @return price
     */
    public final double getPrice() {
        return price;
    }

    /**
     * @return category
     */
    public final Category getCategory() {
        return category;
    }

    /**
     * @param productName sets product name
     */
    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * @param price sets price
     */
    public final void setPrice(final double price) {
        this.price = price;
    }

    /**
     * @param category sets category
     */
    public final void setCategory(final Category category) {
        this.category = category;
    }

    /**
     * @return quantiy
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity sets quantity
     */
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @param o compares two products according to their price
     * @return and returns the one with the lower price
     */
    public int compareTo(final Cadou o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
