package com.nganluong.manhthuongquan;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nganluong.adapter.FogetPassFragmentAdapter;
import com.nganluong.adapter.MyFragmentAdapter;
import com.nganluong.config.Variables;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by DucChinh on 6/17/2015.
 */
public class FogetPasswordsActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView txtTitleFogetPass;
    private ImageView btnCancelFogetPass;
    private ImageView btnBackFogetPass;

    private ActionBar actionBar;
    private ViewPager mViewPagerFogetPasss;
    private CirclePageIndicator mCirclePageIndicatorFogetPass;
    private FogetPassFragmentAdapter mFogetPassFragmentAdapter;

    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_passwords_activity);

        initView();
    }

    private void initView() {
        mViewPagerFogetPasss = (ViewPager) findViewById(R.id.pagerFogetPasss);
        mFogetPassFragmentAdapter = new FogetPassFragmentAdapter(getSupportFragmentManager());
        mViewPagerFogetPasss.setAdapter(mFogetPassFragmentAdapter);

        mCirclePageIndicatorFogetPass = (CirclePageIndicator) findViewById(R.id.indicatorFogetPasss);
        mCirclePageIndicatorFogetPass.setViewPager(mViewPagerFogetPasss);
        mCirclePageIndicatorFogetPass.setCurrentItem(currentPage);

        //set actionbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.foget_passwords_custom_actionbar);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1B727B")));

        txtTitleFogetPass = (TextView) findViewById(R.id.txtTitleFogetPass);
        btnCancelFogetPass = (ImageView) findViewById(R.id.cancel_fogetPass);
        btnBackFogetPass = (ImageView) findViewById(R.id.back_fogetPass);
        btnBackFogetPass.setVisibility(View.GONE);

        txtTitleFogetPass.setTypeface(Variables.objFont);

        btnCancelFogetPass.setOnClickListener(this);
        btnBackFogetPass.setOnClickListener(this);
    }

    public void setPage(int currentPage) {
        if (currentPage == 0) {
            btnBackFogetPass.setVisibility(View.GONE);
        } else {
            btnBackFogetPass.setVisibility(View.VISIBLE);
        }

        this.currentPage = currentPage;
        mCirclePageIndicatorFogetPass.setCurrentItem(currentPage);
    }

    private void setBackPage() {
        if (this.currentPage > 0) {
            setPage(this.currentPage - 1);
        } else {
            setPage(0);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.cancel_fogetPass:
                finish();
                break;

            case R.id.back_fogetPass:
                setBackPage();
                break;
        }
    }
}
