package com.omkar.mybbshop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BBClient implements Serializable {
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @SerializedName("cid")
    public String cid;

    @SerializedName("email")
    public String email;

    @SerializedName("contact")
    public String contact;

    @SerializedName("pwd")
    public String pwd;


 public  BBClient( String cid, String email, String contact, String pwd)
 {
     this.cid=cid;
     this.contact=contact;
     this.email=email;
     this.pwd=pwd;
 }








}
