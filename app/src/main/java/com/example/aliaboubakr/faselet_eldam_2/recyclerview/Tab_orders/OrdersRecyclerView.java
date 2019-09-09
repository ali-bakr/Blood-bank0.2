package com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_orders;

import java.util.List;

public class OrdersRecyclerView {
    private String name_orders;
    private String hospital_orders;
    private String city_orders;
    private String blodType_orders;

 /*
   List<OrdersModel.Datum> data;
    public OrdersRecyclerView(List<OrdersModel.Datum> data) {
        this.data=data;
    }
*/
    public void setName_orders(String name_orders) {
        this.name_orders = name_orders;
    }

    public void setHospital_orders(String hospital_orders) {
        this.hospital_orders = hospital_orders;
    }

    public void setCity_orders(String city_orders) {
        this.city_orders = city_orders;
    }

    public void setBlodType_orders(String blodType_orders) {
        this.blodType_orders = blodType_orders;
    }

    public String getName_orders() {
        return name_orders;
    }

    public String getHospital_orders() {
        return hospital_orders;
    }

    public String getCity_orders() {
        return city_orders;
    }

    public String getBlodType_orders() {
        return blodType_orders;
    }


}
