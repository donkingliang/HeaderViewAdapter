package com.donkingliang.headerviewadapterdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;

import com.donkingliang.headerviewadapter.adapter.HeaderViewAdapter;
import com.donkingliang.headerviewadapter.layoutmanager.HeaderViewGridLayoutManager;
import com.donkingliang.headerviewadapter.view.HeaderRecyclerView;
import com.donkingliang.headerviewadapterdemo.adapter.GridAdapter;
import com.donkingliang.headerviewadapterdemo.adapter.LinearAdapter;

/**
 * Depiction:
 * Author:donkingliang
 * Dat:2017/11/10
 */
public class MainActivity extends AppCompatActivity {

    //    private RecyclerView rvList;
    private HeaderRecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rvList = (RecyclerView) findViewById(R.id.rv_list);
//        showLinearList();
//        showGridList();
        rvList = (HeaderRecyclerView) findViewById(R.id.rv_list);
        showHeaderRecyclerView();
    }

    private void showLinearList() {
        LinearAdapter adapter = new LinearAdapter(this);
        HeaderViewAdapter headerViewAdapter = new HeaderViewAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        View hv1 = LayoutInflater.from(this).inflate(R.layout.layout_header, rvList, false);
        View hv2 = LayoutInflater.from(this).inflate(R.layout.layout_header_view, rvList, false);
        View fv = LayoutInflater.from(this).inflate(R.layout.layout_footer_view, rvList, false);
        headerViewAdapter.addHeaderView(hv1);
        headerViewAdapter.addHeaderView(hv2);
        headerViewAdapter.addFooterView(fv);
        rvList.setAdapter(headerViewAdapter);
    }

    private void showGridList() {
        GridAdapter adapter = new GridAdapter(this);
        HeaderViewAdapter headerViewAdapter = new HeaderViewAdapter(adapter);
        rvList.setLayoutManager(new HeaderViewGridLayoutManager(this, 2, headerViewAdapter));
        View hv1 = LayoutInflater.from(this).inflate(R.layout.layout_header, rvList, false);
        View hv2 = LayoutInflater.from(this).inflate(R.layout.layout_header_view, rvList, false);
        View fv = LayoutInflater.from(this).inflate(R.layout.layout_footer_view, rvList, false);
        headerViewAdapter.addHeaderView(hv1);
        headerViewAdapter.addHeaderView(hv2);
        headerViewAdapter.addFooterView(fv);
        rvList.setAdapter(headerViewAdapter);
    }

    private void showHeaderRecyclerView() {
        GridAdapter adapter = new GridAdapter(this);
        rvList.setLayoutManager(new GridLayoutManager(this, 2));
        rvList.setAdapter(adapter);
        View hv1 = LayoutInflater.from(this).inflate(R.layout.layout_header, rvList, false);
        View hv2 = LayoutInflater.from(this).inflate(R.layout.layout_header_view, rvList, false);
        View fv = LayoutInflater.from(this).inflate(R.layout.layout_footer_view, rvList, false);
        rvList.addHeaderView(hv1);
        rvList.addHeaderView(hv2);
        rvList.addFooterView(fv);
    }
}
