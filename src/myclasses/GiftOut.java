package myclasses;

import enums.Category;

public class GiftOut {
    private String productName;
    private double price;
    private Category category;
    /**
     * This is the structure the gifts are shown in output
     * @param productName : Name of the product
     * @param price : Price of the product
     * @param category : Category of the product
     */
    public GiftOut(final String productName, final double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
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
     * @param productName sets the product name
     */
    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * @param price sets the product price
     */
    public final void setPrice(final double price) {
        this.price = price;
    }

    /**
     * @param category sets product category
     */
    public final void setCategory(final Category category) {
        this.category = category;
    }
}
