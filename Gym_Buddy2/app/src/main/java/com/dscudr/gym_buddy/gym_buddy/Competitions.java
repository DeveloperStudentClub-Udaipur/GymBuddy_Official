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
public class Competitions extends Fragment {

    RecyclerView rec;
    Adapter md;
    int image_rec[] = {};
    String name[];

    public Competitions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compititions, container, false);
        name=getResources().getStringArray(R.array.exercise_name_mon_thu);
        md = new Adapter(getActivity(),image_rec,name,"monday");
        rec = (RecyclerView)view.findViewById(R.id.recycle);
        rec.setAdapter(md);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
