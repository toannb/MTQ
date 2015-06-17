package com.nganluong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nganluong.manhthuongquan.R;
import com.nganluong.manhthuongquan.RegisterSuccessActivity;

/**
 * Created by ToanNB on 6/11/2015.
 */
public class RegisterFragmentStep3 extends Fragment implements View.OnClickListener {

    private Button mCompleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_step3_layout, container, false);

        ((ActionBarActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCompleteButton = (Button)view.findViewById(R.id.register_step3_complete_button_id);
        mCompleteButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register_step3_complete_button_id:
                Intent intentRegisterSuccess = new Intent(getActivity().getApplicationContext(), RegisterSuccessActivity.class);
                startActivity(intentRegisterSuccess);
                getActivity().finish();
                break;
        }
    }
}
