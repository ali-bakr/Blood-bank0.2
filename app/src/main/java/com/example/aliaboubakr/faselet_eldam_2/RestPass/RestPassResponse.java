package com.example.aliaboubakr.faselet_eldam_2.RestPass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestPassResponse {



    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestPassData restPassData;

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

    public RestPassData getRestPassData() {
        return restPassData;
    }

    public void setData(RestPassData restPassData) {
        this.restPassData = restPassData;
    }

}
