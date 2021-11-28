package com.suz.Service_Notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.suz.R;
import com.suz.database.Stocks;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Stocks> {

    private LayoutInflater inflater;
    private int layout;
    private Context context;
    private List<Stocks> states;



    public CustomAdapter(Context context, int resource, List<Stocks> states) {
        super(context, resource, states);
        this.context = context;
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);


        TextView nameView = view.findViewById(R.id.lvMain);


        Stocks stocks = states.get(position);


        nameView.setText(stocks.getBrand());


        return view;
    }


    public CustomAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public CustomAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }



    public CustomAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Stocks[] objects) {
        super(context, resource, textViewResourceId, objects);
    }



    public CustomAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Stocks> objects) {
        super(context, resource, textViewResourceId, objects);
    }

}
