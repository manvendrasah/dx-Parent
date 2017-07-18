package com.xseed.dx.parent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xseed.dx.parent.base.ParentBaseAdapter;
import com.xseed.dx.parent.utils.CountryUtils;

/**
 * Created by Abhi on 16/08/16.
 */
public class CountryAdapter extends ParentBaseAdapter<CountryModel> {

    Context context;
    int selectPos;

    public CountryAdapter(Context context) {
        super(context);
        mList = CountryUtils.getCountryModelList();
        this.context = context;
        selectPos = 0;
    }

    public void setSelected(int pos) {
        selectPos = pos;
    }

    @Override
    public int getLayoutId() {
        return R.layout.row_country_spinner;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
            CountryHolder holder = new CountryHolder(convertView);
            convertView.setTag(holder);
        }
        CountryHolder holder = (CountryHolder) convertView.getTag();
        holder.countryName.setText(mList.get(position).name);
        if (position == getCount() - 1)
            holder.line.setVisibility(View.GONE);
        if (position == selectPos)
            holder.ivCheck.setVisibility(View.VISIBLE);
        else
            holder.ivCheck.setVisibility(View.GONE);
        return convertView;
    }


    @Override
    public ParentViewHolder getViewHolder() {
        return null;
    }

    static class CountryHolder extends ParentViewHolder {
        TextView countryName;
        View line;
        LinearLayout countryLayout;
        ImageView ivCheck;

        public CountryHolder(View v) {
            super(v);
            countryName = (TextView) v.findViewById(R.id.item_spinner_text);
            line = v.findViewById(R.id.item_spinner_line);
            countryLayout = (LinearLayout) v.findViewById(R.id.item_spinner_parent);
            ivCheck = (ImageView) v.findViewById(R.id.iv_spinner_check);
        }
    }

}
