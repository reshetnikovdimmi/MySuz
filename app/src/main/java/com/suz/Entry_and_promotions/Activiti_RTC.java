package com.suz.Entry_and_promotions;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.suz.AppDelegate;
import com.suz.Entry_and_promotions.Retrofit.MTSList;
import com.suz.Entry_and_promotions.Retrofit.RTCList;
import com.suz.Entry_and_promotions.Retrofit.RetroClient;
import com.suz.R;
import com.suz.database.MTS;
import com.suz.database.RTC;
import com.suz.database.StocksDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Activiti_RTC extends AppCompatActivity {
    private List<RTC> contactList;
    TextView covers;
    LinearLayout tables;
    int cou,cou1,cou2,cou3,cou4,cou5,cou6,cou7,cou8,cou9,cou10,cou11,cou12 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtc);

        covers=findViewById(R.id.textView3);
        tables = (LinearLayout) findViewById(R.id.table);



        RetroClient.getApiService().getMyRTC()
                .subscribeOn(Schedulers.io())
                .doOnNext(RTC-> getMusicDao().insertRTC(RTC.getData()))
                .onErrorReturn(new Function<Throwable, RTCList>() {
                    @Override
                    public RTCList apply(@NonNull Throwable throwable) throws Exception {

                        if (RetroClient.NETWORK_EXCEPTIONS.contains(throwable.getClass())) {

                            RTCList response = new RTCList();
                            response.setData((ArrayList<RTC>) getMusicDao().getRTC());
                            return response;
                        } else return null;
                    }



                })
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(
                        RTC -> {

                            contactList = RTC.getData();
                            Log.d("array", contactList + "contactList");
                            GeneratingЕable(contactList);

                            //   },
                            //   throwable -> {

                        });





    }

    private StocksDao getMusicDao() {
        return ((AppDelegate) getApplicationContext()).getmStocksDatabase().getStocksDao();
    }

    private void GeneratingЕable(List<RTC> contactList) {

        String[] column = {
                "п/п",
                "Радуга",
                "номен мтс",
                "осн-й склад",
                "осн-й склад сим",
                "zyvaevsk",
                "neftezavodskaya",
                "bolsherechye",
                "cool",
                "moskalenki",
                "marianovka",
                "muromtsevo",
                "tavrichesky",
                "container"};
        int rl=contactList.size();
        int cl=column.length;

        ScrollView sv = new ScrollView(getApplicationContext());
        TableLayout tableLayout = createTableLayout(column,rl+1, cl);
        HorizontalScrollView hsv = new HorizontalScrollView(getApplicationContext());

        hsv.addView(tableLayout);
        sv.addView(hsv);
        tables.addView(sv);
    }
    private TableLayout createTableLayout(String[] cv, int rowCount, int columnCount)
    {
        // 1) Создаем макет таблицы и ее параметры
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
        TableLayout tableLayout = new TableLayout(getApplicationContext());
        tableLayout.setBackgroundColor(Color.TRANSPARENT);

        // 2) создание tableRow параметры
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(0, 0, 0, 0);

        tableRowParams.weight = 20;
        for (int i = 0; i < rowCount; i++)
        {
            // 3) создание  tableRow
            TableRow tableRow = new TableRow(getApplicationContext());
            tableRow.setBackgroundColor(Color.TRANSPARENT);

            for (int j= 0; j < columnCount; j++)
            {
                // 4) создание  textView
                TextView textView = new TextView(getApplicationContext());
                textView.setBackgroundColor(Color.GRAY);

                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(12);
                int textColor = ContextCompat.getColor(getApplicationContext(), R.color.cardview_dark_background);
                textView.setTextColor(textColor);
                String s1 = Integer.toString(i);
                int id = Integer.parseInt(s1);
                textView.setBackgroundResource(R.drawable.edittextstyle);

                if (i>=1 && j==1)
                {
                    textView.setText(contactList.get(cou++).getTmc())  ;
                }

                if (i>=1 && j==2)
                {
                    textView.setText (contactList.get(cou1++).getModel());
                }
                if (i>=1 && j==3)
                {
                    textView.setText (contactList.get(cou2++).getBagration());
                }
                if (i>=1 && j==4)
                {
                    textView.setText (contactList.get(cou3++).getMoskalenki());
                }

                if (i>=1 && j==0)
                {
                    textView.setText(""+id);
                }
                else if(i==0 && j >=0)
                {

                    textView.setText(cv[j]);

                    textView.setTextSize(14);

                }
                // 5) add textView to tableRow
                tableRow.addView(textView, tableRowParams);

            }
            // 6) add tableRow to tableLayout
            tableLayout.addView(tableRow, tableLayoutParams);

        }

        return tableLayout;
    }
}
