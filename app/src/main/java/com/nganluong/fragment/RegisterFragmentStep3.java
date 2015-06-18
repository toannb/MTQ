package com.nganluong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;
import com.nganluong.manhthuongquan.RegisterSuccessActivity;

/**
 * Created by ToanNB on 6/11/2015.
 */
public class RegisterFragmentStep3 extends Fragment implements View.OnClickListener {

    private TextView txtBuoc3, txtTitleBuoc3;
    private Button mCompleteButton;
    private EditText editName, editPasswords, editConfirmPasswords;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_step3_layout, container, false);

        txtBuoc3 = (TextView) view.findViewById(R.id.txtBuoc3);
        txtTitleBuoc3 = (TextView) view.findViewById(R.id.txtTitleBuoc3);

        editName = (EditText) view.findViewById(R.id.register_step3_name_id);
        editPasswords = (EditText) view.findViewById(R.id.register_step3_password_id);
        editConfirmPasswords = (EditText) view.findViewById(R.id.register_step3_password_again_id);

        mCompleteButton = (Button) view.findViewById(R.id.register_step3_complete_button_id);

        txtBuoc3.setTypeface(Variables.objFont);
        txtTitleBuoc3.setTypeface(Variables.objFont);
        editName.setTypeface(Variables.objFont);
        editPasswords.setTypeface(Variables.objFont);
        editConfirmPasswords.setTypeface(Variables.objFont);
        mCompleteButton.setTypeface(Variables.objFont);

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
