package com.example.aiila_mobile_application.activities;

public class Users_List {

    String email, mobile, name, user_type;
    int profile;

    public Users_List(String email, String mobile, String name, String user_type, int profile) {

        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.user_type = user_type;
        this.profile = profile;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
