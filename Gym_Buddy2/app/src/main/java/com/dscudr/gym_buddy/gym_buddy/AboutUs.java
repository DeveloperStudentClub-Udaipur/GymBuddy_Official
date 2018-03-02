package com.dscudr.gym_buddy.gym_buddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutUs extends AppCompatActivity {

    @BindView(R.id.facebook)
    ImageButton facebook;
    @BindView(R.id.call)
    ImageButton call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);

        facebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/DSCUDR.IN/"));
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
}
