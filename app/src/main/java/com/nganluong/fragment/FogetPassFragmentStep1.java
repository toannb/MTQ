package com.nganluong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * Created by DucChinh on 6/18/2015.
 */
public class FogetPassFragmentStep1 extends Fragment implements View.OnClickListener {

    private TextView txtBuoc1FogetPass, txtTitleBuoc1FogetPass, txtDauSo;
    private EditText editPhoneFogetPass;
    private ImageView btnDeletePhoneFogetPass;
    private Button btnOKFogetPass;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foget_step_1_fragment, container, false);

        txtBuoc1FogetPass = (TextView) view.findViewById(R.id.txtBuoc1FogetPass);
        txtTitleBuoc1FogetPass = (TextView) view.findViewById(R.id.txtTitleBuoc1FogetPass);
        txtDauSo = (TextView) view.findViewById(R.id.txtDauSo);
        editPhoneFogetPass = (EditText) view.findViewById(R.id.editPhoneFogetPass);
        btnDeletePhoneFogetPass = (ImageView) view.findViewById(R.id.btnDeletePhoneFogetPass);
        btnOKFogetPass = (Button) view.findViewById(R.id.btnOKFogetPass);

        txtBuoc1FogetPass.setTypeface(Variables.objFont);
        txtTitleBuoc1FogetPass.setTypeface(Variables.objFont);
        txtDauSo.setTypeface(Variables.objFont);
        editPhoneFogetPass.setTypeface(Variables.objFont);
        btnOKFogetPass.setTypeface(Variables.objFont);

        btnDeletePhoneFogetPass.setOnClickListener(this);
        btnOKFogetPass.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnDeletePhoneFogetPass:

                break;

            case R.id.btnOKFogetPass:
                ((FogetPasswordsActivity) getActivity()).setPage(1);
                break;
        }
    }
}
