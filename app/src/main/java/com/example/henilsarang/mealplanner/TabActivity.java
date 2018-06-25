package com.example.henilsarang.mealplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TabActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the two
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TabActivity.this, SelectDaysActivity.class);
                startActivity(intent);
                Snackbar.make(view, "Go to another action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.account_settings) {

            Intent intent = new Intent(TabActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.preference_settings){

            // setting preference such as veg or non-veg

        } else if (id == R.id.logout_setting){

            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            ListView listView = (ListView) rootView.findViewById(R.id._dynamic);

            int tabCount = 0;
            tabCount = getArguments().getInt(ARG_SECTION_NUMBER);

            textView.setText(getString(R.string.section_format, tabCount));

            String[] ingredients = {"½ cup sour cream", "2 Tbsp vegetable oil", "1 Tbsp mild or hot curry powder", "1 ½ tsp sweet paprika #Kosher salt"};
            String[] instructions = {"1. Whisk together 2 tablespoons of the sour cream, 1 tablespoon of the oil",
                    "2. Meanwhile, pulse the garlic, ginger, onion and 2 tablespoons water in a food processor until smooth",
                    "3. Heat the remaining 1 tablespoon vegetable oil in a 6-quart Dutch oven or large heavy pot over medium-high heat",
                    "4 Add the onion mixture, garam masala, the remaining 2 1/2 teaspoons curry powder, and the remaining 1 teaspoon paprika.",
                    "5 Cook, stirring occasionally, until the mixture starts to stick and brown on the bottom of the pan, about 4 minutes.",
                    "6 Add the tomato puree, 1 cup water, the chickpeas and 2 teaspoons salt."};
            //Build Adapter
            String[] listContent;

           // Log.i("TC","tabCount: " + String.valueOf(tabCount));

            if (tabCount == 1) {
                listContent = ingredients;
            }
                else {
                listContent = instructions;
            }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        getContext(), R.layout.data_item, listContent);


            //Configure the list view.

            listView.setAdapter(adapter);

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override

        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }
}
