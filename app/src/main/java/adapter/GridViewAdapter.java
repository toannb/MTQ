package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.manhthuongquan.mtq.R;

/**
 * Created by ToanNB on 6/16/2015.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mNameList;
    private int[] mImageList;
    private LayoutInflater inflater=null;

    public GridViewAdapter(Context context, String[] nameList, int[] imageList) {
        mContext = context;
        mNameList = nameList;
        mImageList = imageList;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mNameList.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        TextView textView;
        View rowView;
        rowView = inflater.inflate(R.layout.home_page_custom_item_gridview, null);

        imageView = (ImageView)rowView.findViewById(R.id.home_page_gridview_item_image);
        textView = (TextView)rowView.findViewById(R.id.home_page_gridview_item_title);

        imageView.setImageResource(mImageList[position]);
        textView.setText(mNameList[position]);

        return rowView;
    }
}
