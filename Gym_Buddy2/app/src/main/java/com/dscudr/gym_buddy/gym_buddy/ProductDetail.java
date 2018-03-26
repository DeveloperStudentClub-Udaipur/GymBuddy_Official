package com.dscudr.gym_buddy.gym_buddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetail extends AppCompatActivity {
    @BindView(R.id.tool)
    Toolbar tool;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.call_1)
    ImageButton call_1;
    @BindView(R.id.call_2)
    ImageButton call_2;
    @BindView(R.id.product)
    ImageView product;
    String name_p[];
    String des_p[];
    int img[] = {R.drawable.mt_01,R.drawable.mt_02,R.drawable.mt_03,R.drawable.mt_04,R.drawable.on_01,R.drawable.on_02,R.drawable.on_03,R.drawable.on_04,R.drawable.dm_01,R.drawable.dm_02,R.drawable.dm_03,R.drawable.dm_04,R.drawable.bm_01,R.drawable.bm_02,R.drawable.bm_03,R.drawable.bm_04,R.drawable.un_01,R.drawable.un_02,R.drawable.un_03,R.drawable.un_04};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        name_p = getResources().getStringArray(R.array.protien_name);
        des_p = getResources().getStringArray(R.array.protien_details);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        ButterKnife.bind(this);
        setSupportActionBar(tool);
        getSupportActionBar().setTitle("Product Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name.setText(name_p[id]);
        description.setText(des_p[id]);
        product.setImageResource(img[id]);

        call_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:9460801495"));
                startActivity(in);
            }
        });
        call_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:7737811786"));
                startActivity(in2);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
