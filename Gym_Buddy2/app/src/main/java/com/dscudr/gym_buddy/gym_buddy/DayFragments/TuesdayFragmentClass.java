package com.dscudr.gym_buddy.gym_buddy.DayFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dscudr.gym_buddy.gym_buddy.adapter.Adapter;
import com.dscudr.gym_buddy.gym_buddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class TuesdayFragmentClass extends Fragment {

    Adapter adapter;
    int image_rec[] = {R.drawable.dumbell_curls, R.drawable.preachers_curls, R.drawable.cable_curls, R.drawable.concentration_curls, R.drawable.triceps_extention_curls, R.drawable.triceps_extention_cable, R.drawable.militry_press, R.drawable.dumbell_press, R.drawable.seated_militry_press, R.drawable.dumbell_lateral_raises, R.drawable.cable_front_raises, R.drawable.up_right_rows, R.drawable.crunch};
    String name[];
    @BindView(R.id.recycle)
    RecyclerView recycle;
    Unbinder unbinder;

    public TuesdayFragmentClass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tuesday_fragment_class, container, false);
        unbinder = ButterKnife.bind(this, view);
        name = getResources().getStringArray(R.array.exercise_name_tue_fri);
        adapter = new Adapter(getContext(), image_rec, name, "tuesday");
        recycle.setAdapter(adapter);
        int col;
        if(getResources().getBoolean(R.bool.ori))
        {
            col = 1;
        }
        else
        {
            col=2;
        }
        recycle.setLayoutManager(new GridLayoutManager(getActivity(),col));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
