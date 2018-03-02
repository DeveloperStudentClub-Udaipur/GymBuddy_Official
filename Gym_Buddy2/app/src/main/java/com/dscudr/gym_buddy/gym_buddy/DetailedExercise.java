package com.dscudr.gym_buddy.gym_buddy;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

public class DetailedExercise extends AppCompatActivity {

    int wednesday[] = {R.drawable.latpulldown_gif, R.drawable.seated_cable_row_gif, R.drawable.close_grip_front_lat_pulldown_gif, R.drawable.chin_ups_gif, R.drawable.close_grip_bench_press_gif, R.drawable.narrow_grip_push_up_gif, R.drawable.barbell_sqates_gif, R.drawable.front_barbell_squat_gif, R.drawable.calves_leg_press_gif, R.drawable.sumo_squat_gif, R.drawable.squats_gif, R.drawable.crunch_gif};
    int monday[] = {R.drawable.pushup_gif, R.drawable.pullups_gif, R.drawable.flat_bench_press_gif, R.drawable.inclined_dumbell_press_gif, R.drawable.decline_doumblle_press_gif, R.drawable.doumbell_bench_fly_gif, R.drawable.chest_dips_gif, R.drawable.dumbell_bent_arm_pullover_gif, R.drawable.crunch_gif};
    int tuesday[] = {R.drawable.dumbell_curls_gif, R.drawable.preachers_curls_gif, R.drawable.cable_curls_gif, R.drawable.concentration_curls_gif, R.drawable.triceps_extention_curls_gif, R.drawable.triceps_extention_cable_gif, R.drawable.militry_press_gif, R.drawable.dumbell_press_gif, R.drawable.seated_militry_press_gif, R.drawable.dumbell_lateral_raises_gif, R.drawable.cable_front_raises_gif, R.drawable.up_right_rows_gif, R.drawable.crunch_gif};
    int abs[] = {R.drawable.crunch_gif};
    int back[] = {R.drawable.latpulldown_gif, R.drawable.seated_cable_row_gif, R.drawable.close_grip_front_lat_pulldown, R.drawable.chin_ups_gif, R.drawable.close_grip_bench_press_gif, R.drawable.narrow_grip_push_up_gif};
    int chest[] = {R.drawable.pushup_gif, R.drawable.pullups_gif, R.drawable.flat_bench_press_gif, R.drawable.inclined_dumbell_press_gif, R.drawable.decline_doumblle_press_gif, R.drawable.doumbell_bench_fly_gif, R.drawable.chest_dips_gif};
    int biceps[] = {R.drawable.dumbell_curls_gif, R.drawable.preachers_curls_gif, R.drawable.cable_curls_gif, R.drawable.concentration_curls_gif};
    int triceps[] = {R.drawable.dumbell_bent_arm_pullover_gif, R.drawable.triceps_extention_cable_gif};
    int shoulders[] = {R.drawable.militry_press_gif, R.drawable.dumbell_press_gif, R.drawable.seated_militry_press_gif, R.drawable.dumbell_lateral_raises_gif, R.drawable.cable_front_raises_gif, R.drawable.up_right_rows_gif};
    int legs[] = {R.drawable.barbell_sqates_gif, R.drawable.front_barbell_squat_gif, R.drawable.calves_leg_press_gif, R.drawable.sumo_squat_gif, R.drawable.squats_gif};


    String disc[];
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.gif)
    GifImageView gif;
    @BindView(R.id.discription)
    TextView discription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_exercise);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = (TextView) findViewById(R.id.name);

        GifImageView gifImageView = (GifImageView) findViewById(R.id.gif);
        Bundle bundle = getIntent().getExtras();
        String name = (String) bundle.get("name");
        String cur = (String) bundle.get("cur_tab");
        int pos = bundle.getInt("position");
        getSupportActionBar().setTitle(name);
        if (cur.equals("wednesday") || cur.equals("saturday")) {
            disc = getResources().getStringArray(R.array.exersice_details_wed_sat);
            discription.setText(disc[pos]);
            gifImageView.setImageResource(wednesday[pos]);
            textView.setText(name);


        }
        if (cur.equals("monday") || cur.equals("thursday")) {
            gifImageView.setImageResource(monday[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_mon_thu);
            discription.setText(disc[pos]);

        }
        if (cur.equals("tuesday") || cur.equals("friday")) {
            gifImageView.setImageResource(tuesday[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_tue_fri);
            discription.setText(disc[pos]);

        }
        if (cur.equals("abs")) {
            gifImageView.setImageResource(abs[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_abs);
            discription.setText(disc[pos]);

        }
        if (cur.equals("triceps")) {
            gifImageView.setImageResource(triceps[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_triceps);
            discription.setText(disc[pos]);

        }

        if (cur.equals("shoulder")) {
            gifImageView.setImageResource(shoulders[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_shoulder);
            discription.setText(disc[pos]);

        }

        if (cur.equals("legs")) {
            gifImageView.setImageResource(legs[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_legs);
            discription.setText(disc[pos]);

        }

        if (cur.equals("back")) {
            gifImageView.setImageResource(back[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_back);
            discription.setText(disc[pos]);

        }

        if (cur.equals("chest")) {
            gifImageView.setImageResource(chest[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_chest);
            discription.setText(disc[pos]);

        }
        if (cur.equals("biceps")) {
            gifImageView.setImageResource(biceps[pos]);
            textView.setText(name);
            disc = getResources().getStringArray(R.array.exersice_details_biceps);
            discription.setText(disc[pos]);

        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
