package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.activeandroid.util.Log;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class tabscreen extends AppCompatActivity{

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;
    private TabItem world, business, technology, science, sports;
    public PagerAdapter pagerAdapter;
    private int tabNumber = -1;
    private String tabSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabscreen);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        world = (TabItem) findViewById(R.id.world_tab);
        business = (TabItem) findViewById(R.id.business_tab);
        technology = (TabItem) findViewById(R.id.technology_tab);
        science = (TabItem) findViewById(R.id.science_tab);
        sports = (TabItem) findViewById(R.id.sports_tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabSelected = tab.getText().toString();
                Log.e("test2", tabSelected);
                //tabNumber = tab.getPosition()+1;
                viewPager.setCurrentItem(tab.getPosition());
                Log.e("test3", viewPager.toString());
                switch(tab.getPosition())
                {
                    case 0:
                        pagerAdapter.notifyDataSetChanged();

                    case 1:
                        pagerAdapter.notifyDataSetChanged();

                    case 2:
                        pagerAdapter.notifyDataSetChanged();

                    case 3:
                        pagerAdapter.notifyDataSetChanged();

                    case 4:
                        pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                View menuItemView = findViewById(R.id.action_settings);
                PopupMenu popup = new PopupMenu(this, menuItemView);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_main, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                     @Override
                     public boolean onMenuItemClick(MenuItem item) {
                         // Implemented in a switch case for scalability
                         switch(item.getItemId()) {
                             case R.id.action_settings:
                                 Toast.makeText(tabscreen.this, "Add post Clicked", Toast.LENGTH_SHORT);
                                 Intent intent = new Intent(tabscreen.this,Panel.class);
                                 //intent.putExtra("tabNumber", tabNumber);
                                 intent.putExtra("TabSelected", tabSelected);
                                 startActivity(intent);
                                 //startActivity(new Intent(tabscreen.this, Panel.class));
                                 return true;
                             default: return false;
                         }
                     }
                });

                //startActivity(new Intent(this, Panel.class));
                return true;
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    /*
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // Implemented in a switch case for scalability
        switch(item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Add post Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Panel.class));
                return true;
            default: return false;
        }
    }

     */
}


