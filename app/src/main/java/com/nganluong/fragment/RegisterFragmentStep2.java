package com.nganluong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;
import com.nganluong.manhthuongquan.RegisterActivity;

/**
 * Created by ToanNB on 6/11/2015.
 */
public class RegisterFragmentStep2 extends Fragment implements View.OnClickListener {

    private TextView txtBuoc2, txtTitleBuoc2, txtDauSo, txtRegisterStepText1, txtRegisterStepText2, txtErrorOTP;
    private EditText editPhoneNumber, editOTP;
    private ImageView btnDeletePhone;
    private Button btnOK, btnOkOTP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_step2_1_layout, container, false);

        txtBuoc2 = (TextView) view.findViewById(R.id.txtBuoc2);
        txtTitleBuoc2 = (TextView) view.findViewById(R.id.txtTitleBuoc2);
        txtDauSo = (TextView) view.findViewById(R.id.txtDauSo);
        txtRegisterStepText1 = (TextView) view.findViewById(R.id.register_step2_otp_textview1);
        txtRegisterStepText2 = (TextView) view.findViewById(R.id.register_step2_otp_textview2);

        editPhoneNumber = (EditText) view.findViewById(R.id.register_step2_1_phone_number);
        btnDeletePhone = (ImageView) view.findViewById(R.id.register_step2_erase_id);
        btnOK = (Button) view.findViewById(R.id.btnOK);
        editOTP = (EditText) view.findViewById(R.id.register_step2_otp_edittext);
        btnOkOTP = (Button) view.findViewById(R.id.btnOkOTP);
        txtErrorOTP = (TextView) view.findViewById(R.id.txtErrorOTP);

        txtBuoc2.setTypeface(Variables.objFont);
        txtTitleBuoc2.setTypeface(Variables.objFont);
        txtDauSo.setTypeface(Variables.objFont);
        editPhoneNumber.setTypeface(Variables.objFont);
        btnOK.setTypeface(Variables.objFont);
        txtRegisterStepText1.setTypeface(Variables.objFont);
        txtRegisterStepText2.setTypeface(Variables.objFont);
        editOTP.setTypeface(Variables.objFont);
        btnOkOTP.setTypeface(Variables.objFont);
        txtErrorOTP.setTypeface(Variables.objFont);

        btnDeletePhone.setOnClickListener(this);
        btnOK.setOnClickListener(this);
        btnOkOTP.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register_step2_erase_id:

                break;

            case R.id.btnOK:

                break;

            case R.id.btnOkOTP:
                ((RegisterActivity) getActivity()).setPage(2);
                break;
        }
    }
}
