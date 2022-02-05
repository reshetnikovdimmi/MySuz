package com.suz.Service_Notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.suz.AppDelegate;
import com.suz.Entry_and_promotions.RV_promo;
import com.suz.R;
import com.suz.database.Stocks;
import com.suz.database.StocksDao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyServiceNotification extends Service {
    private static final String TAG = "MyServiceNotification";
    final public static String ONE_TIME = "onetime";
    private ScheduledExecutorService mScheduledExecutorService;
    String url = "https://user357.000webhostapp.com/Android/Droid_Suz_bonus.php";
    public static List<Stocks> albums = new ArrayList<>();
    Stocks stocks;
    private NotificationManager mManager;
    private NotificationCompat.Builder mBuilder;

    List<Stocks> header3;
    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onCreate(){

        mScheduledExecutorService = Executors.newScheduledThreadPool( 1);
       mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mBuilder = getNotificationBuilder()
        .setSmallIcon(R.drawable.pion)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.mqdefault));
        Log.d(TAG,  "onCreate: ");
       // Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
        /*PowerManager pm = (PowerManager) getApplicationContext().getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag")
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, TAG);
        //Acquire the lock
        wl.acquire();*/
        }

    private NotificationCompat.Builder getNotificationBuilder() {

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return new NotificationCompat.Builder(this);
            } else {
            String channel_id = "my_channel_id";

            if(mManager.getNotificationChannel(channel_id) == null) { NotificationChannel channel = new NotificationChannel(channel_id, "Text for user",
                        NotificationManager.IMPORTANCE_LOW);



                mManager.createNotificationChannel(channel);
                }

            return new NotificationCompat.Builder(this, channel_id);
            }
        }





    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG, "onStartCommand: ");

alarmNotification(getApplicationContext());
        mScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                //Сreate_a_list create_a_list = new Сreate_a_list();
                //create_a_list.create_a_list(getApplicationContext());
                Log.d(TAG, "run" + System.currentTimeMillis());
                final StocksDao stocksDatabase = ((AppDelegate) getApplicationContext()).getmStocksDatabase().getStocksDao();
                header3 = stocksDatabase.getEndPromo(RV_promo.datess());
               startForeground(123,getNotification("start notification",header3));
              mManager.notify(123, getNotification("time is Promo" , header3));


            }

        },0,10,TimeUnit.MINUTES);
//mScheduledExecutorService.shutdown();

//mManager.cancelAll();
        return START_STICKY;
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

    @NonNull
    private Notification getNotification(String contentText, List<Stocks> header){
        Intent intent = new Intent(this, RV_promo.class);
        intent.putExtra(String.valueOf(System.currentTimeMillis()), contentText);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2123, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.InboxStyle notification = new NotificationCompat.InboxStyle();
        for(int i = 0; i < header.size(); i++) {
            notification.addLine(header.get(i).getModel() + "-" + header.get(i).getEnd());
        }
       // Log.d(TAG, header3.size() +"run - ");

        return mBuilder.setContentText(contentText).setContentIntent(pendingIntent).setStyle(notification).build();



        }
        @Override
    public void onDestroy(){
        Log.d(TAG,  "onDestroy: ");
        }




}