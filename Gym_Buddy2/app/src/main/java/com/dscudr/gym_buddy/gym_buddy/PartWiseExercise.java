package com.dscudr.gym_buddy.gym_buddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.dscudr.gym_buddy.gym_buddy.adapter.Adapter;

public class PartWiseExercise extends AppCompatActivity {

    Adapter md;
    String[] name;
    String[] disc;
    int parts[] = {R.array.exersice_name_chest, R.array.exersice_name_biceps, R.array.exersice_name_back, R.array.exersice_name_triceps, R.array.exersice_name_legs, R.array.exersice_name_shoulder, R.array.exersice_name_abs};
    int chest[] = {R.drawable.pushup, R.drawable.pullups, R.drawable.flat_bench_press, R.drawable.inclined_dumbell_press, R.drawable.decline_doumblle_press, R.drawable.doumbell_bench_fly, R.drawable.chestdips};
    int biceps[] = {R.drawable.dumbell_curls, R.drawable.preachers_curls, R.drawable.cable_curls, R.drawable.concentration_curls};
    int back[] = {R.drawable.latpulldown, R.drawable.seated_cable_row, R.drawable.close_grip_front_lat_pulldown, R.drawable.chin_ups, R.drawable.close_grip_bench_press, R.drawable.narrow_grip_push_up};
    int triceps[] = {R.drawable.dumbell_bent_arm_pullover, R.drawable.triceps_extention_cable};
    int legs[] = {R.drawable.barbell_sqates, R.drawable.front_barbell_squat, R.drawable.calves_leg_press, R.drawable.sumo_squat, R.drawable.squats};
    int shoulder[] = {R.drawable.militry_press, R.drawable.dumbell_press, R.drawable.seated_militry_press, R.drawable.dumbell_lateral_raises, R.drawable.cable_front_raises};
    int abs[] = {R.drawable.crunch};
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle_part_wise)
    RecyclerView recyclePartWise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_wise_exercise);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = getResources().getStringArray(parts[id]);

        switch (id) {
            case 0:
                md = new Adapter(this, chest, name, "chest");
                getSupportActionBar().setTitle("Chest");
                break;
            case 1:
                md = new Adapter(this, biceps, name, "biceps");
                getSupportActionBar().setTitle("Biceps");
                break;
            case 2:
                md = new Adapter(this, back, name, "back");
                getSupportActionBar().setTitle("Back");
                break;
            case 3:
                md = new Adapter(this, triceps, name, "triceps");
                getSupportActionBar().setTitle("Triceps");
                break;
            case 4:
                md = new Adapter(this, legs, name, "legs");
                getSupportActionBar().setTitle("Legs");
                break;
            case 5:
                md = new Adapter(this, shoulder, name, "shoulder");
                getSupportActionBar().setTitle("Shoulder");
                break;
            case 6:
                md = new Adapter(this, abs, name, "abs");
                getSupportActionBar().setTitle("Abs");
                break;

        }

        recyclePartWise.setAdapter(md);
        int col=2;
        if(getResources().getBoolean(R.bool.ori))
        {
            col = 1;
        }
        else
        {
            col=2;
        }
        recyclePartWise.setLayoutManager(new GridLayoutManager(this,col));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
