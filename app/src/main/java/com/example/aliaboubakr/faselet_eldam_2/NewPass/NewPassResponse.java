package com.example.aliaboubakr.faselet_eldam_2.NewPass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPassResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private NewPassData newPassData;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public NewPassData getNewPassData() {
        return newPassData;
    }

    public void setNewPassData(NewPassData newPassData) {
        this.newPassData = newPassData;
    }
}
