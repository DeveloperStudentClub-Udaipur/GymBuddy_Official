package com.dscudr.gym_buddy.gym_buddy.DayFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dscudr.gym_buddy.gym_buddy.Adapter;
import com.dscudr.gym_buddy.gym_buddy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FridayFragmentClass extends Fragment {

    RecyclerView rec;
    Adapter md;
    int image_rec[] = {R.drawable.dumbell_curls,R.drawable.preachers_curls,R.drawable.cable_curls,R.drawable.concentration_curls,R.drawable.triceps_extention_curls,R.drawable.triceps_extention_cable,R.drawable.militry_press,R.drawable.dumbell_press,R.drawable.seated_militry_press,R.drawable.dumbell_lateral_raises, R.drawable.cable_front_raises, R.drawable.up_right_rows,R.drawable.crunch};
    String []name;
    public FridayFragmentClass()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_friday_fragment_class, container, false);
        name=getResources().getStringArray(R.array.exercise_name_tue_fri);
        md = new Adapter(getActivity(),image_rec,name,"friday");
        rec = (RecyclerView)view.findViewById(R.id.recycle);
        rec.setAdapter(md);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
