package com.example.aliaboubakr.faselet_eldam_2.MyInformation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class MyInfoModel{







    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private Client.MyInfoData myInfoData;

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

    public Client.MyInfoData getMyInfoData() {
        return myInfoData;
    }

    public void setData(Client.MyInfoData myInfoData) {
        this.myInfoData = myInfoData;
    }











    public class BloodType {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }



    public class City {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("governorate_id")
        @Expose
        private String governorateId;
        @SerializedName("governorate")
        @Expose
        private Governorate governorate;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGovernorateId() {
            return governorateId;
        }

        public void setGovernorateId(String governorateId) {
            this.governorateId = governorateId;
        }

        public Governorate getGovernorate() {
            return governorate;
        }

        public void setGovernorate(Governorate governorate) {
            this.governorate = governorate;
        }

    }


    public class Client {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("birth_date")
        @Expose
        private String birthDate;
        @SerializedName("city_id")
        @Expose
        private String cityId;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("donation_last_date")
        @Expose
        private String donationLastDate;
        @SerializedName("blood_type_id")
        @Expose
        private String bloodTypeId;
        @SerializedName("is_active")
        @Expose
        private String isActive;
        @SerializedName("pin_code")
        @Expose
        private String pinCode;
        @SerializedName("can_donate")
        @Expose
        private Boolean canDonate;
        @SerializedName("city")
        @Expose
        private City city;
        @SerializedName("blood_type")
        @Expose
        private BloodType bloodType;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDonationLastDate() {
            return donationLastDate;
        }

        public void setDonationLastDate(String donationLastDate) {
            this.donationLastDate = donationLastDate;
        }

        public String getBloodTypeId() {
            return bloodTypeId;
        }

        public void setBloodTypeId(String bloodTypeId) {
            this.bloodTypeId = bloodTypeId;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        public Boolean getCanDonate() {
            return canDonate;
        }

        public void setCanDonate(Boolean canDonate) {
            this.canDonate = canDonate;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public BloodType getBloodType() {
            return bloodType;
        }

        public void setBloodType(BloodType bloodType) {
            this.bloodType = bloodType;
        }




        public class MyInfoData {

            @SerializedName("client")
            @Expose
            private Client client;

            public Client getClient() {
                return client;
            }

            public void setClient(Client client) {
                this.client = client;
            }

        }

        }


    public class Governorate {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }




}

