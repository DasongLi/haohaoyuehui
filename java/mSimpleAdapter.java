package com.example.pro.test1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pro on 2017/5/15.
 */

public class mSimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<String> mDatas;

    public mSimpleAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.fragment2_recycle,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        //return null;
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.v.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView v;
    public MyViewHolder(View itemView) {
        super(itemView);
        v = (TextView) itemView.findViewById(R.id.id_tv);

    }
}