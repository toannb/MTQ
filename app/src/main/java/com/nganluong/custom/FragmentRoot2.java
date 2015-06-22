package com.nganluong.custom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nganluong.config.Variables;
import com.nganluong.fragment.AccountStep2Fragment;
import com.nganluong.fragment.AccountStep3Fragment;
import com.nganluong.fragment.AccountTabFragment;
import com.nganluong.manhthuongquan.R;

public class FragmentRoot2 extends Fragment {

    private AccountTabFragment accountTabFragment;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        } else if (view == null) {
                view = inflater.inflate(R.layout.fragment_root, container, false);
                changeFragment(0);
        }

        return view;
    }

    public void changeFragment(int id) {
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
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.root_frame, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        }
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        if (accountTabFragment != null && accountTabFragment.isAdded()) {
            accountTabFragment.onResume();
        }
    }
}
