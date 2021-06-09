package com.omkar.mybbshop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BBClientLogin implements Serializable {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @SerializedName("email")
    public String email;

    @SerializedName("pwd")
    public String pwd;


    public BBClientLogin(String email,String pwd){

        this.email =email;
        this.pwd =pwd;
    }

}
