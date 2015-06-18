package com.nganluong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;

import java.util.ArrayList;

import com.nganluong.adapter.ExpandListAdapter;
import com.nganluong.bean.Child;
import com.nganluong.bean.Group;
import com.nganluong.manhthuongquan.RegisterActivity;

/**
 * Created by ToanNB on 6/11/2015.
 */
public class RegisterFragmentStep1 extends Fragment implements ExpandableListView.OnChildClickListener, View.OnClickListener {

    private ExpandableListView mExpandableListView;
    private ExpandListAdapter mExpandListAdapter;
    private ArrayList<Group> mListGroups;

    private TextView txtBuoc1, txtTitleBuoc1;

    private Button btnContinueRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_step1_layout, container, false);

        txtBuoc1 = (TextView) view.findViewById(R.id.txtBuoc1);
        txtTitleBuoc1 = (TextView) view.findViewById(R.id.txtTitleBuoc1);

        btnContinueRegister = (Button) view.findViewById(R.id.register_step1_continute_button);

        mExpandableListView = (ExpandableListView) view.findViewById(R.id.register_expand_listview);
        mListGroups = addListItem();
        mExpandListAdapter = new ExpandListAdapter(this.getActivity().getApplication(), mListGroups);
        mExpandableListView.setAdapter(mExpandListAdapter);

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;

        mExpandableListView.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));

        btnContinueRegister.setOnClickListener(this);

        btnContinueRegister.setTypeface(Variables.objFont);
        txtBuoc1.setTypeface(Variables.objFont);
        txtTitleBuoc1.setTypeface(Variables.objFont);

        return view;
    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    public ArrayList<Group> addListItem() {
        ArrayList<Group> groupArrayList = new ArrayList<Group>();

        Group group1 = new Group();
        group1.setName(getResources().getString(R.string.register_step1_borrower_title));
        group1.setItems(new Child(getResources().getString(R.string.register_borrower_content)));
        groupArrayList.add(group1);

        Group group2 = new Group();
        group2.setName(getResources().getString(R.string.register_step1_loaner_title));
        group2.setItems(new Child(getResources().getString(R.string.register_loaner_content)));
        groupArrayList.add(group2);

        Group group3 = new Group();
        group3.setName(getResources().getString(R.string.register_step1_shop_title));
        group3.setItems(new Child(getResources().getString(R.string.register_shop_content)));
        groupArrayList.add(group3);

        return groupArrayList;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
        parent.setItemChecked(index, true);

        return false;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register_step1_continute_button:
                ((RegisterActivity) getActivity()).setPage(1);
                break;
        }
    }
}
