package com.nganluong.manhthuongquan;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.nganluong.config.Variables;
import com.nganluong.custom.FragmentRoot2;
import com.nganluong.fragment.AccountStep2Fragment;
import com.nganluong.fragment.AccountStep3Fragment;
import com.nganluong.fragment.AccountTabFragment;
import com.nganluong.fragment.HelpTabFragment;
import com.nganluong.fragment.HomeTabFragment;
import com.nganluong.fragment.NotifyTabFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by DucChinh on 6/22/2015.
 */
public class DashboardActivity extends FragmentActivity implements
        TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, TabInfo>();
    private PagerAdapter mPagerAdapter;

    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";
    private static final String TAB_3_TAG = "tab_3";
    private static final String TAB_4_TAG = "tab_4";
    private String TAG_CURRENT = "";

    private RelativeLayout boxItemTab;
    private TextView txtNameTab;
    private ImageView imgIconTab;
    private ArrayList<RelativeLayout> arrBoxItemTab = new ArrayList<>();
    private ArrayList<TextView> arrNameTab = new ArrayList<>();
    private ArrayList<ImageView> arrIconTab = new ArrayList<>();

    private class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;
        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }
    }

    class TabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public TabFactory(Context context) {
            mContext = context;
        }

        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        // Initialise the TabHost
        this.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
        }
        // Intialise ViewPager
        intialiseViewPager();
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }

    private void intialiseViewPager() {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, HomeTabFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, FragmentRoot2.class.getName()));
        fragments.add(Fragment.instantiate(this, NotifyTabFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, HelpTabFragment.class.getName()));
        mPagerAdapter  = new PagerAdapter(super.getSupportFragmentManager(), fragments);

        mViewPager = (ViewPager) findViewById(R.id.tabviewpager);
        mViewPager.setAdapter(this.mPagerAdapter);
        mViewPager.setOnPageChangeListener(this);
    }

    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;

        TabHost.TabSpec tabSpec1 = setIndicator(DashboardActivity.this, mTabHost.newTabSpec(TAB_1_TAG),
                getResources().getString(R.string.home_page_title), R.drawable.ico_menu_bar);
        DashboardActivity.AddTab(this, this.mTabHost, tabSpec1, (tabInfo = new TabInfo("Tab1", HomeTabFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        TabHost.TabSpec tabSpec2 = setIndicator(DashboardActivity.this, mTabHost.newTabSpec(TAB_2_TAG),
                getResources().getString(R.string.home_page_user_title), R.drawable.ico_accounts);
        DashboardActivity.AddTab(this, this.mTabHost, tabSpec2, (tabInfo = new TabInfo("Tab2", FragmentRoot2.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        TabHost.TabSpec tabSpec3 = setIndicator(DashboardActivity.this, mTabHost.newTabSpec(TAB_3_TAG),
                getResources().getString(R.string.home_page_inform_title), R.drawable.ico_notify);
        DashboardActivity.AddTab(this, this.mTabHost, tabSpec3, (tabInfo = new TabInfo("Tab3", NotifyTabFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        TabHost.TabSpec tabSpec4 = setIndicator(DashboardActivity.this, mTabHost.newTabSpec(TAB_4_TAG),
                getResources().getString(R.string.home_page_help_title), R.drawable.ico_help_footer);
        DashboardActivity.AddTab(this, this.mTabHost, tabSpec4, (tabInfo = new TabInfo("Tab4", HelpTabFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        changeTab(0);

        mTabHost.setOnTabChangedListener(this);
    }

    private TabHost.TabSpec setIndicator(Context ctx, TabHost.TabSpec spec, String string, int genresIcon) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.tab_item, null);
        boxItemTab = (RelativeLayout) v.findViewById(R.id.boxItem);
        txtNameTab = (TextView) v.findViewById(R.id.txt_tabtxt);
        imgIconTab = (ImageView) v.findViewById(R.id.img_tabtxt);

        txtNameTab.setText(string);
        txtNameTab.setTypeface(Variables.objFont);
        imgIconTab.setBackgroundResource(genresIcon);

        arrBoxItemTab.add(boxItemTab);
        arrNameTab.add(txtNameTab);
        arrIconTab.add(imgIconTab);

        return spec.setIndicator(v);
    }

    private static void AddTab(DashboardActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach a Tab view factory to the spec
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    public void onTabChanged(String tag) {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }

    private void changeTab(int id) {
        switch (id) {
            case 0:
                TAG_CURRENT = TAB_1_TAG;

                arrBoxItemTab.get(0).setBackgroundColor(getResources().getColor(R.color.gray));
                arrBoxItemTab.get(1).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(2).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(3).setBackgroundColor(getResources().getColor(R.color.white));

                arrNameTab.get(0).setTextColor(getResources().getColor(R.color.white));
                arrNameTab.get(1).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(2).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(3).setTextColor(getResources().getColor(R.color.gray));

                arrIconTab.get(0).setBackgroundResource(R.drawable.ico_menu_bar_active);
                arrIconTab.get(1).setBackgroundResource(R.drawable.ico_accounts);
                arrIconTab.get(2).setBackgroundResource(R.drawable.ico_notify);
                arrIconTab.get(3).setBackgroundResource(R.drawable.ico_help_footer);
                break;

            case 1:
                TAG_CURRENT = TAB_2_TAG;

                arrBoxItemTab.get(1).setBackgroundColor(getResources().getColor(R.color.gray));
                arrBoxItemTab.get(0).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(2).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(3).setBackgroundColor(getResources().getColor(R.color.white));

                arrNameTab.get(1).setTextColor(getResources().getColor(R.color.white));
                arrNameTab.get(0).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(2).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(3).setTextColor(getResources().getColor(R.color.gray));

                arrIconTab.get(0).setBackgroundResource(R.drawable.ico_menu_bar);
                arrIconTab.get(1).setBackgroundResource(R.drawable.ico_accounts_active);
                arrIconTab.get(2).setBackgroundResource(R.drawable.ico_notify);
                arrIconTab.get(3).setBackgroundResource(R.drawable.ico_help_footer);
                break;

            case 2:
                TAG_CURRENT = TAB_3_TAG;

                arrBoxItemTab.get(2).setBackgroundColor(getResources().getColor(R.color.gray));
                arrBoxItemTab.get(0).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(1).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(3).setBackgroundColor(getResources().getColor(R.color.white));

                arrNameTab.get(2).setTextColor(getResources().getColor(R.color.white));
                arrNameTab.get(0).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(1).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(3).setTextColor(getResources().getColor(R.color.gray));

                arrIconTab.get(0).setBackgroundResource(R.drawable.ico_menu_bar);
                arrIconTab.get(1).setBackgroundResource(R.drawable.ico_accounts);
                arrIconTab.get(2).setBackgroundResource(R.drawable.ico_notify_active);
                arrIconTab.get(3).setBackgroundResource(R.drawable.ico_help_footer);
                break;

            case 3:
                TAG_CURRENT = TAB_4_TAG;

                arrBoxItemTab.get(3).setBackgroundColor(getResources().getColor(R.color.gray));
                arrBoxItemTab.get(0).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(1).setBackgroundColor(getResources().getColor(R.color.white));
                arrBoxItemTab.get(2).setBackgroundColor(getResources().getColor(R.color.white));

                arrNameTab.get(3).setTextColor(getResources().getColor(R.color.white));
                arrNameTab.get(0).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(1).setTextColor(getResources().getColor(R.color.gray));
                arrNameTab.get(2).setTextColor(getResources().getColor(R.color.gray));

                arrIconTab.get(0).setBackgroundResource(R.drawable.ico_menu_bar);
                arrIconTab.get(1).setBackgroundResource(R.drawable.ico_accounts);
                arrIconTab.get(2).setBackgroundResource(R.drawable.ico_notify);
                arrIconTab.get(3).setBackgroundResource(R.drawable.ico_help_footer_active);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int position) {
        // TODO Auto-generated method stub
        this.mTabHost.setCurrentTab(position);
        changeTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onBackPressed() {
        if (Variables.currentPage > 0 && TAG_CURRENT.equals(TAB_2_TAG)) {
            changeFragment(Variables.currentPage - 1);
        } else {
            finish();
        }
    }

    private void changeFragment(int id) {
        switch (id) {
            case 0:
                Variables.currentPage = 0;
                AccountTabFragment accountTabFragment = new AccountTabFragment();
                switchFragment(accountTabFragment);
                break;

            case 1:
                Variables.currentPage = 1;
                AccountStep2Fragment accountStep2Fragment = new AccountStep2Fragment();
                switchFragment(accountStep2Fragment);
                break;

            case 2:
                Variables.currentPage = 2;
                AccountStep3Fragment accountStep3Fragment = new AccountStep3Fragment();
                switchFragment(accountStep3Fragment);
                break;

            case 3:

                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.root_frame, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        }
    }
}
