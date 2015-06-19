package com.nganluong.manhthuongquan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nganluong.config.Variables;

import org.w3c.dom.Text;

/**
 * Created by ToanNB on 6/16/2015.
 */
public class RegisterSuccessActivity extends Activity implements View.OnClickListener {

    private TextView txtTitleSuccess, txtName, txtSuccessLine1, txtSuccessLine2;
    private ImageView btnEditInformation;
    private Button btnSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_success);

        initView();
    }

    private void initView() {
        txtTitleSuccess = (TextView) findViewById(R.id.txtTitleSuccess);
        txtName = (TextView) findViewById(R.id.name_congratunation);
        txtSuccessLine1 = (TextView) findViewById(R.id.txtSuccessLine1);
        txtSuccessLine2 = (TextView) findViewById(R.id.txtSuccessLine2);
        btnEditInformation = (ImageView) findViewById(R.id.edit_information);
        btnSuccess = (Button) findViewById(R.id.success_ignore_button);

        txtTitleSuccess.setTypeface(Variables.objFont);
        txtName.setTypeface(Variables.objFont);
        txtSuccessLine1.setTypeface(Variables.objFont);
        txtSuccessLine2.setTypeface(Variables.objFont);
        btnSuccess.setTypeface(Variables.objFont);

        btnEditInformation.setOnClickListener(this);
        btnSuccess.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.edit_information:

                break;

            case R.id.success_ignore_button:
                Intent intentHomePage = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intentHomePage);
                finish();
                break;
        }
    }
}
