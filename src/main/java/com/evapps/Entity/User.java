/**
 * Created by Djidjelly Siclait on 9/25/2016.
 */
package com.evapps.Entity;

import com.evapps.Tools.Enums.Gender;
import com.evapps.Tools.Enums.Permission;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements Serializable{
    // Attributes
    @Id
    private String userId;
    @NotNull
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Date birthDate;
    @NotNull
    private Gender gender;
    @NotNull
    private String password;
    @NotNull
    private Permission role;
    @ManyToOne
    private Clinic clinic;
    @Column(length = 5000000)
    private Byte[] photo;


    // Constructors
    public User(){

    }

    public User(Clinic clinic, String email, String firstName, String lastName, Date birthDate, Gender gender, String password, Permission role){
        this.setUserId("CH-" + clinic.getClinicPrefix() + "-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setEmail(email.toLowerCase());
        this.setFirstName(firstName.toLowerCase());
        this.setLastName(lastName.toUpperCase());
        this.setBirthDate(birthDate);
        this.setGender(gender);
        this.setPassword(password);
        this.setRole(role);
        this.setClinic(clinic);
    }

    //Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

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

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
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
}
