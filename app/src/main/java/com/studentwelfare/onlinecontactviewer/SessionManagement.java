package com.studentwelfare.onlinecontactviewer;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManagement {

    public static final int PRIVATE_MODE = 0;
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_MOBILE = "mobile";
    public static final String ISLOGIN = "islogin";
    public static final String PREF_NAME = "UserData";
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Context context;

    SessionManagement(Context ctx){
        this.context = ctx;
        pref = ctx.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();

    }

    public void createSession(String username, String password, String mobile){
        editor.putBoolean(ISLOGIN, true);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_PASSWORD,password);
        editor.putString(KEY_MOBILE,mobile);
        editor.commit();
    }
    public boolean isLogin(){
        return pref.getBoolean(ISLOGIN,false);
    }

    public HashMap<String, String> getPreference(){
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put(KEY_USERNAME, pref.getString(KEY_USERNAME,null));
        map.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD,null));
        map.put(KEY_MOBILE, pref.getString(KEY_MOBILE,null));
        return  map;

    }


}
