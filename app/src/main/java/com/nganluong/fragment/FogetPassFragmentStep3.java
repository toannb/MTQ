package com.nganluong.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;

/**
 * Created by DucChinh on 6/18/2015.
 */
public class FogetPassFragmentStep3 extends Fragment implements View.OnClickListener {

    private TextView txtBuoc3, txtTitleBuoc3, txtConfirmChangePass;
    private EditText editPassNew, editConfirmPassNew;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foget_step_3_fragment, container, false);

        txtBuoc3 = (TextView) view.findViewById(R.id.txtBuoc3);
        txtTitleBuoc3 = (TextView) view.findViewById(R.id.txtTitleBuoc3);
        editPassNew = (EditText) view.findViewById(R.id.editPassNew);
        editConfirmPassNew = (EditText) view.findViewById(R.id.editConfirmPassNew);
        txtConfirmChangePass = (TextView) view.findViewById(R.id.txtConfirmChangePass);

        txtBuoc3.setTypeface(Variables.objFont);
        txtTitleBuoc3.setTypeface(Variables.objFont);
        editPassNew.setTypeface(Variables.objFont);
        editConfirmPassNew.setTypeface(Variables.objFont);
        txtConfirmChangePass.setTypeface(Variables.objFont);

        txtConfirmChangePass.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.txtConfirmChangePass:

                break;
        }
    }
}
