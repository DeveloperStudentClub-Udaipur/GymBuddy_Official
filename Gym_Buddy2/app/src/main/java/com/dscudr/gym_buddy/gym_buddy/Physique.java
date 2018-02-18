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
public class Physique extends Fragment {

    String desc="Beginning this season, the new Muscle mania Physique Division joins " +
            "the Muscle mania World Tour. This new division is for men who want to display" +
            " their upper bodies in a classic, symmetry, beach body form. Competitors wear " +
            "tradition knee high board shorts while presenting themselves on stage in both individual" +
            " walk and class line-ups. They will be judged based equally upon their Physical Upper Body" +
            " Symmetry, Size, Muscle Condition and Presentation. The will be two height divisions determined after check-in at the show.";
    String classes = "senior men’s physique\n\n" +
            "Class A: Up to 170 cm \n" +
            "Class B: Up to 173 cm\n" +
            "Class C: Up to 176 cm \n" +
            "Class D: Up to 179 cm \n" +
            "Class E: Up to 182 cm \n" +
            "Class F: Over 82 cm \n\n\n\n" +
            "junior men’s physique\n\n" +
            "Class A: Up to 174 cm\n" +
            "Class B: Up 178 cm \n" +
            "Class C: Over 178 cm  \n\n\n\n" +
            "Masters Men’s Physique\n\n" +
            "Class A: Age 40-44 Year \n" +
            "Class B: Age 45-49 Year \n" +
            "Class C: Age 50 and over Year\n\n\n\n" +
            "Women´s Physique:\n\n" +
            " a) Up to 155cm\n" +
            " b) Over 155cm \n";
    public Physique() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_physique, container, false);
        TextView textView = (TextView)view.findViewById(R.id.description);
        textView.setText(desc);

        TextView classe = (TextView)view.findViewById(R.id.classes);
        classe.setText(classes);
        return  view;

    }

}
