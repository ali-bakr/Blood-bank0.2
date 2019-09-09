package com.example.aliaboubakr.faselet_eldam_2.DonationOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderData {


    @SerializedName("blood_type_id")
    @Expose
    private List<String> bloodTypeId = null;

    public List<String> getBloodTypeId() {
        return bloodTypeId;
    }

    public void setBloodTypeId(List<String> bloodTypeId) {
        this.bloodTypeId = bloodTypeId;
    }
}