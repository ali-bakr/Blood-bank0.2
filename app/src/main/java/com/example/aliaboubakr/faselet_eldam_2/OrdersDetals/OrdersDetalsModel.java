package com.example.aliaboubakr.faselet_eldam_2.OrdersDetals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class OrdersDetalsModel {


    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private OrdersDetalsData ordersDetalsData;

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

    public OrdersDetalsData getOrdersDetalsData() {
        return ordersDetalsData;
    }

    public void setData(OrdersDetalsData ordersDetalsData) {
        this.ordersDetalsData = ordersDetalsData;
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

    }

    public class OrdersDetalsData {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("client_id")
        @Expose
        private String clientId;
        @SerializedName("patient_name")
        @Expose
        private String patientName;
        @SerializedName("patient_age")
        @Expose
        private String patientAge;
        @SerializedName("blood_type_id")
        @Expose
        private String bloodTypeId;
        @SerializedName("bags_num")
        @Expose
        private String bagsNum;
        @SerializedName("hospital_name")
        @Expose
        private String hospitalName;
        @SerializedName("hospital_address")
        @Expose
        private String hospitalAddress;
        @SerializedName("city_id")
        @Expose
        private String cityId;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("notes")
        @Expose
        private String notes;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("city")
        @Expose
        private City city;
        @SerializedName("client")
        @Expose
        private Client client;
        @SerializedName("blood_type")
        @Expose
        private BloodType bloodType;
        @SerializedName("notification")
        @Expose
        private Notification notification;

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

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getPatientAge() {
            return patientAge;
        }

        public void setPatientAge(String patientAge) {
            this.patientAge = patientAge;
        }

        public String getBloodTypeId() {
            return bloodTypeId;
        }

        public void setBloodTypeId(String bloodTypeId) {
            this.bloodTypeId = bloodTypeId;
        }

        public String getBagsNum() {
            return bagsNum;
        }

        public void setBagsNum(String bagsNum) {
            this.bagsNum = bagsNum;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public String getHospitalAddress() {
            return hospitalAddress;
        }

        public void setHospitalAddress(String hospitalAddress) {
            this.hospitalAddress = hospitalAddress;
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

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public BloodType getBloodType() {
            return bloodType;
        }

        public void setBloodType(BloodType bloodType) {
            this.bloodType = bloodType;
        }

        public Notification getNotification() {
            return notification;
        }

        public void setNotification(Notification notification) {
            this.notification = notification;
        }

    }

    public class Notification {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("donation_request_id")
        @Expose
        private String donationRequestId;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDonationRequestId() {
            return donationRequestId;
        }

        public void setDonationRequestId(String donationRequestId) {
            this.donationRequestId = donationRequestId;
        }

    }
}
