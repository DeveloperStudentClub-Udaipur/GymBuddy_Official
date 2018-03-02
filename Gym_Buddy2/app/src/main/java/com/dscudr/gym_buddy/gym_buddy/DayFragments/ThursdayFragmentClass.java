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
public class ThursdayFragmentClass extends Fragment {

    Adapter md;
    int image_rec[] = {R.drawable.pushup, R.drawable.pullups, R.drawable.flat_bench_press, R.drawable.inclined_dumbell_press, R.drawable.decline_doumblle_press, R.drawable.doumbell_bench_fly, R.drawable.chestdips, R.drawable.dumbell_bent_arm_pullover, R.drawable.crunch};
    String name[];
    @BindView(R.id.recycle)
    RecyclerView recycle;
    Unbinder unbinder;

    public ThursdayFragmentClass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monday_fragment_class, container, false);
        unbinder = ButterKnife.bind(this, view);
        name = getResources().getStringArray(R.array.exercise_name_mon_thu);
        md = new Adapter(getActivity(), image_rec, name, "thursday");
        recycle.setAdapter(md);
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
