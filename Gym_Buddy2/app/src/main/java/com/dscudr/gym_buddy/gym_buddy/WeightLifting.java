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
public class WeightLifting extends Fragment {

    String desc = "1.\tWeightlifting, also called Olympic-style weightlifting, or Olympic weightlifting, is an athletic discipline in the modern Olympic programme in which the athlete attempts a maximum-weight single lift of a barbell loaded with weight plates.\n\n" +
            "2.\tThe two competition lifts in order are the snatch and the clean and jerk. \n\n" +
            "3.\tEach weightlifter receives three attempts in each, and the combined total of the highest two successful lifts determines the overall result within a bodyweight category.\n\n" +
            "4.\tBodyweight categories are different for male and female competitors.\n\n" +
            "5.\tA lifter who fails to complete at least one successful snatch and one successful clean and jerk also fails to total, and therefore receives an \"incomplete\" entry for the competition. \n\n" +
            "6.\tThe clean and press was once a competition lift, but was discontinued due to difficulties in judging proper form.\n\n\n" +
            "\tIn the sport of weightlifting the IWF recognizes two lifts which must be executed in the following sequence:\n\n" +
            "\ta) The Snatch\n" +
            "\tb) The Clean and Jerk.\n";
    String man_w =
            " 56 kg \n" +
            " 62 kg \n" +
            " 69 kg \n" +
            " 77 kg \n" +
            " 85 kg \n" +
            " 94 kg \n" +
            "105 kg \n" +
            "105 kg +\n";

    String women_w =
            " 48 kg \n" +
            " 53 kg \n" +
            " 58 kg \n" +
            " 63 kg \n" +
            " 69 kg \n" +
            " 75 kg \n" +
            " 90 kg \n" +
            " 90 kg +\n";
    @BindView(R.id.gif)
    GifImageView gif;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.man_weight)
    TextView manWeight;
    @BindView(R.id.women_weight)
    TextView womenWeight;
    Unbinder unbinder;


    public WeightLifting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight_lifting, container, false);
        unbinder = ButterKnife.bind(this, view);
        description.setText(desc);
        manWeight.setText(man_w);
        womenWeight.setText(women_w);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
