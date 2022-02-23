package com.suz.StoksSuz;


import android.content.Context;

import androidx.fragment.app.Fragment;

import com.suz.common.SingleFragmentActivity;

import java.util.ArrayList;

public class MainActivity extends SingleFragmentActivity {
    public static final String USERNAME_KEY = "USERNAME_KEY";

    @Override
    public void inCreate_countries(ArrayList<String> countries, Context context) {

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(USERNAME_KEY);
        MainFragment fragment_b = (MainFragment) fragment;
        fragment_b.inCreate_countries(countries, context);
    }

    @Override
    public void inextracted(String s, String b, Context context) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(USERNAME_KEY);
        MainFragment fragment_b = (MainFragment) fragment;
        fragment_b.inextracted(s,b, context);
    }

    @Override
    public void onSuccess() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(USERNAME_KEY);
        MainFragment fragment_b = (MainFragment) fragment;
        fragment_b.onSuccess();
    }

    @Override
    public void onError() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(USERNAME_KEY);
        MainFragment fragment_b = (MainFragment) fragment;
        fragment_b.onError();
    }


    @Override
    protected Fragment getFragment() {
        if (getIntent() != null) {
            return MainFragment.newInstance(getIntent().getBundleExtra(USERNAME_KEY));
        }
        throw new IllegalStateException("getIntent cannot be null");
    }


}

