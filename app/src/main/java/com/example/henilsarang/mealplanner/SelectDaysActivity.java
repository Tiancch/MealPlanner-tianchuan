package com.example.henilsarang.mealplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectDaysActivity extends AppCompatActivity {

    TextView tvDate;
    private CalendarView calendarView;
    ImageView imageView;
    Button btnSelectDays;
    Button btnShoppingList;
    Button btnSave;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_days);

        final ArrayList<String> dateList = new ArrayList<>();

        tvDate = (TextView) findViewById(R.id.tvDate);

        btnSelectDays = (Button) findViewById(R.id.btnSelectDays);
        btnShoppingList = (Button) findViewById(R.id.btnShoppingList);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnSelectDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//               if (v.getId()  == R.id.btnSelectDays) {
                Intent intent = new Intent(SelectDaysActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });


        btnShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SelectDaysActivity.this, ShoppingListActivity.class);
                startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent comingIntent = getIntent();
                String date = comingIntent.getStringExtra("date");


                Log.i("TC", "Date Value is :" + date);
                dateList.add(date);

                tvDate.setText(dateList.toString());

                Log.i("TC", "DateList = " + dateList.toString());
                return;
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                return;
            }
        });

    }
}