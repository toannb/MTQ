package com.manhthuongquan.mtq;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.viewpagerindicator.CirclePageIndicator;

import adapter.MyFragmentAdapter;

/**
 * Created by ToanNB on 6/10/2015.
 */
public class RegisterActivity extends ActionBarActivity implements View.OnClickListener {

    private ImageView btnCancel;

    private ActionBar actionBar;
    private ViewPager mViewPager;
    private CirclePageIndicator mCirclePageIndicator;
    private MyFragmentAdapter mMyFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_viewpager);

        initView();
        initData();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mMyFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyFragmentAdapter);

        mCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mCirclePageIndicator.setViewPager(mViewPager);
        mCirclePageIndicator.setCurrentItem(0);

        //set actionbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.register_layout_1_custom_actionbar);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1B727B")));

        btnCancel = (ImageView) findViewById(R.id.cancel_register);
        btnCancel.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.cancel_register:
                Intent intentCancle = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentCancle);
                finish();
                break;
        }
    }
}
