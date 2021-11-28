package com.suz.Service_Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class NotifResiver extends BroadcastReceiver {
    private static final String TAG = "MyServiceNotification";
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "NotifResiver", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "run NotifResiver" + System.currentTimeMillis());
        intent = new Intent(context, MyServiceNotification.class);
        context.startService(intent);
    }
}
