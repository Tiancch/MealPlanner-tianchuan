package com.example.henilsarang.mealplanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    ListView recipes;
    String[] titles = {"aa", "bb", "cc","dd","ee","ff"};
    String[] descriptions = {"aa11", "bb22", "cc33","dd44","ee55","ff66"};
    int[] images = {R.drawable.cauliflower_tikka_masala, R.drawable.nopailomein, R.drawable.onepotfarfalleprimavera, R.drawable.onepotspaghettiwithfreshtomatosauce, R.drawable.panroastedporkchopsandbroccoli, R.drawable.peaandgoatscheeserisotto};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        recipes = (ListView) findViewById(R.id.lvRecipes);

//        Resources r = getResources();
//        titles = r.getStringArray(R.array.recipeTitles);
//        descriptions = r.getStringArray(R.array.recipeDescriptions);

        MyAdapter adapter = new MyAdapter(RecipeActivity.this, titles, images, descriptions);
        recipes.setAdapter(adapter);

        recipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent myIntent = new Intent(RecipeActivity.this, MealDetailActivity.class);
                myIntent.putExtra("title", titles[i]);
                myIntent.putExtra("image", images[i]);
                myIntent.putExtra("description", descriptions[i]);
                startActivity(myIntent);
            }
        });

    }

    }


