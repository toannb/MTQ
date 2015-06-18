package com.nganluong.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.FogetPasswordsActivity;
import com.nganluong.manhthuongquan.R;

import org.w3c.dom.Text;

/**
 * Created by DucChinh on 6/18/2015.
 */
public class FogetPassFragmentStep2 extends Fragment implements View.OnClickListener {

    private TextView txtBuoc2, txtTitleBuoc2, txtDauSo, txtContent1, txtContent2, txtFogetPassErrorOTP;
    private EditText editFogetPassStep2Phone, editFogetPassOTP;
    private ImageView btnFogetPassDeletePhoneStep2;
    private Button btnOKFogetPassStep2, btnFogetPassOkOTP;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foget_step_2_fragment, container, false);

        txtBuoc2 = (TextView) view.findViewById(R.id.txtBuoc2);
        txtTitleBuoc2 = (TextView) view.findViewById(R.id.txtTitleBuoc2);
        txtDauSo = (TextView) view.findViewById(R.id.txtDauSo);
        editFogetPassStep2Phone = (EditText) view.findViewById(R.id.editFogetPassStep2Phone);
        btnFogetPassDeletePhoneStep2 = (ImageView) view.findViewById(R.id.btnFogetPassDeletePhoneStep2);
        btnOKFogetPassStep2 = (Button) view.findViewById(R.id.btnOKFogetPassStep2);
        txtContent1 = (TextView) view.findViewById(R.id.foget_step2_otp_textview1);
        txtContent2 = (TextView) view.findViewById(R.id.foget_step2_otp_textview2);
        editFogetPassOTP = (EditText) view.findViewById(R.id.editFogetPassOTP);
        btnFogetPassOkOTP = (Button) view.findViewById(R.id.btnFogetPassOkOTP);
        txtFogetPassErrorOTP = (TextView) view.findViewById(R.id.txtFogetPassErrorOTP);

        txtBuoc2.setTypeface(Variables.objFont);
        txtTitleBuoc2.setTypeface(Variables.objFont);
        txtDauSo.setTypeface(Variables.objFont);
        editFogetPassStep2Phone.setTypeface(Variables.objFont);
        btnOKFogetPassStep2.setTypeface(Variables.objFont);
        txtContent1.setTypeface(Variables.objFont);
        txtContent2.setTypeface(Variables.objFont);
        editFogetPassOTP.setTypeface(Variables.objFont);
        btnFogetPassOkOTP.setTypeface(Variables.objFont);
        txtFogetPassErrorOTP.setTypeface(Variables.objFont);

        btnFogetPassDeletePhoneStep2.setOnClickListener(this);
        btnOKFogetPassStep2.setOnClickListener(this);
        btnFogetPassOkOTP.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnFogetPassDeletePhoneStep2:

                break;

            case R.id.btnOKFogetPassStep2:

                break;

            case R.id.btnFogetPassOkOTP:
                ((FogetPasswordsActivity) getActivity()).setPage(2);
                break;
        }
    }
}
