package com.robboba.mha.model;

import com.google.firebase.firestore.IgnoreExtraProperties;

/**
 * Created by kevin on 2018-04-08.
 *
 * POJO
 */

@IgnoreExtraProperties
public class SimpleUser {
    public static final String FIELD_NAME = "name";
    public static final String FIELD_EMAIL = "email";

    private String name;
    private String email;

    public SimpleUser() {}

    public SimpleUser(String name, String email) {
        this.name = name;
        this.email = email;
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
    public void setEmail(String email) { this.email = email;  }

}

