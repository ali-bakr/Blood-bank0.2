package com.example.aliaboubakr.faselet_eldam_2.NewPass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewPassData {
    @SerializedName("pin_code")
    @Expose
    private List<String> pinCode = null;
    @SerializedName("phone")
    @Expose
    private List<String> phone = null;
    @SerializedName("password")
    @Expose
    private List<String> password = null;

    public List<String> getPinCode() {
        return pinCode;
    }

    public void setPinCode(List<String> pinCode) {
        this.pinCode = pinCode;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }
}
