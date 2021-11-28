package com.suz.Stoks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.suz.R;


public class rv_promo_fragment extends Fragment {

    public static Fragment newInstance() {
        return new rv_promo_fragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fv_promo_fragment, container, false);



        return view;
    }

}
