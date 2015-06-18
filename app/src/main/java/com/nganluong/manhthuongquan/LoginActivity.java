package com.nganluong.manhthuongquan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nganluong.config.Variables;

/**
 * Created by ToanNB on 6/12/2015.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private TextView txtDauSo, txtForgetPassword, txtRegister;
    private EditText editPhoneInLogin, editPasswords;
    private ImageView btnEyes;
    private Button btnLogin;

    private boolean checkShowPasswords = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        initView();
    }

    private void initView() {
        txtDauSo = (TextView)findViewById(R.id.txtDauSo);
        editPhoneInLogin = (EditText) findViewById(R.id.phone_in_login);
        editPasswords = (EditText) findViewById(R.id.password);
        btnEyes = (ImageView) findViewById(R.id.btnEyes);
        btnLogin = (Button) findViewById(R.id.login_button);
        txtForgetPassword = (TextView)findViewById(R.id.forget_password);
        txtRegister = (TextView)findViewById(R.id.register);

        txtDauSo.setTypeface(Variables.objFont);
        editPhoneInLogin.setTypeface(Variables.objFont);
        editPasswords.setTypeface(Variables.objFont);
        btnLogin.setTypeface(Variables.objFont);
        txtForgetPassword.setTypeface(Variables.objFont);
        txtRegister.setTypeface(Variables.objFont);

        txtRegister.setOnClickListener(this);
        txtForgetPassword.setOnClickListener(this);
        btnEyes.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    private boolean checkPhoneNumber() {
        if (editPhoneInLogin.getText().toString().length() > 0) {
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Bạn cần nhập số điện thoại", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean checkPasswords() {
        int passwordsLength = editPasswords.getText().toString().length();
        if (passwordsLength > 0) {
            if (passwordsLength >= 6 && passwordsLength <= 8) {
                if (Character.isUpperCase(editPasswords.getText().charAt(0))) {
                    if(editPasswords.getText().toString().matches(".*\\d.*")){
                        return true;
                    } else{
                        Toast.makeText(getApplicationContext(), "Mật khẩu phải chứa 1 chữ số", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Chữ cái đầu tiên phải là chữ in hoa", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                Toast.makeText(getApplicationContext(), "Mật khẩu phải từ 6 đến 8 ký tự", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Bạn cần nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void hideOrShowPasswords() {
        if (checkShowPasswords == true) {
            editPasswords.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            editPasswords.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        editPasswords.setSelection(editPasswords.getText().toString().length());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;

            case R.id.forget_password:
                Intent intentForgetPasswords = new Intent(getApplicationContext(), FogetPasswordsActivity.class);
                startActivity(intentForgetPasswords);
                break;

            case R.id.btnEyes:
                int passwordsLength = editPasswords.getText().toString().length();
                if (passwordsLength > 0) {
                    if (checkShowPasswords == false) {
                        checkShowPasswords = true;
                    } else {
                        checkShowPasswords = false;
                    }
                    hideOrShowPasswords();
                }
                break;

            case R.id.login_button:
                if (checkPhoneNumber() == true && checkPasswords() == true) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu đã được chấp nhận", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
