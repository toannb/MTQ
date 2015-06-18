package com.nganluong.manhthuongquan;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.nganluong.fragment.AccountTabFragment;
import com.nganluong.fragment.HelpTabFragment;
import com.nganluong.fragment.HomeTabFragment;
import com.nganluong.fragment.NotifyTabFragment;

/**
 * Created by ToanNB on 6/16/2015.
 */
public class HomePageActivity extends FragmentActivity implements TabHost.OnTabChangeListener{

    private FragmentTabHost mTabHost;
    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";
    private static final String TAB_3_TAG = "tab_3";
    private static final String TAB_4_TAG = "tab_4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_activity);

        initView();

        mTabHost.setOnTabChangedListener(this);
    }

    private void initView() {

        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_1_TAG), "Trang chủ", R.drawable.ico_menu_bar), HomeTabFragment.class, null);
        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_2_TAG), "Tài khoản", R.drawable.ico_accounts), AccountTabFragment.class, null);
        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_3_TAG), "Thông báo", R.drawable.ico_notify), NotifyTabFragment.class, null);
        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_4_TAG), "Trợ giúp", R.drawable.ico_help_footer), HelpTabFragment.class, null);

        mTabHost.getTabWidget().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.actionbar_bg));
    }

    private TabHost.TabSpec setIndicator(Context ctx, TabHost.TabSpec spec, String string, int genresIcon) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.tab_item, null);
        TextView tv = (TextView) v.findViewById(R.id.txt_tabtxt);
        ImageView img = (ImageView) v.findViewById(R.id.img_tabtxt);

        tv.setText(string);
        img.setBackgroundResource(genresIcon);
        return spec.setIndicator(v);
    }

    @Override
    public void onTabChanged(String tabId) {
        for(int i = 0; i < mTabHost.getTabWidget().getChildCount();i++){
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.hint_color));

            mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).setBackgroundColor(getResources().getColor(R.color.actionbar_bg));
        }
    }


}
