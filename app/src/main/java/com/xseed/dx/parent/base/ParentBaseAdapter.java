package com.xseed.dx.parent.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Abhi on 16/08/16.
 */
public abstract class ParentBaseAdapter<T> extends BaseAdapter {
    protected ArrayList<T> mList;
    protected Context mContext;

    public ParentBaseAdapter(Context context) {
        this(context, null);
    }

    public ParentBaseAdapter(Context context, ArrayList<T> list) {
        mContext = context;
        if (list == null) {
            mList = new ArrayList<>();
        } else {
            mList = list;
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(ArrayList<T> list) {
        mList = list;
        notifyDataSetChanged();
    }



    @LayoutRes
    public abstract int getLayoutId();

    public abstract ParentViewHolder getViewHolder();

    public abstract static class ParentViewHolder {
        public ParentViewHolder(View v) {
        }

    }
}
