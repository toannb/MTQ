package com.manhthuongquan.mtq;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import adapter.GridViewAdapter;

/**
 * Created by ToanNB on 6/16/2015.
 */
public class HomePageActivity extends Activity {

    private GridView mGridView;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);

        String[] nameListItem = {this.getResources().getString(R.string.home_page_make_request_loan_cash),
                this.getResources().getString(R.string.home_page_history_loan_cash),
                this.getResources().getString(R.string.home_page_list_loaner),
                this.getResources().getString(R.string.home_page_make_request_instalment),
                this.getResources().getString(R.string.home_page_history_instalment),
                this.getResources().getString(R.string.home_page_list_shop_instalment),
                this.getResources().getString(R.string.home_page_news_mtq),
                this.getResources().getString(R.string.home_page_help),
                this.getResources().getString(R.string.home_page_contact)
        };

        int[] imageLisItem = {R.drawable.ico_money, R.drawable.ico_history, R.drawable.ico_loaners_list,
                R.drawable.ico_installment, R.drawable.ico_history_installment, R.drawable.ico_lisd_store_installment,
                R.drawable.ico_news, R.drawable.ico_help_content,R.drawable.ico_contact};

        mGridView = (GridView) findViewById(R.id.home_page_gridview_id);
        mGridView.setAdapter(new GridViewAdapter(this, nameListItem, imageLisItem));

    }
}
