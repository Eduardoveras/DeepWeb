/**
 * Created by Djidjelly Siclait on 11/1/2016.
 */
package com.evapps.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "items")
public class Product implements Serializable {
    //Attributes
    @Id
    @GeneratedValue
    private String productId;
    @NotNull
    private String productName;
    private String supplier;
    private String productDescription;
    @NotNull
    private Float productPrice;
    @NotNull
    private Integer productInStock;
    @Column(length = 500000)
    private Byte[] photo;

    // Constructors
    public Product(){

    }

    public Product(String productName, String supplier, String productDescription, Float productPrice, Integer productInStock){
        this.setProductName(productName);
        this.setSupplier(supplier);
        this.setProductDescription(productDescription);
        this.setProductPrice(productPrice);
        this.setProductInStock(productInStock);
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductInStock() {
        return productInStock;
    }

    public void setProductInStock(Integer productInStock) {
        this.productInStock = productInStock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    // Auxiliary Function
    private byte[] toPrimitives(Byte[] buffer) {

        byte[] bytes = new byte[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            bytes[i] = buffer[i];
        }
        return bytes;
    }
}
