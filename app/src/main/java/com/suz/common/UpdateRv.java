package com.suz.common;


import com.suz.StoksSuz.DynamicRvModel;
import com.suz.StoksSuz.StaticRvModel;

import java.util.ArrayList;

public interface UpdateRv {
    void callback(ArrayList<DynamicRvModel> item, StaticRvModel currentItem);

    interface MyInterface {
        void setResult(String s);
    }

}


