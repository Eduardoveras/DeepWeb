/**
 * Created by Djidjelly Siclait on 9/25/2016.
 */
package com.evapps.Entity;

import com.evapps.Tools.Enums.AccountStatus;
import com.evapps.Tools.Enums.Permission;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable{
    // Attributes
    @Id
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Column(length = 1000)
    private String shippingAddress;
    @NotNull
    private String password;
    @NotNull
    private Permission role;
    @NotNull
    private AccountStatus status;
    @Column(length = 5000000)
    private Byte[] photo;


    // Constructors
    public User(){

    }

    public User(String email, String firstName, String lastName, String shippingAddress, String password, Permission role){
        this.setEmail(email.toLowerCase());
        this.setFirstName(firstName.toLowerCase());
        this.setLastName(lastName.toUpperCase());
        this.setShippingAddress(shippingAddress);
        this.setPassword(password);
        this.setRole(role);
        this.setStatus(AccountStatus.SUSPENDED); // Changes once receive confirmation email
    }

    //Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() { return firstName.toUpperCase() + " " + lastName; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Permission getRole() {
        return role;
    }

    public void setRole(Permission role) {
        this.role = role;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public String displayPhoto(){
        if(this.photo == null)
            return null;

        byte[] imgBytesAsBase64 = Base64.encodeBase64(toPrimitives(this.photo));
        return new String(imgBytesAsBase64);
    }

    // Auxiliary Function
    private byte[] toPrimitives(Byte[] buffer) {

        byte[] bytes = new byte[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            bytes[i] = buffer[i];
        }
        return bytes;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
