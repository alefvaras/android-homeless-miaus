package com.fvaras.ale.homelessmiaus.model;

/**
 * Created by Alejandro on 02-11-2017.
 */

public class Provider {

    private  int id;
    private String nomBusiness;
    private String phone;
    private String email;
    private String turn;
    private String razonSocial;
    private String address;

    public Provider() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomBusiness() {
        return nomBusiness;
    }

    public void setNomBusiness(String nomBusiness) {
        this.nomBusiness = nomBusiness;
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

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
