package com.suz;


import android.app.FragmentManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public abstract class SingleFragmentActivity extends AppCompatActivity {//унаследовали
        @Override
protected void onCreate(@Nullable Bundle
        savedInstanceState){//переопределили Create
        super.onCreate(savedInstanceState); //добавим ContentView
        setContentView(R.layout.ac_single_fragment);
        if (savedInstanceState == null) { //добавленная логика
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();//обязательно support
        //начнём транзацию по запуску фрагмента
        fragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, getFragment())
        .commit();//после реплейса вызвали commit
        }
        }//абстрактный метод получения фрагмента
        protected abstract Fragment getFragment();

      @Override
        public void onBackPressed() {
                FragmentManager fragmentManager = getFragmentManager();
                if (fragmentManager.getBackStackEntryCount() == 0) {
                        finish();
                } else {
                        fragmentManager.popBackStack();
                }
        }
}
