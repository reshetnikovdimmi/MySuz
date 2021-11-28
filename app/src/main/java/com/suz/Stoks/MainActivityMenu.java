package com.suz.Stoks;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.suz.Entry_and_promotions.CoversT2;
import com.suz.Entry_and_promotions.SIM_T2;
import com.suz.Entry_and_promotions.Retrofit.CoversList;
import com.suz.Entry_and_promotions.Retrofit.RetroClient;
import com.suz.Entry_and_promotions.Retrofit.ServiseApi;
import com.suz.Entry_and_promotions.SIM_T2;
import com.suz.R;
import com.suz.Service_Notification.MyServiceNotification;
import com.suz.Service_Notification.NotifResiver;
import com.suz.create_a_list.Сreate_a_list;
import com.suz.database.Stocks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityMenu extends AppCompatActivity {

TextView shopTV;
ImageButton stocksBUT, Covers, SIM_T2;
    private Employee mUser;
    public static final String USER_KEY = "USER_KEY";
    private SharedPreferencesHelper mSharedPreferencesHelper;
    String url = "https://user357.000webhostapp.com/Android/Droid_Suz_bonus.php";
    public static List<Stocks> albums = new ArrayList<>();
    Stocks stocks;
    View tvProgressCircle;
    private  MyServiceNotification myServiceNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
        mSharedPreferencesHelper = new SharedPreferencesHelper(this);
        shopTV=findViewById(R.id.shopTV);
        stocksBUT=findViewById(R.id.stocksBUT);
        SIM_T2=findViewById(R.id.t2);
        Covers=findViewById(R.id.Covers);
        Bundle bundle = getIntent().getExtras();
        mUser = (Employee) bundle.get(USER_KEY);
        tvProgressCircle = findViewById(R.id.vf_progressbar);


        shopTV.setText(mUser.getShop());

        tvProgressCircle.setVisibility(View.GONE);

        stocksBUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvProgressCircle.setVisibility(View.VISIBLE);
                try {
                    create_a_list();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tvProgressCircle.setVisibility(View.VISIBLE);
/*
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, rv_promo_fragment.newInstance())
                        .addToBackStack(rv_promo_fragment.class.getName())
                        .commit();
                final Intent intent = new Intent(getApplicationContext(), RV_promo.class);

              startActivity(intent);
*/



            }
        });
        Covers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Intent intent = new Intent(getApplicationContext(), CoversT2.class);
                startActivity(intent);


            }
        });

        SIM_T2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(getApplicationContext(), SIM_T2.class);
                startActivity(intent);


            }

        });



        myServiceNotification = new MyServiceNotification();
        Context context = this.getApplicationContext();
        //myServiceNotification.alarmNotification(context);
       Intent intent = new Intent(context, MyServiceNotification.class);
        startService(intent);
        alarmNotification(context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu, menu);
        menu.findItem(R.id.auto_input).setChecked(mSharedPreferencesHelper.SP());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionLogout:

                mSharedPreferencesHelper.addUser("0","0");
                stopService(new  Intent(MainActivityMenu.this, MyServiceNotification.class));
                startActivity(new Intent(this, MainActivity.class));
                finish();

                break;
            case R.id.auto_input:

                if (item.isChecked()){
                    item.setChecked(false);
                    mSharedPreferencesHelper.addUser("0","0");

                }else {
                    item.setChecked(true);
                    mSharedPreferencesHelper.addUser(mUser.getShop(),mUser.getPas());
                }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showMessage(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    public void create_a_list() throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future future = service.submit(new Runnable() {
            public void run() {
                Сreate_a_list create_a_list = new Сreate_a_list();
                create_a_list.create_a_list(getApplicationContext());
            }
        });
        final Intent intent = new Intent(getApplicationContext(), RV_promo.class);
        startActivity(intent);
        tvProgressCircle.setVisibility(View.GONE);
        future.get();









    }
    public void alarmNotification(Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10);
        long time = calendar.getTimeInMillis();
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), NotifResiver.class);
        //intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //After after 5 seconds

        am.setRepeating(AlarmManager.RTC_WAKEUP, time,AlarmManager.INTERVAL_HALF_HOUR, pi);

    }


}

