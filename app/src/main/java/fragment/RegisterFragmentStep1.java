package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.manhthuongquan.mtq.R;

import java.util.ArrayList;

import adapter.ExpandListAdapter;
import helper.Child;
import helper.Group;

/**
 * Created by ToanNB on 6/11/2015.
 */
public class RegisterFragmentStep1 extends Fragment implements ExpandableListView.OnChildClickListener {


    private ExpandableListView mExpandableListView;
    private ExpandListAdapter mExpandListAdapter;
    private ArrayList<Group> mListGroups;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_step1_layout, container, false);

        mExpandableListView = (ExpandableListView) view.findViewById(R.id.register_expand_listview);
        mListGroups = addListItem();
        mExpandListAdapter = new ExpandListAdapter(this.getActivity().getApplication(), mListGroups);
        mExpandableListView.setAdapter(mExpandListAdapter);

//        int right = (int) (getResources().getDisplayMetrics().widthPixels - TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics()));
//        mExpandableListView.setIndicatorBounds(right - getResources().getDrawable(R.drawable.ico_angel_up)
//                .getIntrinsicWidth(),right);

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;


        mExpandableListView.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));




        return view;
    }
    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    public ArrayList<Group> addListItem() {
        ArrayList<Group> groupArrayList = new ArrayList<Group>();

        Group group1 = new Group(getResources().getString(R.string.register_step1_borrower_title));
        group1.setItems(new Child(getResources().getString(R.string.register_borrower_content)));
        groupArrayList.add(group1);

        Group group2 = new Group(getResources().getString(R.string.register_step1_loaner_title));
        group2.setItems(new Child(getResources().getString(R.string.register_loaner_content)));
        groupArrayList.add(group2);

        Group group3 = new Group(getResources().getString(R.string.register_step1_shop_title));
        group3.setItems(new Child(getResources().getString(R.string.register_shop_content)));
        groupArrayList.add(group3);

        return groupArrayList;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
        parent.setItemChecked(index, true);

        return false;
    }

}
