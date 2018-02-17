package com.dscudr.gym_buddy.gym_buddy.diet_types_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dscudr.gym_buddy.gym_buddy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VegFragment extends Fragment {


    public VegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_veg, container, false);
    }

}
