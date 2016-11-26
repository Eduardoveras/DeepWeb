/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="history")
public class History implements Serializable {
    // Attributes
    @Id
    @GeneratedValue
    private Integer historyId;
    @OneToOne
    private User user;
    @ManyToMany
    private Set<Product> browsingHistory;
    @ManyToMany
    private Set<Product> shoppingCart;

    // Constructors
    public History(){

    }

    public History(User user) {
        this.setUser(user);
        this.setBrowsingHistory(new HashSet<>());
        this.setShoppingCart(new HashSet<>());
    }

    // Getters and Setters
    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getBrowsingHistory() {
        return browsingHistory;
    }

    public void setBrowsingHistory(Set<Product> browsingHistory) {
        this.browsingHistory = browsingHistory;
    }

    public Set<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Set<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
