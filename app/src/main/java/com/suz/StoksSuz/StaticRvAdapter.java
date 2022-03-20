package com.suz.StoksSuz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suz.AppDelegate;
import com.suz.Entry_and_promotions.RemainsActivity;
import com.suz.Entry_and_promotions.Retrofit.AksyList;
import com.suz.Entry_and_promotions.Retrofit.RetroClient;
import com.suz.R;
import com.suz.common.UpdateRv;
import com.suz.database.Aksy;
import com.suz.database.StocksDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StatisRvVievHolder> {

    private ArrayList<StaticRvModel> items;
    int row_index = -1;
    UpdateRv updateRv;
    Activity activity;
    boolean chek = true;
    boolean select = true;
    private List<Aksy> contactList;
    ArrayList<DynamicRvModel> itemss;
    public StaticRvAdapter(ArrayList<StaticRvModel> items, Activity activity, UpdateRv updateRv) {
        this.items = items;
        this.activity = activity;
        this.updateRv = updateRv;
    }

    @NonNull
    @Override
    public StatisRvVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StatisRvVievHolder statisRvVievHolder = new StatisRvVievHolder(view);






        return statisRvVievHolder;
    }
    private StocksDao getMusicDao() {


        return ((AppDelegate) activity.getApplication()).getmStocksDatabase().getStocksDao();
    }
    public void inCreate_a_list( StaticRvModel currentItem) {
        RetroClient.getApiService().getMyAksy()
                .subscribeOn(Schedulers.io())
                .doOnSuccess(Aksy -> getMusicDao().insertAksy(Aksy.getData()))
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


                            itemss = new ArrayList<DynamicRvModel>();
                            int cou = 0;
                            int i;

                            for (i=1 ;i<=contactList.size();i++) {

                                itemss.add(new DynamicRvModel(contactList.get(cou).getBrend(), (String) hashmap (cou++,contactList,currentItem.getText())));
                            }

                            updateRv.callback(itemss,currentItem);
                            onClickShop(currentItem.getText(),activity);

                            chek=false;


                               },
                               throwable -> {

                        });


    }

    @Override
    public void onBindViewHolder(@NonNull StatisRvVievHolder holder, @SuppressLint("RecyclerView") int position) {
        StaticRvModel currentItem = items.get(position);

        holder.textView.setText(currentItem.getText());

        if (chek){

            inCreate_a_list(currentItem);
            chek=false;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();
                inCreate_a_list(currentItem);



            }
        });
        if (select){
            if (position==0)
                holder.linearLayout.setBackgroundResource(R.drawable.edittextstyle_2);
            select=false;
        }else {
            if (row_index == position){
                holder.linearLayout.setBackgroundResource(R.drawable.edittextstyle_2);
            }
            else {
                holder.linearLayout.setBackgroundResource(R.drawable.edittextstyle);
            }
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static  class StatisRvVievHolder extends RecyclerView.ViewHolder{

        TextView textView;
        LinearLayout linearLayout;

        public StatisRvVievHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.Text);
            linearLayout = itemView.findViewById(R.id.LinerLayuot);
        }


    }

    public Object hashmap(int cou, List<Aksy> contactList, String text) {
        Map<String, String> den = new HashMap<>();
        den.put("Bagration - TELE2", contactList.get(cou).getBagration());
        den.put("Beethoven - TELE2", contactList.get(cou).getBeethoven());
        den.put("Zyvaevsk-DIVIZION", contactList.get(cou).getZyvaevskDIV());
        den.put("Zyvaevsk - TELE2", contactList.get(cou).getZyvaevskT2());
        den.put("Bolsherechye RP - TELE2", contactList.get(cou).getBolsherechye());
        den.put("RP Znamenskoye-MTS", contactList.get(cou).getZnamenskoyeMTS());


        String denznah = den.get(text);

        return denznah;
    }
    public void onClickShop(String text, Activity activity) {
        RemainsActivity activi = (RemainsActivity) activity;
        activi.callback(text);

    }

}
