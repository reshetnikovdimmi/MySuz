package com.suz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.suz.R;
import com.suz.RV_promo;
import com.suz.database.Stocks;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ListAdapter extends BaseExpandableListAdapter {
    private final RV_promo rv_promo;
    private final Context context;
    private final HashMap<String, List<Stocks>> listChild;
    private final List<String> listHeader;


    public ListAdapter(RV_promo rv_promo, Context context, HashMap<String, List<Stocks>> listChild, List<String> listHeader) {
        this.rv_promo = rv_promo;
        this.context = context;
        this.listChild = listChild;
        this.listHeader = listHeader;
    }

    @Override
    public int getGroupCount() {
        return listHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return listChild.get(listHeader.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return listHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(listHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) rv_promo.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_group, null);

        }

        TextView textView = convertView.findViewById(R.id.list_headr);
        textView.setText(headerTitle);

        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        Stocks childTitle = (Stocks) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) rv_promo.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_items, null);

        }

        TextView brand = convertView.findViewById(R.id.list_child);
        TextView model = convertView.findViewById(R.id.tv_model);
        TextView beginning = convertView.findViewById(R.id.tv_beginning);
        TextView end = convertView.findViewById(R.id.end);
        TextView price = convertView.findViewById(R.id.tv_price);

        brand.setText(childTitle.getBrand());
        model.setText(childTitle.getModel());
        beginning.setText(childTitle.getBeginning());
        end.setText(childTitle.getEnd());
        price.setText(childTitle.getPrice());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
