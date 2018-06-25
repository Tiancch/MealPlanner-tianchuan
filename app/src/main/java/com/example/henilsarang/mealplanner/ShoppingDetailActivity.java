package com.example.henilsarang.mealplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoppingDetailActivity extends AppCompatActivity {


    TextView mTitle;
    ImageView mImageView;
    TextView mDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_detail);

        mTitle = (TextView) findViewById(R.id.tvShoppingDetailTitle);
        mImageView = (ImageView) findViewById(R.id.ShoppingDetailImage);
        mDescription = (TextView) findViewById(R.id.tvShoppingDescription) ;

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mTitle.setText(mBundle.getString("title"));
            mImageView.setImageResource(mBundle.getInt("image"));
            mDescription.setText(mBundle.getString("description"));
        }
    }
}
