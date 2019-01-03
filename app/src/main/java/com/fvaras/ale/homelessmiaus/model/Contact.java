package com.fvaras.ale.homelessmiaus.model;

/**
 * Created by Alejandro on 23-10-2017.
 */

public class Contact {
    private int id;
    private String nom;
    private String phone;
    private String email;
    private String password;
    private  int avatar;
    private int pets;

    public Contact() {

    }

    public int getId() {
        return id;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPets() {
        return pets;
    }

    public void setPets(int pets) {
        this.pets = pets;
    }
}
