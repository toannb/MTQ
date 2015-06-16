package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.manhthuongquan.mtq.R;
import com.manhthuongquan.mtq.RegisterSuccessActivity;

/**
 * Created by ToanNB on 6/11/2015.
 */
public class RegisterFragmentStep3 extends Fragment {

    private Button mCompleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_step3_layout, container, false);

        mCompleteButton = (Button)view.findViewById(R.id.register_step3_complete_button_id);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((ActionBarActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), RegisterSuccessActivity.class));
            }
        });

    }
}
