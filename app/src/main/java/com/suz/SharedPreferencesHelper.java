package com.suz;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String USERS_KEY = "USERS_KEY";
    private SharedPreferences mSharedPreferences;


    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public Set<String> getUsers() {
        Set<String> ret = mSharedPreferences.getStringSet(USERS_KEY, new HashSet<String>());
        return ret;
           }

           public ArrayList<String> getUser(){
               ArrayList shop = new ArrayList();
               for (String r : getUsers()) {
                   shop.add(r);
               }

        return shop;
           }

    public boolean addUser(String item, String s) {
        Set<String> catnames = new HashSet<String>();
        catnames.add(item);
        catnames.add(s);
        SharedPreferences.Editor e = mSharedPreferences.edit();
        e.putStringSet(USERS_KEY, catnames);
        e.apply();
        return true;
    }
    public boolean SP () {
        boolean SP = false;

        for (String r : getUsers()) {
            if (r.equals("0") && r.equals("0"))
            {
                SP = false; //username and password are present, do your stuff
            }else {
                SP =true;
            }

        }

        return SP;
    }


}

