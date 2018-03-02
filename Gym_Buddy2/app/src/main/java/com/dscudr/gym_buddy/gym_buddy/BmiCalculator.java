package com.dscudr.gym_buddy.gym_buddy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.jackandphantom.circularprogressbar.CircleProgressbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BmiCalculator extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.yourCircularProgressbar)
    CircleProgressbar yourCircularProgressbar;
    @BindView(R.id.bmi)
    TextView Bmi;
    @BindView(R.id.switch1)
    Switch switch1;
    @BindView(R.id.switch2)
    Switch switch2;
    @BindView(R.id.weight)
    EditText weight;
    @BindView(R.id.Feet)
    EditText Feet;
    @BindView(R.id.Inch)
    EditText Inch;
    @BindView(R.id.Calculate)
    Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    weight.setHint("Weight in lbs");
                } else {
                    weight.setHint("Weight in Kg");
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == false) {
                    Feet.setWidth(120);
                    Inch.setVisibility(View.GONE);
                    Feet.setHint("Height in Cm");
                } else {
                    Feet.setWidth(60);
                    Inch.setVisibility(View.VISIBLE);
                    Feet.setHint("Feet");
                }

            }
        });
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (weight.getText().toString().isEmpty() || Feet.getText().toString().isEmpty()) {
                    Toast.makeText(BmiCalculator.this, "Enter Data", Toast.LENGTH_SHORT).show();
                } else {
                    if (switch1.isChecked()) {
                        String w = weight.getText().toString();
                        Double w_lbs = Double.parseDouble(w);
                        w_lbs = w_lbs * 0.453;
                        if (switch2.isChecked()) {
                            if (Inch.getText().toString().isEmpty()) {
                                Toast.makeText(BmiCalculator.this, "Enter Data", Toast.LENGTH_SHORT).show();
                            } else {
                                String f = Feet.getText().toString();
                                int f_feet = Integer.parseInt(f);
                                String i = Inch.getText().toString();
                                int f_inch = Integer.parseInt(i);
                                Double h = (((f_feet * 12 + f_inch) * 2.5) / 100);
                                Double bmi = (w_lbs / (h * h));
                                Bmi.setText("" + Math.round(bmi));
                                progress(bmi);
                            }

                        } else {
                            String f = Feet.getText().toString();
                            double f_cm = Float.parseFloat(f);
                            Double h = f_cm / 100;
                            double bmi = w_lbs / (h * h);
                            Bmi.setText("" + Math.round(bmi));
                            progress(bmi);
                        }
                    } else {
                        String w = weight.getText().toString();
                        float w_kgs = Float.parseFloat(w);
                        if (switch2.isChecked()) {
                            String f = Feet.getText().toString();
                            int f_feet = Integer.parseInt(f);
                            String i = Inch.getText().toString();
                            int f_inch = Integer.parseInt(i);
                            int h = f_feet * 12 + f_inch;
                            double h_new = h * 0.0254;
                            double bmi = w_kgs / (h_new * h_new);

                            Bmi.setText("" + Math.round(bmi));
                            progress(bmi);
                        } else {
                            String f = Feet.getText().toString();
                            double f_cm = Float.parseFloat(f);
                            Double h = f_cm / 100;
                            double bmi = w_kgs / (h * h);
                            Bmi.setText("" + Math.round(bmi));
                            progress(bmi);
                        }

                    }
                }

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void progress(double bmi) {
        bmi = ((int) bmi);
        if (bmi <= 18) {
            yourCircularProgressbar.setForegroundProgressColor(Color.YELLOW);
        } else if (bmi <= 24) {
            yourCircularProgressbar.setForegroundProgressColor(Color.GREEN);
        } else if (bmi <= 30) {
            yourCircularProgressbar.setForegroundProgressColor(R.color.light_orange);
        } else {
            yourCircularProgressbar.setForegroundProgressColor(Color.RED);
        }
        yourCircularProgressbar.setBackgroundProgressWidth(30);
        yourCircularProgressbar.setForegroundProgressWidth(30);
        yourCircularProgressbar.enabledTouch(true);
        yourCircularProgressbar.setRoundedCorner(true);
        yourCircularProgressbar.setClockwise(false);
        int animationDuration = 1000; // 1000ms = 1s
        int pr;
        if (bmi <= 32) {
            pr = (int) ((bmi / 32) * 100);
        } else {
            pr = 100;
        }
        yourCircularProgressbar.setProgressWithAnimation(pr, animationDuration);

    }

}
