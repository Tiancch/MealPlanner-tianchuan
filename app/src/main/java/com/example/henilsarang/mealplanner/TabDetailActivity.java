package com.example.henilsarang.mealplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class TabDetailActivity extends AppCompatActivity {

    ImageView mImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_detail);

        mImageView = (ImageView) findViewById(R.id.imageView2);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
           mImageView.setImageResource(mBundle.getInt("images"));
        }
    }
}
