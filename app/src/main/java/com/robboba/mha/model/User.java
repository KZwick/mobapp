package com.robboba.mha.model;

/**
 * Created by kevin on 2018-04-05.
 * User POJO
 */

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public static final String FIELD_FIRSTNAME = "firstname";
    public static final String FIELD_LASTNAME = "lastname";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PHONE = "phone";

    public static final String FIELD_ADDRESS1 = "address1";
    public static final String FIELD_ADDRESS2= "address2";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_AGE = "age";

    public static final String FIELD_GENDER = "gender";
    // Height in meters.
    // Weight in kilograms.

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String age;
    private String gender;

    public User() {}

    public User(String firstname, String lastname, String email, String phone,
                String address1, String address2,String city, String age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String fname) {
        this.firstname = fname;
    }

    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lname) {
        this.lastname = lname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { this.firstname = email;  }

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

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

}


