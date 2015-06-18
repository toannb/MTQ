package com.nganluong.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;

import java.util.ArrayList;

import com.nganluong.bean.Child;
import com.nganluong.bean.Group;

/**
 * Created by ToanNB on 6/8/2015.
 */
public class ExpandListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<Group> mGroups;
    private int mSelectedIndex;

    public ExpandListAdapter(Context context, ArrayList<Group> groups) {
        this.mContext = context;
        this.mGroups = groups;
        mSelectedIndex = -1;
    }

    public void setSelectedIndex(int ind) {
        mSelectedIndex = ind;
        notifyDataSetChanged();
    }


    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Child child = mGroups.get(groupPosition).getItems();
        return child;
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Group group = (Group) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.register_step1_group_item, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.register_step1_group_name);
        tv.setText(group.getName());
        tv.setTypeface(Variables.objFont);

        ImageView iv_indicator = (ImageView) convertView.findViewById(R.id.register_step1_group_indicator_id);
        ImageView iv_check_group = (ImageView) convertView.findViewById(R.id.register_step1_check_group_id);

        if (isExpanded) {
            convertView.setBackgroundColor(Color.parseColor("#667280"));
            tv.setTextColor(Color.parseColor("#F5F5F5"));
            iv_indicator.setImageResource(R.drawable.ico_angel_up);
            iv_check_group.setVisibility(View.VISIBLE);

        } else {
            convertView.setBackgroundColor(Color.parseColor("#F5F5F5"));
            tv.setTextColor(Color.parseColor("#667280"));
            iv_indicator.setImageResource(R.drawable.ico_angel_down);
            iv_check_group.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Child child = (Child) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.register_step1_child_item, null);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.register_borrower_textview_id);
        tv.setText(child.getName());
        tv.setTypeface(Variables.objFont);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
