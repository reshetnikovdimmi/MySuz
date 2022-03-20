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
import com.suz.Entry_and_promotions.Retrofit.AksyList;
import com.suz.Entry_and_promotions.Retrofit.RetroClient;
import com.suz.R;
import com.suz.database.Aksy;
import com.suz.database.StocksDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AcAksy extends AppCompatActivity {

    private List<Aksy> contactList;
    TextView covers;
    LinearLayout tables;
    int cou, cou1, cou2, cou3, cou4, cou5, cou6, cou7, cou8, cou9, cou10, cou11, cou12 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fv_aksy);

        covers = findViewById(R.id.textView3);
        tables = (LinearLayout) findViewById(R.id.table);


        RetroClient.getApiService().getMyAksy()
                .subscribeOn(Schedulers.io())
                .doOnSuccess(Aksy->getMusicDao().insertAksy(Aksy.getData()))
                .onErrorReturn(new Function<Throwable, AksyList>() {
                    @Override
                    public AksyList apply(@NonNull Throwable throwable) throws Exception {
                        if (RetroClient.NETWORK_EXCEPTIONS.contains(throwable.getClass())) {

                            AksyList response = new AksyList();
                            response.setData((ArrayList<Aksy>) getMusicDao().getAksy());
                            return response;
                        } else return null;
                    }
                })




                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(
                        Aksy -> {

                            contactList = Aksy.getData();
                            Log.d("array", contactList + "contactList");
                            GeneratingЕable(contactList);

                            //   },
                            //   throwable -> {

                        });

    }
    private StocksDao getMusicDao() {
        return ((AppDelegate) getApplicationContext()).getmStocksDatabase().getStocksDao();
    }

    private void GeneratingЕable(List<Aksy> contactList) {

        String[] column = {
                "п/п",
                "Чехлы",
                "bagration",
                "beethoven",
                "zavertyaeva",
                "zyvaevsk",
                "neftezavodskaya",
                "bolsherechye",
                "cool",
                "moskalenki",
                "marianovka",
                "muromtsevo",
                "tavrichesky",
                "container"};
        int rl = contactList.size();
        int cl = column.length;

        ScrollView sv = new ScrollView(getApplicationContext());
        TableLayout tableLayout = createTableLayout(column, rl + 1, cl);
        HorizontalScrollView hsv = new HorizontalScrollView(getApplicationContext());

        hsv.addView(tableLayout);
        sv.addView(hsv);
        tables.addView(sv);
    }

    private TableLayout createTableLayout(String[] cv, int rowCount, int columnCount) {
        // 1) Создаем макет таблицы и ее параметры
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
        TableLayout tableLayout = new TableLayout(getApplicationContext());
        tableLayout.setBackgroundColor(Color.TRANSPARENT);

        // 2) создание tableRow параметры
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(0, 0, 0, 0);

        tableRowParams.weight = 20;
        for (int i = 0; i < rowCount; i++) {
            // 3) создание  tableRow
            TableRow tableRow = new TableRow(getApplicationContext());
            tableRow.setBackgroundColor(Color.TRANSPARENT);

            for (int j = 0; j < columnCount; j++) {
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

                if (i >= 1 && j == 1) {
                    textView.setText(contactList.get(cou++).getBrend());
                }

                if (i >= 1 && j == 2) {
                    textView.setText(contactList.get(cou1++).getBagration());
                }
                if (i >= 1 && j == 3) {
                    textView.setText(contactList.get(cou2++).getBeethoven());
                }
                if (i >= 1 && j == 4) {
                    textView.setText(contactList.get(cou3++).getZavertyaeva());
                }
                if (i >= 1 && j == 5) {
                    // textView.setText(contactList.get(cou4++).getZyvaevsk());
                }
                if (i >= 1 && j == 6) {
                    textView.setText(contactList.get(cou5++).getNeftezavodskaya());
                }
                if (i >= 1 && j == 7) {

                    textView.setText(contactList.get(cou6++).getBolsherechye());
                }
                if (i >= 1 && j == 8) {
                    textView.setText(contactList.get(cou7++).getCool());
                }
                if (i >= 1 && j == 9) {
                    // textView.setText(contactList.get(cou8++).getMoskalenki());
                }
                if (i >= 1 && j == 10) {
                    //  textView.setText(contactList.get(cou9++).getMarianovka());
                }
                if (i >= 1 && j == 11) {
                    //textView.setText(contactList.get(cou10++).getMuromtsevo());
                }
                if (i >= 1 && j == 12) {
                    //textView.setText(contactList.get(cou11++).getTavrichesky());
                }
                if (i >= 1 && j == 13) {
                    textView.setText(contactList.get(cou12++).getContainer());
                }
                if (i >= 1 && j == 0) {
                    textView.setText("" + id);
                } else if (i == 0 && j >= 0) {

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