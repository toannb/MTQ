package com.nganluong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nganluong.fragment.FogetPassFragmentStep1;
import com.nganluong.fragment.FogetPassFragmentStep2;
import com.nganluong.fragment.FogetPassFragmentStep3;

/**
 * Created by DucChinh on 6/18/2015.
 */
public class FogetPassFragmentAdapter extends FragmentPagerAdapter {

    public FogetPassFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FogetPassFragmentStep1();
                break;
            case 1:
                fragment = new FogetPassFragmentStep2();
                break;
            case 2:
                fragment = new FogetPassFragmentStep3();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
