package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartWise extends Fragment {

    RecyclerView rec;
    AdapterPartWise md;
    int image_rec[] = {R.drawable.chest,R.drawable.biceps,R.drawable.back,R.drawable.triceps,R.drawable.legs,R.drawable.shoulder,R.drawable.abs};
    public BodyPartWise() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_part_wise, container, false);
        md = new AdapterPartWise(getActivity(),image_rec);
        rec = (RecyclerView)view.findViewById(R.id.recycle);
        rec.setAdapter(md);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
