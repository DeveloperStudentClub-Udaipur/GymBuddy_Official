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
public class BodyBuilding extends Fragment {

    String desc="1.\tBodybuilding is the use of progressive resistance exercise to control and develop one's musculature.\n\n" +
            "2.\tAn individual who engages in this activity is referred to as a bodybuilder. \n\n" +
            "3.\tIn professional bodybuilding, bodybuilders appear in lineups and perform specified poses (and later individual posing routines) for a panel of judges who rank the competitors based on criteria such as symmetry, muscularity, and conditioning.\n\n" +
            "4.\tBodybuilders prepare for competitions through a combination of intentional dehydration, elimination of nonessential body fat, and carbohydrate loading to achieve maximum vascularity, as well as tanning to accentuate muscular definition.\n\n";
    String junior_men = "Age:- 16 - 21 years\n" +
            "   a) Up to 75kg \n" +
            "   b) Over 75kg  \n";
    String senior_men="Age:- 21 - 40 years\n\n"+
            "   a) Up to 55kg\n" +
            "   b) Up to 60kg\n" +
            "   c) Up to 65kg\n" +
            "   d) Up to 70kg\n" +
            "   e) Up to 75kg\n" +
            "   f) Up to 80kg\n" +
            "   g) Up to 85kg\n" +
            "   h) Up to 90kg\n" +
            "   I) Up to 100kg\n" +
            "   j) Over 100kg\n";
    String Master_men="Age:- 40 + Years\n\n"+
            "40 – 49 years old:\n" +
            "   a) Up to 70kg \n" +
            "   b) Up to 80kg \n" +
            "   c) Up to 90kg \n" +
            "   d) Over 90kg \n\n" +
            "50 to 60 years:\n" +
            "   a) Up to 80kg\n" +
            "   b) Over 80kg\n\n"+
            "Over 60 years: one open category ";
    String women_string= "Junior Women´s Bodybuilding: one open category \n\n\n" +
            "Senior Women´s Bodybuilding: \n" +
            "   a) Up to 50kg \n" +
            "   b) Over 50kg  \n\n" +
            "Master Women´s Bodybuilding: one open category  \n";
    public BodyBuilding()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_body_building, container, false);
        TextView textView=(TextView)view.findViewById(R.id.description);
        textView.setText(desc);
        TextView junior=(TextView)view.findViewById(R.id.junior_men);
        junior.setText(junior_men);
        TextView senior=(TextView)view.findViewById(R.id.senior_men);
        senior.setText(senior_men);
        TextView master=(TextView)view.findViewById(R.id.master_men);
        master.setText(Master_men);
        TextView women=(TextView)view.findViewById(R.id.women);
        women.setText(women_string);


        return view;
    }

}
