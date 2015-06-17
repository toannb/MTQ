package com.nganluong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nganluong.fragment.RegisterFragmentStep1;
import com.nganluong.fragment.RegisterFragmentStep2;
import com.nganluong.fragment.RegisterFragmentStep3;

/**
 * Created by ToanNB on 6/11/2015.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {


    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new RegisterFragmentStep1();
                break;
            case 1:
                fragment = new RegisterFragmentStep2();
                break;
            case 2:
                fragment = new RegisterFragmentStep3();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
