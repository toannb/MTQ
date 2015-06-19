package com.nganluong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.nganluong.adapter.GridViewAdapter;
import com.nganluong.bean.ItemHomePage;
import com.nganluong.config.Variables;
import com.nganluong.manhthuongquan.R;

import java.util.ArrayList;

/**
 * Created by ToanNB on 6/17/2015.
 */
public class HomeTabFragment extends Fragment implements GridViewAdapter.OnItemBoxClickListener {

    private GridView mGridView;
    private GridViewAdapter mGridViewAdapter;

    private TextView mHomePageTitle;
    private TextView txtUserName;
    private TextView txtUserNumber;

    private String mUserName;
    private int mUserNumber = 5;

    private ArrayList<ItemHomePage> arrItemHomePage = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_page_fragment, container, false);

        initDataView();
        initView(view);
        return view;
    }

    private void initDataView() {
        arrItemHomePage.clear();
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_make_request_loan_cash), R.drawable.ico_money));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_history_loan_cash), R.drawable.ico_history));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_list_loaner), R.drawable.ico_loaners_list));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_make_request_instalment), R.drawable.ico_installment));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_history_instalment), R.drawable.ico_history_installment));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_list_shop_instalment), R.drawable.ico_lisd_store_installment));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_news_mtq), R.drawable.ico_news));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_help), R.drawable.ico_help_content));
        arrItemHomePage.add(new ItemHomePage(this.getResources().getString(R.string.home_page_contact), R.drawable.ico_contact));
    }

    private void initView(View rootView){
        mGridView = (GridView) rootView.findViewById(R.id.home_page_gridview_id);
        mGridViewAdapter = new GridViewAdapter(getActivity().getApplicationContext(), 0, arrItemHomePage);
        mGridView.setAdapter(mGridViewAdapter);
        mGridViewAdapter.setOnItemBoxClickListener(this);

        mHomePageTitle = (TextView) rootView.findViewById(R.id.home_page_title_id);
        mHomePageTitle.setTypeface(Variables.objFont);

        txtUserName = (TextView) rootView.findViewById(R.id.home_page_user_name_id);
        txtUserName.setTypeface(Variables.objFont);

        String strHelloUser = getResources().getString(R.string.home_page_hello_user);
        txtUserName.setText(String.format(strHelloUser, mUserName));

        txtUserNumber = (TextView) rootView.findViewById(R.id.home_page_user_number_id);
        String strUserInform = getResources().getString(R.string.home_page_user_number);
        txtUserNumber.setText(Html.fromHtml(String.format(strUserInform, mUserNumber)));
    }

    @Override
    public void onItemBoxClick(int position, ViewGroup viewParent) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}
