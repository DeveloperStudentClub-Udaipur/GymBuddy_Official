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
public class WednesdayFragmentClass extends Fragment {
    Adapter adapter;
    int image_rec[] = {R.drawable.latpulldown, R.drawable.seated_cable_row, R.drawable.close_grip_front_lat_pulldown, R.drawable.chin_ups, R.drawable.close_grip_bench_press, R.drawable.narrow_grip_push_up, R.drawable.barbell_sqates, R.drawable.front_barbell_squat_gif, R.drawable.calves_leg_press, R.drawable.sumo_squat_gif, R.drawable.squats_gif, R.drawable.crunch};
    String name[];
    @BindView(R.id.recycle)
    RecyclerView recycle;
    Unbinder unbinder;


    public WednesdayFragmentClass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wednesday_fragment_class, container, false);
        unbinder = ButterKnife.bind(this, view);
        name = getResources().getStringArray(R.array.exersice_name_wed_sat);
        adapter = new Adapter(getContext(), image_rec, name, "wednesday");
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
