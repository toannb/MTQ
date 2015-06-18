package com.nganluong.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    private boolean checkNullPass() {
        if (editPassNew.getText().toString().length() > 0) {
            if (editConfirmPassNew.getText().toString().length() > 0) {
                return true;
            } else {
                Toast.makeText(getActivity(), "Bạn cần nhập lại mật khẩu", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getActivity(), "Bạn cần nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean checkConfirmPass() {
        String pass = editPassNew.getText().toString();
        String passConfirm = editConfirmPassNew.getText().toString();

        if (pass.equals(passConfirm)) {
            return true;
        } else {
            Toast.makeText(getActivity(), "Mật khẩu cần giống nhau", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean checkPasswords() {
        int passwordsLength = editPassNew.getText().toString().length();
        if (passwordsLength > 0) {
            if (passwordsLength >= 6 && passwordsLength <= 8) {
                if (Character.isUpperCase(editPassNew.getText().charAt(0))) {
                    if(editPassNew.getText().toString().matches(".*\\d.*")){
                        return true;
                    } else{
                        Toast.makeText(getActivity(), "Mật khẩu phải chứa 1 chữ số", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                } else {
                    Toast.makeText(getActivity(), "Chữ cái đầu tiên phải là chữ in hoa", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                Toast.makeText(getActivity(), "Mật khẩu phải từ 6 đến 8 ký tự", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getActivity(), "Bạn cần nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.txtConfirmChangePass:
                if (checkNullPass() && checkPasswords() && checkConfirmPass()) {
                    Toast.makeText(getActivity(), "Mật khẩu được chấp nhận", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
