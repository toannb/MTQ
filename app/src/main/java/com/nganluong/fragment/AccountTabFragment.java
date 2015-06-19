package com.nganluong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nganluong.manhthuongquan.R;

/**
 * Created by ToanNB on 6/17/2015.
 */
public class AccountTabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_step1_layout, container, false);

        return view;
    }


}
