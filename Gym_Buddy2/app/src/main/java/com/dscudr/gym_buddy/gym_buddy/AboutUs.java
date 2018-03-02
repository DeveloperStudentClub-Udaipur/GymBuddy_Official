package com.dscudr.gym_buddy.gym_buddy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

public class AboutUs extends AppCompatActivity {

    ImageButton facebook;
    TextView Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        facebook = (ImageButton)findViewById(R.id.facebook);
        Phone = (TextView)findViewById(R.id.Phone);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/DSCUDR.IN/"));
                startActivity(in);
            }
        });
        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:7665738184"));
                startActivity(in);
            }
        });
    }

}
