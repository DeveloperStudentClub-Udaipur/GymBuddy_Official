package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.dscudr.gym_buddy.gym_buddy.adapter.AdapterPartWise;


/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartWise extends Fragment {

    AdapterPartWise md;
    int image_rec[] = {R.drawable.chest, R.drawable.biceps, R.drawable.back, R.drawable.triceps, R.drawable.legs, R.drawable.shoulder, R.drawable.abs};
    @BindView(R.id.recycle)
    RecyclerView recycle;
    Unbinder unbinder;

    public BodyPartWise() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_body_part_wise, container, false);
        unbinder = ButterKnife.bind(this, view);
        md = new AdapterPartWise(getActivity(), image_rec);
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
