package com.robboba.mha.model;

import com.google.firebase.firestore.IgnoreExtraProperties;

/**
 * Created by kevin on 2018-04-
 *
 * POJO
 */

@IgnoreExtraProperties
public class Professional {
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_ADDRESS1 = "address1";
    //public static final String FIELD_ADDRESS2= "address2";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_TYPE = "type";

    private String name;
    private String phone;
    private String address1;
    //private String address2;
    private String city;
    private String type;

    public Professional() {}

    public Professional(String name, String phone, String type,
                String address1, String city) {
        this.name = name;
        this.phone = phone;
        this.address1 = address1;
        //this.address2 = address2;
        this.city = city;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    //public String getAddress2() {return address2;}
    //public void setAddress2(String address2) {this.address2 = address2;}

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}


