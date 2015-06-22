package com.nganluong.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nganluong.custom.FragmentRoot2;
import com.nganluong.manhthuongquan.R;

public class AccountStep3Fragment extends FragmentRoot2 {

    public AccountStep3Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_step_3_fragment, container, false);

        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeFragment(1);
            }
        });
        return view;
    }

}
