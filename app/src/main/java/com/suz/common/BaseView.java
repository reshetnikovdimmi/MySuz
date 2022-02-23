package com.suz.common;

import android.content.Context;

import java.util.ArrayList;

public interface BaseView {

    void showRefresh();

    void hideRefresh();

    void showError();

    interface View{
        void onSuccess();

        void onError();




    }

    interface Presenter {
        void doLogin(String URL, String login, String password, Context context);

    }

    interface Create_countries {
        void inCreate_countries (ArrayList<String> countries,Context context);
    }

    interface extracted{
    void inextracted        (String s, String b, Context context);
}
    interface Create_a_list {
        void inCreate_a_list (String URL, Context context);
    }

}