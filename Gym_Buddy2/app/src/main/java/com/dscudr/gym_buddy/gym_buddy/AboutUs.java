package com.dscudr.gym_buddy.gym_buddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUs extends AppCompatActivity {

    @BindView(R.id.facebook)
    ImageButton facebook;
    @BindView(R.id.call)
    ImageButton call;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.linearLayout)
    RelativeLayout linearLayout;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.linked_akshay)
    ImageView linkedAkshay;
    @BindView(R.id.fb_akshay)
    ImageView fbAkshay;
    @BindView(R.id.rec1)
    LinearLayout rec1;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.textView11)
    TextView textView11;
    @BindView(R.id.linked_mohit)
    ImageView linkedMohit;
    @BindView(R.id.fb_mohit)
    ImageView fbMohit;
    @BindView(R.id.rec2)
    LinearLayout rec2;
    @BindView(R.id.cont)
    LinearLayout cont;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.textView10)
    TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Us");

        facebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/DSCUDR.IN/"));
                startActivity(in);
            }
        });
        call.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:7665738184"));
                startActivity(in);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick({R.id.linked_akshay, R.id.fb_akshay, R.id.linked_mohit, R.id.fb_mohit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linked_akshay:
                Intent in1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/anandwana001/"));
                startActivity(in1);
                break;
            case R.id.fb_akshay:
                Intent in2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/anandwana001"));
                startActivity(in2);
                break;
            case R.id.linked_mohit:
                Intent in3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mohit-kumar-chug-a6bb4413a/"));
                startActivity(in3);
                break;
            case R.id.fb_mohit:
                Intent in4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mohit.chug.18"));
                startActivity(in4);
                break;
        }
    }
}

