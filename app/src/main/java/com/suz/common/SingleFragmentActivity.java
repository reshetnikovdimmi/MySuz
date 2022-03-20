package com.suz.common;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.suz.R;


public abstract class SingleFragmentActivity extends AppCompatActivity implements BaseView.Create_countries,BaseView.extracted, BaseView.View{//унаследовали
        FragmentManager fragmentManager;
        @Override
protected void onCreate(@Nullable Bundle savedInstanceState){//переопределили Create
        super.onCreate(savedInstanceState); //добавим ContentView
        setContentView(R.layout.ac_single_fragment);


        if (savedInstanceState == null) { //добавленная логика
        fragmentManager = getSupportFragmentManager();//обязательно support
        //начнём транзацию по запуску фрагмента
        fragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, getFragment(),"USERNAME_KEY")

        .commit();//после реплейса вызвали commit

                        }
        }//абстрактный метод получения фрагмента
        protected abstract Fragment getFragment();
        @Override
        public void onBackPressed() {
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (fragmentManager.getBackStackEntryCount() == 0) {
                        finish();
                } else {
                        fragmentManager.popBackStack();
                }
        }
}
