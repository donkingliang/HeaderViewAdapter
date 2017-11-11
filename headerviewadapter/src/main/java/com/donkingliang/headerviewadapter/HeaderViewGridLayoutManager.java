package com.donkingliang.headerviewadapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

/**
 * Depiction: HeaderViewGridLayoutManager是为适配RecyclerView同时使用{@link HeaderViewAdapter}
 * 和{@link GridLayoutManager}而提供的一个GridLayoutManager子类。它保证了RecyclerView在使用GridLayoutManager
 * 的时候,HeaderView 和 FooterView 依然可以占满一行。所以如果你要同时使用HeaderViewAdapter和GridLayoutManager，
 * 你就要使用HeaderViewGridLayoutManager。
 * <p>
 * Author:donkingliang  QQ:1043214265
 * Dat:2017/11/10
 */
public class HeaderViewGridLayoutManager extends GridLayoutManager {

    private HeaderViewAdapter mAdapter;

    public HeaderViewGridLayoutManager(Context context, int spanCount, HeaderViewAdapter adapter) {
        super(context, spanCount);
        this.mAdapter = adapter;
        setSpanSizeLookup();
    }

    public HeaderViewGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr,
                                       int defStyleRes, HeaderViewAdapter adapter) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mAdapter = adapter;
        setSpanSizeLookup();
    }

    public HeaderViewGridLayoutManager(Context context, int spanCount, int orientation,
                                       boolean reverseLayout, HeaderViewAdapter adapter) {
        super(context, spanCount, orientation, reverseLayout);
        this.mAdapter = adapter;
        setSpanSizeLookup();
    }

    private void setSpanSizeLookup() {
        super.setSpanSizeLookup(new SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter != null) {
                    if (mAdapter.isHeader(position) || mAdapter.isFooter(position)) {
                        //如果是HeaderView 或者 FooterView，就让它占满一行。
                        return getSpanCount();
                    } else {
                        int adjPosition = position - mAdapter.getHeadersCount();
                        return HeaderViewGridLayoutManager.this.getSpanSize(adjPosition);
                    }
                } else {
                    return 1;
                }
            }
        });
    }

    /**
     * 提供这个方法可以使外部改变普通列表项的SpanSize。
     * 这个方法的作用跟{@link SpanSizeLookup#getSpanSize(int)}一样。
     *
     * @param position 去掉HeaderView和FooterView后的position。
     * @return
     */
    public int getSpanSize(int position) {
        return 1;
    }

    // 不允许外部设置SpanSizeLookup。
    @Override
    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
    }
}
