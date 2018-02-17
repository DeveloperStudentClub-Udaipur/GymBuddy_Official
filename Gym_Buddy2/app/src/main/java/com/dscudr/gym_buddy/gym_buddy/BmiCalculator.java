package com.dscudr.gym_buddy.gym_buddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jackandphantom.circularprogressbar.CircleProgressbar;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
public class BmiCalculator extends AppCompatActivity {
    TextView BMI;
    EditText weight,feet,inch;
    Switch aSwitch1,aSwitch2;
    Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        aSwitch1 = (Switch)findViewById(R.id.switch1);
        aSwitch2 = (Switch)findViewById(R.id.switch2);
        weight = (EditText)findViewById(R.id.weight);
        feet = (EditText)findViewById(R.id.Feet);
        inch = (EditText)findViewById(R.id.Inch);
        cal = (Button)findViewById(R.id.Calculate);
        BMI = (TextView)findViewById(R.id.bmi);
        Toolbar tool = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true)
                {
                    weight.setHint("Weight in lbs");
                }
                else
                {
                    weight.setHint("Weight in Kg");
                }
            }
        });
        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==false)
                {
                    feet.setWidth(120);
                    inch.setVisibility(View.GONE);
                    feet.setHint("Height in Cm");
                }
                else
                {
                    feet.setWidth(60);
                    inch.setVisibility(View.VISIBLE);
                    feet.setHint("Feet");
                }

            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( weight.getText().toString().isEmpty() || feet.getText().toString().isEmpty())
                {
                    Toast.makeText(BmiCalculator.this,"Enter Data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(aSwitch1.isChecked())
                    {
                        String w = weight.getText().toString();
                        Double w_lbs = Double.parseDouble(w);
                        w_lbs = w_lbs*0.453;
                        if(aSwitch2.isChecked())
                        {
                            if(inch.getText().toString().isEmpty())
                            {
                                Toast.makeText(BmiCalculator.this,"Enter Data",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                String f = feet.getText().toString();
                                int f_feet = Integer.parseInt(f);
                                String i = inch.getText().toString();
                                int f_inch = Integer.parseInt(i);
                                Double h = (((f_feet * 12 + f_inch) * 2.5) / 100);
                                Double bmi = (w_lbs / (h * h));
                                BMI.setText("" + Math.round(bmi));
                                progress(bmi);
                            }

                        }
                        else
                        {
                            String f = feet.getText().toString();
                            double f_cm = Float.parseFloat(f);
                            Double h = f_cm/100;
                            double bmi = w_lbs/(h*h);
                            BMI.setText(""+Math.round(bmi));
                            progress(bmi);
                        }
                    }
                    else
                    {
                        String w = weight.getText().toString();
                        float w_kgs = Float.parseFloat(w);
                        if(aSwitch2.isChecked())
                        {
                            String f = feet.getText().toString();
                            int f_feet = Integer.parseInt(f);
                            String i = inch.getText().toString();
                            int f_inch = Integer.parseInt(i);
                            int h = f_feet*12+f_inch;
                            double h_new = h *0.0254;
                            double bmi = w_kgs/(h_new*h_new);

                            BMI.setText(""+Math.round(bmi));
                            progress(bmi);
                        }
                        else
                        {
                            String f = feet.getText().toString();
                            double f_cm = Float.parseFloat(f);
                            Double h = f_cm/100;
                            double bmi = w_kgs/(h*h);
                            BMI.setText(""+Math.round(bmi));
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
    public void progress(double bmi)
    {
        bmi = ((int) bmi);
        BMI = (TextView)findViewById(R.id.bmi);
        CircleProgressbar circleProgressbar = (CircleProgressbar)findViewById(R.id.yourCircularProgressbar);
        if(bmi<=18)
        {
            circleProgressbar.setForegroundProgressColor(Color.YELLOW);
        }
        else if(bmi<=24)
        {
            circleProgressbar.setForegroundProgressColor(Color.GREEN);
        }
        else if(bmi<=30)
        {
            circleProgressbar.setForegroundProgressColor(R.color.light_orange);
        }
        else
        {
            circleProgressbar.setForegroundProgressColor(Color.RED);
        }
        circleProgressbar.setBackgroundProgressWidth(30);
        circleProgressbar.setForegroundProgressWidth(30);
        circleProgressbar.enabledTouch(true);
        circleProgressbar.setRoundedCorner(true);
        circleProgressbar.setClockwise(false);
        int animationDuration = 1000; // 1000ms = 1s
        int pr;
        if(bmi<=32)
        {
            pr = (int) ((bmi/32)*100);
        }
        else
        {
            pr=100;
        }
        circleProgressbar.setProgressWithAnimation(pr, animationDuration);

    }

}
