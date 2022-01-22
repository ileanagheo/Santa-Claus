package myclasses;

import enums.Category;

public class Cadou {
    private String productName;
    private double price;
    private Category category;
    private Integer quantity;

    /**
     */
    public Cadou() {
    }

    /**
     * @param productName
     * @param price
     * @param category
     * @param quantity
     */
    public Cadou(final String productName, final double price, final Category category,
                 final Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
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
     * @return
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @param o
     * @return
     */
    public int compareTo(final Cadou o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
