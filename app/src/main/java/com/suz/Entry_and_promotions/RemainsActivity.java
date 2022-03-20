package com.suz.Entry_and_promotions;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.suz.R;
import com.suz.StoksSuz.Detaly;
import com.suz.StoksSuz.rv_promo_fragment;

public class RemainsActivity extends AppCompatActivity {

    private static final String USERNAME_KEY = "USERNAME_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_1_2);
    rv_promo_fragment fragment_1 = new rv_promo_fragment();
    getSupportFragmentManager().beginTransaction().add(R.id.container_a, fragment_1).commit();

   Detaly fragment_2 = new Detaly();
  getSupportFragmentManager().beginTransaction().add(R.id.container_b, fragment_2,"TAG_B").commit();
}

   /* @Override
    protected Fragment getFragment()  {
        return Detaly.newInstance();
    }*/


    public void setResult(String s) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("TAG_B");
        Detaly fragment_2 = (Detaly) fragment;
        fragment_2.setResult(s);
    }



    public void callback(String text) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("TAG_B");
        Detaly fragment_2 = (Detaly) fragment;
        fragment_2.callback(text);
    }

  /*  @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void inCreate_countries(ArrayList<String> countries) {

    }

    @Override
    public void inextracted(String s, String b, Context context) {

    }*/
}
