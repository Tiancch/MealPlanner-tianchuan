package com.example.henilsarang.mealplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MealDetailActivity extends AppCompatActivity {

    TextView mTitle;
    ImageView mImageView;
    TextView mDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = (TextView) findViewById(R.id.tvDetailTitle);
        mImageView = (ImageView) findViewById(R.id.detailImage);
        mDescription = (TextView) findViewById(R.id.tvDescription) ;

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mTitle.setText(mBundle.getString("title"));
            mImageView.setImageResource(mBundle.getInt("image"));
            mDescription.setText(mBundle.getString("description"));
        }
    }
}

