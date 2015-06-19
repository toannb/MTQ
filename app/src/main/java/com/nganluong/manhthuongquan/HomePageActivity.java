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
import android.widget.Toast;

import com.nganluong.config.Variables;
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

    private TextView txtNameTab;
    private ImageView imgIconTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_activity);

        initView();
    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_1_TAG),
                getResources().getString(R.string.home_page_title), R.drawable.ico_menu_bar), HomeTabFragment.class, null);
        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_2_TAG),
                getResources().getString(R.string.home_page_user_title), R.drawable.ico_accounts), AccountTabFragment.class, null);
        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_3_TAG),
                getResources().getString(R.string.home_page_inform_title), R.drawable.ico_notify), NotifyTabFragment.class, null);
        mTabHost.addTab(setIndicator(HomePageActivity.this, mTabHost.newTabSpec(TAB_4_TAG),
                getResources().getString(R.string.home_page_help_title), R.drawable.ico_help_footer), HelpTabFragment.class, null);

        mTabHost.getTabWidget().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.actionbar_bg));
        mTabHost.setOnTabChangedListener(this);
    }

    private TabHost.TabSpec setIndicator(Context ctx, TabHost.TabSpec spec, String string, int genresIcon) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.tab_item, null);
        txtNameTab = (TextView) v.findViewById(R.id.txt_tabtxt);
        imgIconTab = (ImageView) v.findViewById(R.id.img_tabtxt);

        txtNameTab.setText(string);
        txtNameTab.setTypeface(Variables.objFont);
        imgIconTab.setBackgroundResource(genresIcon);

        return spec.setIndicator(v);
    }

    @Override
    public void onTabChanged(String tabId) {
        for(int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++){
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.hint_color));
            mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).setBackgroundColor(getResources().getColor(R.color.actionbar_bg));
        }

        if (tabId.equals(TAB_1_TAG)) {
            Toast.makeText(getApplicationContext(), "Tab 1", Toast.LENGTH_SHORT).show();
        } else if (tabId.equals(TAB_2_TAG)) {
            Toast.makeText(getApplicationContext(), "Tab 2", Toast.LENGTH_SHORT).show();
        } else if (tabId.equals(TAB_3_TAG)) {
            Toast.makeText(getApplicationContext(), "Tab 3", Toast.LENGTH_SHORT).show();
        } else if (tabId.equals(TAB_4_TAG)) {
            Toast.makeText(getApplicationContext(), "Tab 4", Toast.LENGTH_SHORT).show();
        }
    }


}
