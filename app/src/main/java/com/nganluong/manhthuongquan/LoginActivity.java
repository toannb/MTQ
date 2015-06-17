package com.nganluong.manhthuongquan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nganluong.config.Variables;

/**
 * Created by ToanNB on 6/12/2015.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private TextView mForgetPassword, mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        initView();
    }

    private void initView() {
        mForgetPassword = (TextView)findViewById(R.id.forget_password);
        mRegister = (TextView)findViewById(R.id.register);

        mForgetPassword.setTypeface(Variables.objFont);
        mRegister.setTypeface(Variables.objFont);

        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }
}
