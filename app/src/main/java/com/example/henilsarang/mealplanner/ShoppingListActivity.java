package com.example.henilsarang.mealplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShoppingListActivity extends AppCompatActivity {

    ListView mListView;
    String[] titles = {"Sour Cream","Vegetable Oil","Garlic Cloves","Baby Potatoes","Spaghetti","Tomato Paste"};
//    int[] images = {R.drawable.sour_cream, R.drawable.vegetable_oil,R.drawable.garlic_cloves,R.drawable.baby_potatoes,R.drawable.spaghetti,R.drawable.tomato_paste};
    int[] images = {R.drawable.sour_cream, R.drawable.vegetable_oil,R.drawable.garlic_cloves,R.drawable.baby_potatoes,R.drawable.spaghetti,R.drawable.tomato_paste};
    String[] descriptions = {"2 cups", "4 Tbsp", "1 lb","12 oz","20 oz","3 table spoon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.shopping_list);

            mListView = (ListView) findViewById(R.id.lvShoppingList);


            MyAdapter myAdapter = new MyAdapter(ShoppingListActivity.this, titles, images, descriptions);
            mListView.setAdapter(myAdapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    Intent mIntent = new Intent(ShoppingListActivity.this, ShoppingDetailActivity.class);

                    mIntent.putExtra("title", titles[i]);
                    mIntent.putExtra("image", images[i]);
                    mIntent.putExtra("description", descriptions[i]);
                    startActivity(mIntent);
                }
            });

        }
    }
