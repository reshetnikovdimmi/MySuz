package com.suz;


import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragmentActivity{
        @Override
        protected Fragment getFragment() {
            return MainFragment.newInstance(); //потом изменим
            }
        }

