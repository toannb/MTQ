package com.nganluong.manhthuongquan;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.viewpagerindicator.CirclePageIndicator;

import com.nganluong.adapter.MyFragmentAdapter;

/**
 * Created by ToanNB on 6/10/2015.
 */
public class RegisterActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView txtTitleRegister;
    private ImageView btnCancel;
    private ImageView btnBack;

    private ActionBar actionBar;
    private ViewPager mViewPager;
    private CirclePageIndicator mCirclePageIndicator;
    private MyFragmentAdapter mMyFragmentAdapter;

    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_viewpager);

        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mMyFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyFragmentAdapter);

        mCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mCirclePageIndicator.setViewPager(mViewPager);
        mCirclePageIndicator.setCurrentItem(currentPage);

        //set actionbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.register_layout_1_custom_actionbar);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1B727B")));

        txtTitleRegister = (TextView) findViewById(R.id.txtTitleRegister);
        btnCancel = (ImageView) findViewById(R.id.cancel_register);
        btnBack = (ImageView) findViewById(R.id.back_register);
        btnBack.setVisibility(View.GONE);

        txtTitleRegister.setTypeface(Variables.objFont);

        btnCancel.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    public void setPage(int currentPage) {
        if (currentPage == 0) {
            btnBack.setVisibility(View.GONE);
        } else {
            btnBack.setVisibility(View.VISIBLE);
        }

        this.currentPage = currentPage;
        mCirclePageIndicator.setCurrentItem(currentPage);
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
            case R.id.cancel_register:
                finish();
                break;

            case R.id.back_register:
                setBackPage();
                break;
        }
    }
}
