package com.suz.common;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;

import com.suz.R;
import com.suz.StoksSuz.MainActivity;

import java.util.HashMap;

public class NotifResiver extends BroadcastReceiver implements BaseView.extracted {



    private static final String TAG = "MyServiceNotification";
    @Override
    public void onReceive(Context context, Intent intent) {

        BaseView.Create_a_list create_a_list = new FragmentPresenter((FragmentActivity) context);
        SharedPreferencesHelper mSharedPreferencesHelper = new SharedPreferencesHelper(context);
        HashMap<String, String> user = mSharedPreferencesHelper.getUserDetail();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //Toast.makeText(context, "NotifResiver", Toast.LENGTH_SHORT).show();
       // Log.d(TAG, "run NotifResiver" + System.currentTimeMillis());
       // intent = new Intent(context, MyServiceNotification.class);
       // context.startService(intent);
        if (!commo_internet.isConnectedToInternet(context)){

            View layout_dialog = LayoutInflater.from(context).inflate(R.layout.internet_dialog,null);
            builder.setView(layout_dialog);

            AppCompatButton btnInternet = layout_dialog.findViewById(R.id.btnInternet);
            AppCompatButton btnRETRY= layout_dialog.findViewById(R.id.btnRETRY);

            if (!mSharedPreferencesHelper.isLoggin())  {
                btnInternet.setVisibility(View.GONE);
            }else {
                btnRETRY.setVisibility(View.GONE);
            }
            AlertDialog dialog = builder.create();
            dialog.show();
            dialog.setCancelable(false);

            btnInternet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();

                    inextracted(user.get(mSharedPreferencesHelper.NAME),user.get(mSharedPreferencesHelper.EMAIL), context);

                }
            });

            btnRETRY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    onReceive(context,intent);
                    if (commo_internet.isConnectedToInternet(context)) {
                        create_a_list.inCreate_a_list("https://user357.000webhostapp.com/Android/Droid_Suz.php",context);
                   }
                }
            });

        }else {
            Toast.makeText(context, R.string.connection_restored, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void inextracted(String s, String b, Context context) {
        MainActivity activity = (MainActivity) context;
        activity.inextracted(s,b,context);
    }
}
