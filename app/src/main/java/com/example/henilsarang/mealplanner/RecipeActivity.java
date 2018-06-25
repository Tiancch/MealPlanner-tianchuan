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
    String[] titles = {"Cauliflower Tikka Masala","No-Pain Lo Mein","One-Pot Farfalle Primavera","One-Pot Spaghetti with Fresh Tomato Sauce","Pan Roasted Pork Chops and Broccoli","Pea and Goat's Cheese Risotto"};
    String[] descriptions = {"4.6/5 Enticing, Appealing, Finger Licking!", "4.2/5 Enjoyable", "3.8/5 Marvelous","4.0/5 Best in Calgary","4.3/5 Delicious","4.7/5 Fantastic Savory"};
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
                Intent myIntent = new Intent(RecipeActivity.this, TabActivity.class);
                myIntent.putExtra("title", titles[i]);
                myIntent.putExtra("image", images[i]);
                myIntent.putExtra("description", descriptions[i]);
                startActivity(myIntent);
            }
        });

    }

    }


