package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeightLifting extends Fragment {

    String desc = "1.\tWeightlifting, also called Olympic-style weightlifting, or Olympic weightlifting, is an athletic discipline in the modern Olympic programme in which the athlete attempts a maximum-weight single lift of a barbell loaded with weight plates.\n\n" +
            "2.\tThe two competition lifts in order are the snatch and the clean and jerk. \n\n" +
            "3.\tEach weightlifter receives three attempts in each, and the combined total of the highest two successful lifts determines the overall result within a bodyweight category.\n\n" +
            "4.\tBodyweight categories are different for male and female competitors.\n\n" +
            "5.\tA lifter who fails to complete at least one successful snatch and one successful clean and jerk also fails to total, and therefore receives an \"incomplete\" entry for the competition. \n\n" +
            "6.\tThe clean and press was once a competition lift, but was discontinued due to difficulties in judging proper form.\n\n\n"+
            "\tIn the sport of weightlifting the IWF recognizes two lifts which must be executed in the following sequence:\n\n"+
            "\ta) The Snatch\n"+
            "\tb) The Clean and Jerk.\n";
    String man_w="Men's weight classes:\n\n" +
            "56 kg (123 lb)\n" +
            "62 kg (137 lb)\n" +
            "69 kg (152 lb)\n" +
            "77 kg (170 lb)\n" +
            "85 kg (187 lb)\n" +
            "94 kg (207 lb)\n" +
            "105 kg (231 lb)\n" +
            "105 kg and over (231 lb+)\n";

    String women_w="Women's weight classes:\n\n"+
            "48 kg (106 lb)\n"+
            "53 kg (117 lb)\n" +
            "58 kg (128 lb)\n" +
            "63 kg (139 lb)\n" +
            "69 kg (152 lb)\n" +
            "75 kg (165 lb)\n" +
            "90 kg (198 lb)\n" +
            "90 kg and over (198 lb+)\n";
    public WeightLifting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight_lifting, container, false);
        TextView textView = (TextView)view.findViewById(R.id.description);
        textView.setText(desc);
        TextView man_weight = (TextView)view.findViewById(R.id.man_weight);
        man_weight.setText(man_w);
        TextView women_weight = (TextView)view.findViewById(R.id.women_weight);
        women_weight.setText(women_w);

        return view;
    }

}
