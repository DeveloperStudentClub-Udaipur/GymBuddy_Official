package com.dscudr.gym_buddy.gym_buddy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Utilities extends Fragment {


    public Utilities()
    {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_utilities, container, false);
        LinearLayout linearLayout_water = (LinearLayout)view.findViewById(R.id.water_calculator);
        LinearLayout linearLayout_BMI = (LinearLayout)view.findViewById(R.id.bmi_calculator);
        linearLayout_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),WaterCalculator.class);
                startActivity(i);
            }
        });
        linearLayout_BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),BmiCalculator.class);
                startActivity(i);
            }
        });

        return view;
    }

}
