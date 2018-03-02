package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PowerLifting extends Fragment
{

    String desc = "Powerlifting is a strength sport that consists of three attempts at maximal" +
            " weight on three lifts: squat, bench press, and deadlift. As in the sport of Olympic" +
            " weightlifting, it involves the athlete attempting a maximal weight single lift of a " +
            "barbell loaded with weight plates. Powerlifting evolved from a sport known as \"odd lifts\", " +
            "which followed the same three-attempt format but used a wider variety of events, akin to strongman" +
            " competition. Eventually odd lifts became standardized to the current three.";
    String ageclass = "15-18 Year (Sub-Junior)\n\n" +
            "19-23 Year (Junior)\n\n" +
            "Any age(Open)\n\n" +
            "40+(Masters)\n\n" +
            "70+(Grandmasters)\n";
    String man_w = "52 kg\n" +
            " 56 kg\n" +
            " 60 kg\n" +
            " 67 kg\n" +
            " 75 kg\n" +
            " 82 kg\n" +
            " 90 kg\n" +
            "100 kg\n" +
            "110 kg\n" +
            "125 kg\n" +
            "140 kg\n" +
            "140 kg+\n";
    String woman_w = "44 kg\n" +
            "48 kg\n" +
            "52 kg\n" +
            "56 kg\n" +
            "60 kg\n" +
            "67 kg\n" +
            "75 kg\n" +
            "82 kg\n" +
            "90 kg\n" +
            "90 kg+";

    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.age)
    TextView age;
    @BindView(R.id.man_weight)
    TextView manWeight;
    @BindView(R.id.woman_weight)
    TextView womanWeight;
    Unbinder unbinder;

    public PowerLifting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_power_lifting, container, false);
        unbinder = ButterKnife.bind(this, view);

        description.setText(desc);
        age.setText(ageclass);
        manWeight.setText(man_w);
        womanWeight.setText(woman_w);
        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }
}
