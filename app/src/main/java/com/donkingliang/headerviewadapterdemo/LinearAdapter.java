package com.donkingliang.headerviewadapterdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Depiction:
 * Author:lry
 * Dat:2017/11/10
 */
public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.ViewHolder> {

    private Context mContext;

    public LinearAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_goods_linear, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "position = " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
