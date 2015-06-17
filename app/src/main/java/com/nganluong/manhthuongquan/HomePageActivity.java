package com.nganluong.manhthuongquan;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import com.nganluong.adapter.GridViewAdapter;
import com.nganluong.bean.ItemHomePage;

import java.util.ArrayList;

/**
 * Created by ToanNB on 6/16/2015.
 */
public class HomePageActivity extends Activity {

    private GridView mGridView;
    private ArrayList<ItemHomePage> arrItemHomePage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);

        initDataView();
        initView();
    }

    private void initDataView() {
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

    private void initView() {
        mGridView = (GridView) findViewById(R.id.home_page_gridview_id);
        mGridView.setAdapter(new GridViewAdapter(getApplicationContext(), 0, arrItemHomePage));
    }
}
