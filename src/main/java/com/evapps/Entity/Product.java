/**
 * Created by Djidjelly Siclait on 11/1/2016.
 */
package com.evapps.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "items")
public class Product implements Serializable {
    //Attributes
    @Id
    private String productId;
    private String productName;
    private String supplier;
    private String productDescription;
    private Float productPrice;
    private Integer productInStock;


    // Constructors
    public Product(){

    }

    public Product(Clinic clinic, String productName, String supplier, String productDescription, Float productPrice, Integer productInStock){
        this.setProductId(clinic.getClinicPrefix() + "-ITEM-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
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
}
