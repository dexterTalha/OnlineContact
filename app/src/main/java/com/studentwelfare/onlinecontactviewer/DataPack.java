package com.studentwelfare.onlinecontactviewer;

import android.content.Context;

public class DataPack {

    Context ctx;
    String name;
    String mobile;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    DataPack(Context context, String n, String m, String e){
        this.ctx = context;
        this.setName(n);
        this.setMobile(m);
        this.setEmail(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
