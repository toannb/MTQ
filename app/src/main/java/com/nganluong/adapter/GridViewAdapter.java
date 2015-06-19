package com.nganluong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nganluong.bean.ItemHomePage;
import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;

import java.util.ArrayList;

/**
 * Created by ToanNB on 6/16/2015.
 */
public class GridViewAdapter extends ArrayAdapter<ItemHomePage> {

    private Context mContext;
    private ArrayList<ItemHomePage> mArrDatas;
    private LayoutInflater inflater = null;

    private OnItemBoxClickListener onItemBoxClickListener;

    public GridViewAdapter(Context context, int textViewResourceId, ArrayList<ItemHomePage> pArrDatas) {
        super(context, textViewResourceId);

        this.mContext = context;
        this.mArrDatas = pArrDatas;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrDatas.size();
    }

    @Override
    public ItemHomePage getItem(int position) {
        return mArrDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final int pos = position;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.home_page_custom_item_gridview, parent, false);
            holder = new ViewHolder();

            holder.boxItem = (LinearLayout) convertView.findViewById(R.id.boxItem);
            holder.imageView = (ImageView) convertView.findViewById(R.id.home_page_gridview_item_image);
            holder.textView = (TextView) convertView.findViewById(R.id.home_page_gridview_item_title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(mArrDatas.get(pos).getIconItem());
        holder.textView.setText(mArrDatas.get(pos).getNameItem());
        holder.textView.setTypeface(Variables.objFont);

        holder.boxItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (onItemBoxClickListener != null) {
                    onItemBoxClickListener.onItemBoxClick(pos, (ViewGroup) v.getParent());
                }
            }
        });

        return convertView;
    }

    public void setOnItemBoxClickListener(OnItemBoxClickListener onItemBoxClickListener) {
        this.onItemBoxClickListener = onItemBoxClickListener;
    }

    public interface OnItemBoxClickListener {
        void onItemBoxClick(int position, ViewGroup viewParent);
    }

    static class ViewHolder {
        LinearLayout boxItem;
        ImageView imageView;
        TextView textView;
    }
}
