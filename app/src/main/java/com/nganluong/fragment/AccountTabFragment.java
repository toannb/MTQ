package com.nganluong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nganluong.config.Constant;
import com.nganluong.config.Variables;
import com.nganluong.custom.FragmentRoot2;
import com.nganluong.manhthuongquan.R;

/**
 * Created by ToanNB on 6/17/2015.
 */
public class AccountTabFragment extends FragmentRoot2 implements View.OnClickListener {

    private ImageView btnBack;
    private TextView txtTitleAccountTab, txtBanLa, txtCauhoilaai;
    private TextView txtSinhvien, txtNgTuDo, txtNgDiLam, txtChuDN;
    private ImageView btnCheckSinhVien, btnCheckNgTuDo, btnCheckNgDiLam, btnCheckChuDN;
    private RelativeLayout boxSinVien, boxNgTuDo, boxNgDiLam, boxChuDN;
    private Button btnContinue;

    private int iStyleUser = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_tab_fragment, container, false);

        initView(view);
        checkStyleUser(iStyleUser);

        return view;
    }

    private void initView(View view) {
        btnBack = (ImageView) view.findViewById(R.id.btnBack);
        txtTitleAccountTab = (TextView) view.findViewById(R.id.txtTitleAccountTab);
        txtBanLa = (TextView) view.findViewById(R.id.txtBanLa);
        txtCauhoilaai = (TextView) view.findViewById(R.id.txtCauhoilaai);
        btnContinue = (Button) view.findViewById(R.id.btnContinue);

        txtSinhvien = (TextView) view.findViewById(R.id.txtSinhvien);
        txtNgTuDo = (TextView) view.findViewById(R.id.txtNgTuDo);
        txtNgDiLam = (TextView) view.findViewById(R.id.txtNgDiLam);
        txtChuDN = (TextView) view.findViewById(R.id.txtChuDN);

        btnCheckSinhVien = (ImageView) view.findViewById(R.id.btnCheckSinhVien);
        btnCheckNgTuDo = (ImageView) view.findViewById(R.id.btnCheckNgTuDo);
        btnCheckNgDiLam = (ImageView) view.findViewById(R.id.btnCheckNgDiLam);
        btnCheckChuDN = (ImageView) view.findViewById(R.id.btnCheckChuDN);

        boxSinVien = (RelativeLayout) view.findViewById(R.id.boxSinVien);
        boxNgTuDo = (RelativeLayout) view.findViewById(R.id.boxNgTuDo);
        boxNgDiLam = (RelativeLayout) view.findViewById(R.id.boxNgDiLam);
        boxChuDN = (RelativeLayout) view.findViewById(R.id.boxChuDN);

        txtTitleAccountTab.setTypeface(Variables.objFont);
        txtBanLa.setTypeface(Variables.objFont);
        txtCauhoilaai.setTypeface(Variables.objFont);
        txtSinhvien.setTypeface(Variables.objFont);
        txtNgTuDo.setTypeface(Variables.objFont);
        txtNgDiLam.setTypeface(Variables.objFont);
        txtChuDN.setTypeface(Variables.objFont);

        btnBack.setOnClickListener(this);
        btnContinue.setOnClickListener(this);
        boxSinVien.setOnClickListener(this);
        boxNgTuDo.setOnClickListener(this);
        boxNgDiLam.setOnClickListener(this);
        boxChuDN.setOnClickListener(this);
    }

    private void checkStyleUser(int id) {
        switch (id) {
            case 0:
                iStyleUser = Constant.TAG_STYLE_USER_SINHVIEN;

                btnCheckSinhVien.setVisibility(View.VISIBLE);
                btnCheckNgTuDo.setVisibility(View.GONE);
                btnCheckNgDiLam.setVisibility(View.GONE);
                btnCheckChuDN.setVisibility(View.GONE);

                txtSinhvien.setTextColor(getResources().getColor(R.color.white));
                txtNgTuDo.setTextColor(getResources().getColor(R.color.gray));
                txtNgDiLam.setTextColor(getResources().getColor(R.color.gray));
                txtChuDN.setTextColor(getResources().getColor(R.color.gray));

                boxSinVien.setBackgroundColor(getResources().getColor(R.color.gray));
                boxNgTuDo.setBackgroundColor(getResources().getColor(R.color.white));
                boxNgDiLam.setBackgroundColor(getResources().getColor(R.color.white));
                boxChuDN.setBackgroundColor(getResources().getColor(R.color.white));

                break;

            case 1:
                iStyleUser = Constant.TAG_STYLE_USER_NGUOITUDO;

                btnCheckSinhVien.setVisibility(View.GONE);
                btnCheckNgTuDo.setVisibility(View.VISIBLE);
                btnCheckNgDiLam.setVisibility(View.GONE);
                btnCheckChuDN.setVisibility(View.GONE);

                txtSinhvien.setTextColor(getResources().getColor(R.color.gray));
                txtNgTuDo.setTextColor(getResources().getColor(R.color.white));
                txtNgDiLam.setTextColor(getResources().getColor(R.color.gray));
                txtChuDN.setTextColor(getResources().getColor(R.color.gray));

                boxSinVien.setBackgroundColor(getResources().getColor(R.color.white));
                boxNgTuDo.setBackgroundColor(getResources().getColor(R.color.gray));
                boxNgDiLam.setBackgroundColor(getResources().getColor(R.color.white));
                boxChuDN.setBackgroundColor(getResources().getColor(R.color.white));

                break;

            case 2:
                iStyleUser = Constant.TAG_STYLE_USER_NGUOIDILAM;

                btnCheckSinhVien.setVisibility(View.GONE);
                btnCheckNgTuDo.setVisibility(View.GONE);
                btnCheckNgDiLam.setVisibility(View.VISIBLE);
                btnCheckChuDN.setVisibility(View.GONE);

                txtSinhvien.setTextColor(getResources().getColor(R.color.gray));
                txtNgTuDo.setTextColor(getResources().getColor(R.color.gray));
                txtNgDiLam.setTextColor(getResources().getColor(R.color.white));
                txtChuDN.setTextColor(getResources().getColor(R.color.gray));

                boxSinVien.setBackgroundColor(getResources().getColor(R.color.white));
                boxNgTuDo.setBackgroundColor(getResources().getColor(R.color.white));
                boxNgDiLam.setBackgroundColor(getResources().getColor(R.color.gray));
                boxChuDN.setBackgroundColor(getResources().getColor(R.color.white));

                break;

            case 3:
                iStyleUser = Constant.TAG_STYLE_USER_CHUDOANHNGHIEP;

                btnCheckSinhVien.setVisibility(View.GONE);
                btnCheckNgTuDo.setVisibility(View.GONE);
                btnCheckNgDiLam.setVisibility(View.GONE);
                btnCheckChuDN.setVisibility(View.VISIBLE);

                txtSinhvien.setTextColor(getResources().getColor(R.color.gray));
                txtNgTuDo.setTextColor(getResources().getColor(R.color.gray));
                txtNgDiLam.setTextColor(getResources().getColor(R.color.gray));
                txtChuDN.setTextColor(getResources().getColor(R.color.white));

                boxSinVien.setBackgroundColor(getResources().getColor(R.color.white));
                boxNgTuDo.setBackgroundColor(getResources().getColor(R.color.white));
                boxNgDiLam.setBackgroundColor(getResources().getColor(R.color.white));
                boxChuDN.setBackgroundColor(getResources().getColor(R.color.gray));

                break;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.boxSinVien:
                checkStyleUser(0);
                break;

            case R.id.boxNgTuDo:
                checkStyleUser(1);
                break;

            case R.id.boxNgDiLam:
                checkStyleUser(2);
                break;

            case R.id.boxChuDN:
                checkStyleUser(3);
                break;

            case R.id.btnBack:

                break;

            case R.id.btnContinue:
                changeFragment(1);
                break;
        }
    }
}
