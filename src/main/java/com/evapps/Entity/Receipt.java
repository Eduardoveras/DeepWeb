/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "receipts")
public class Receipt implements Serializable {

    // Atributes
    @Id
    private String fiscalCode;
    @ManyToOne
    private User user;
    private ArrayList<Integer> productList;
    private Float total;

    // Constructors
    public Receipt(){

    }

    public Receipt(User user, ArrayList<Integer> productList, Float total){
        this.setFiscalCode(UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setUser(user);
        this.setProductList(productList);
        this.setTotal(total);
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Integer> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Integer> productList) {
        this.productList = productList;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
