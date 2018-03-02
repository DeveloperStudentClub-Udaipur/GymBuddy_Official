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
public class Physique extends Fragment {

    String desc = "Beginning this season, the new Muscle mania Physique Division joins " +
            "the Muscle mania World Tour. This new division is for men who want to display" +
            " their upper bodies in a classic, symmetry, beach body form. Competitors wear " +
            "tradition knee high board shorts while presenting themselves on stage in both individual" +
            " walk and class line-ups. They will be judged based equally upon their Physical Upper Body" +
            " Symmetry, Size, Muscle Condition and Presentation. The will be two height divisions determined after check-in at the show.";
    String classe_1 = "Class A: Up to 170 cm \n" +
            "Class B: Up to 173 cm\n" +
            "Class C: Up to 176 cm \n" +
            "Class D: Up to 179 cm \n" +
            "Class E: Up to 182 cm \n" +
            "Class F: Over 82 cm \n\n";

    String classe_2 =
            "Class A: Up to 174 cm\n" +
            "Class B: Up 178 cm \n" +
            "Class C: Over 178 cm  \n\n";

    String classe_3 = "Class A: Age 40-44 Year \n" +
            "Class B: Age 45-49 Year \n" +
            "Class C: Age 50 and over Year\n\n";
    String classe_4 =
            " a) Up to 155cm\n" +
            " b) Over 155cm \n\n";
    @BindView(R.id.gif)
    GifImageView gif;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.classes_1)
    TextView classes_1;
    @BindView(R.id.classes_2)
    TextView classes_2;
    @BindView(R.id.classes_3)
    TextView classes_3;
    @BindView(R.id.classes_4)
    TextView classes_4;

    Unbinder unbinder;

    public Physique() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_physique, container, false);
        unbinder = ButterKnife.bind(this, view);
        description.setText(desc);
        classes_1.setText(classe_1);
        classes_2.setText(classe_2);
        classes_3.setText(classe_3);
        classes_4.setText(classe_4);

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
