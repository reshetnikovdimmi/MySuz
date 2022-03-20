package com.suz.StoksSuz;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.suz.Entry_and_promotions.Retrofit.RetroClient;
import com.suz.R;
import com.suz.common.UpdateRv;
import com.suz.database.Aksy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Detaly extends Fragment implements UpdateRv.MyInterface {
    TextView textView2;
    TextView covers;
    LinearLayout tables;
    int cou, cou1 = 0;
    private List<Aksy> contactList;
    TableLayout tableLayout;
    String shop;
    public static Detaly newInstance() {
        return new Detaly();
    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_2,
                container, false);

        textView2 = v.findViewById(R.id.textView2);
        covers = v.findViewById(R.id.textView3);
        tables = (LinearLayout) v.findViewById(R.id.table);

        return  v;
    }

    private void GeneratingЕable() {

        String[] column = {
                "п/п",
                "ТМЦ",
                "Количество",
                };
        int rl = contactList.size();
        int cl = column.length;

        ScrollView sv = new ScrollView(getContext());
        tableLayout = createTableLayout(column, rl + 1, cl);
        HorizontalScrollView hsv = new HorizontalScrollView(getContext());

        hsv.addView(tableLayout);
        sv.addView(hsv);
        tables.addView(sv);
    }

    private TableLayout createTableLayout(String[] cv, int rowCount, int columnCount) {

        // 1) Создаем макет таблицы и ее параметры
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
        tableLayout = new TableLayout(getContext());
        tableLayout.setBackgroundColor(Color.TRANSPARENT);

        // 2) создание tableRow параметры
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(0, 0, 0, 0);


        tableRowParams.weight = 20;
        for (int i = 0; i < rowCount; i++) {
            // 3) создание  tableRow
            TableRow tableRow = new TableRow(getContext());
            tableRow.setBackgroundColor(Color.TRANSPARENT);

            for (int j = 0; j < columnCount; j++) {
                // 4) создание  textView
                TextView textView = new TextView(getContext());
                textView.setBackgroundColor(Color.GRAY);
                textView.setGravity(1);
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(12);
                int textColor = ContextCompat.getColor(getContext(), R.color.cardview_dark_background);
                textView.setTextColor(textColor);
                String s1 = Integer.toString(i);
                int id = Integer.parseInt(s1);
                textView.setBackgroundResource(R.drawable.edittextstyle);

                if (i >= 1 && j == 1) {
                    textView.setText(contactList.get(cou++).getBrend());
                }

                if (i >= 1 && j == 2) {

                    textView.setText(hashmap());
                    cou1++;
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

        cou =0;
        cou1=0;
        return tableLayout;
    }

    public void callback(String text) {
        this.shop = text;
    }

    @Override
    public void setResult(String s) {
        inCreate_a_list(s);
        textView2.setText(s);

    }
    public CharSequence hashmap() {

        Map<String, String> den = new HashMap<>();
        den.put("Bagration - TELE2", contactList.get(cou1).getBagration());
        den.put("Beethoven - TELE2", contactList.get(cou1).getBeethoven());
        den.put("Zyvaevsk-DIVIZION", contactList.get(cou1).getZyvaevskDIV());
        den.put("Zyvaevsk - TELE2", contactList.get(cou1).getZyvaevskT2());
        den.put("Bolsherechye RP - TELE2", contactList.get(cou1).getBolsherechye());
        den.put("RP Znamenskoye-MTS", contactList.get(cou1).getZnamenskoyeMTS());


        String denznah = den.get(shop);

        return denznah;
    }
    public void inCreate_a_list(String s){
            if (tableLayout !=null){
                tableLayout.removeAllViews();
            }
        RetroClient.getApiService().getMyAksy_detail(s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        Aksy -> {
                            contactList = Aksy.getData();

                            GeneratingЕable();
                        },
                        throwable -> {

                        });

    }




}
