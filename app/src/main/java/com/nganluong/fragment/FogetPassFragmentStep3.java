package com.nganluong.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;

/**
 * Created by DucChinh on 6/18/2015.
 */
public class FogetPassFragmentStep3 extends Fragment {

    private TextView txtBuoc3, txtTitleBuoc3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foget_step_3_fragment, container, false);

        txtBuoc3 = (TextView) view.findViewById(R.id.txtBuoc3);
        txtTitleBuoc3 = (TextView) view.findViewById(R.id.txtTitleBuoc3);

        txtBuoc3.setTypeface(Variables.objFont);
        txtTitleBuoc3.setTypeface(Variables.objFont);

        return view;
    }
}
