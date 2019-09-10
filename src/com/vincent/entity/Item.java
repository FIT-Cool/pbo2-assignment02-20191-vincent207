package com.vincent.entity;

/**
 * @author : Vincent Gunaeri (1772001)
 * Kelas Item, object pada program yang akan dicatat ke TableView program
 */
public class Item  {
    private String name;
    private double price;
    private Category category;

    /**
     * getter
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setter
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * getter
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * getter
     * @return
     * mereturn nama private attribute
     */
    public String getName() {
        return name;
    }

    /**
     * seetter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
