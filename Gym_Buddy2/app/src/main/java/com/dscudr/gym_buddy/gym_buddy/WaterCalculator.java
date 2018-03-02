package com.dscudr.gym_buddy.gym_buddy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class WaterCalculator extends AppCompatActivity {

    TextView text;
    int water_required;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.info)
    TextView info;
    @BindView(R.id.hint)
    TextView hint;
    @BindView(R.id.input_weight)
    EditText inputWeight;
    @BindView(R.id.calculate)
    Button calculate;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.sw)
    Switch sw;
    @BindView(R.id.textView2)
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_calculator);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        SharedPreferences sharedPreferences = getSharedPreferences("reminder_settings", MODE_PRIVATE);
        sw = (Switch) findViewById(R.id.sw);
        calculate = (Button) findViewById(R.id.calculate);
        text = (TextView) findViewById(R.id.result);
        sharedPreferences = getSharedPreferences("reminder_settings", Context.MODE_PRIVATE);
        int ch = sharedPreferences.getInt("Notification", 0);
        if (ch == 1) {
            sw = (Switch) findViewById(R.id.sw);
            sw.setChecked(true);
        } else {
            sw = (Switch) findViewById(R.id.sw);
            sw.setChecked(false);
        }

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputWeight.getText().toString().isEmpty()) {
                    Toast.makeText(WaterCalculator.this, "Enter Weight", Toast.LENGTH_SHORT).show();

                } else {
                    water_required = Integer.parseInt(inputWeight.getText().toString()) * 35;
                    text.setText("You Should Drink " + water_required / 1000.0 + " lt. water per day.");
                }
            }
        });
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Toast.makeText(WaterCalculator.this, "function called", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setAction("com.dscudpr.gymbuddy");
                    intent.addCategory("android.intent.category.DEFAULT");
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterCalculator.this, 0, intent, 0);
                    alarmManager.setRepeating(alarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 3600, pendingIntent);
                    Toast.makeText(WaterCalculator.this, "Alarm set ", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("reminder_settings", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Notification", 1);
                    editor.commit();
                } else {
                    Intent intent = new Intent();
                    intent.setAction("com.dscudpr.gymbuddy");
                    intent.addCategory("android.intent.category.DEFAULT");
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterCalculator.this, 0, intent, 0);
                    alarmManager.cancel(pendingIntent);
                    Toast.makeText(WaterCalculator.this, "Alarm unset ", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("reminder_settings", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Notification", 0);
                    editor.commit();
                }
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
