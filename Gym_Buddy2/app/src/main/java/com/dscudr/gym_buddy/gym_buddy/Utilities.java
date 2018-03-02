package com.dscudr.gym_buddy.gym_buddy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Utilities extends Fragment {


    @BindView(R.id.water_calculator)
    LinearLayout waterCalculator;
    @BindView(R.id.bmi_calculator)
    LinearLayout bmiCalculator;
    Unbinder unbinder;

    public Utilities() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_utilities, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.water_calculator, R.id.bmi_calculator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.water_calculator:
                Intent i = new Intent(getContext(), WaterCalculator.class);
                startActivity(i);
                break;
            case R.id.bmi_calculator:
                Intent i1 = new Intent(getContext(), BmiCalculator.class);
                startActivity(i1);
                break;
        }
    }
}
