package com.donkingliang.headerviewadapter.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.donkingliang.headerviewadapter.adapter.HeaderViewAdapter;
import com.donkingliang.headerviewadapter.layoutmanager.HeaderViewGridLayoutManager;

/**
 * Depiction:
 * Author:lry
 * Dat:2017/11/13
 */
public class HeaderRecyclerView extends RecyclerView {

    //内置的HeaderViewAdapter包装对象。
    private HeaderViewAdapter mAdapter;

    public HeaderRecyclerView(Context context) {
        super(context);
        wrapHeaderAdapter();
    }

    public HeaderRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        wrapHeaderAdapter();
    }

    public HeaderRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        wrapHeaderAdapter();
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        //如果要使用GridLayoutManager的话，只能使用HeaderViewGridLayoutManager。
        if (layout instanceof GridLayoutManager && !(layout instanceof HeaderViewGridLayoutManager)) {
            super.setLayoutManager(new HeaderViewGridLayoutManager(getContext(),
                    ((GridLayoutManager) layout).getSpanCount(), mAdapter));
        } else {
            super.setLayoutManager(layout);
        }
    }

    private void wrapHeaderAdapter() {
        mAdapter = new HeaderViewAdapter(super.getAdapter());
        super.setAdapter(mAdapter);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        mAdapter.setAdapter(adapter);
    }

    @Override
    public Adapter getAdapter() {
        return mAdapter.getAdapter();
    }

    /**
     * 获取HeaderView的个数
     *
     * @return
     */
    public int getHeadersCount() {
        return mAdapter.getHeadersCount();
    }

    /**
     * 获取FooterView的个数
     *
     * @return
     */
    public int getFootersCount() {
        return mAdapter.getFootersCount();
    }

    /**
     * 添加HeaderView
     *
     * @param view
     */
    public void addHeaderView(View view) {
        mAdapter.addHeaderView(view);
    }

    /**
     * 删除HeaderView
     *
     * @param view
     * @return 是否删除成功
     */
    public boolean removeHeaderView(View view) {
        return mAdapter.removeHeaderView(view);
    }

    /**
     * 添加FooterView
     *
     * @param view
     */
    public void addFooterView(View view) {
        mAdapter.addFooterView(view);
    }

    /**
     * 删除FooterView
     *
     * @param view
     * @return 是否删除成功
     */
    public boolean removeFooterView(View view) {
        return mAdapter.removeFooterView(view);
    }
}
