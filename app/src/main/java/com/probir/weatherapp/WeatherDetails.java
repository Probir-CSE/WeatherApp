package com.probir.weatherapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.ViewParent;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WeatherDetails extends AppCompatActivity {

    List<PhotoConstractor> ListPhoto;
    List<PhotoConstractor> ListNews;

//    private TabLayout tablayout;
//    private ViewPager viewpager;
//    private TabItem tab1, tab2, tab3;
//    public PageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_weather_details);

        //-----------------TabLayout----------

//        tablayout = findViewById(R.id.tabLayout);
//        tab1 = findViewById(R.id.tab_weather);
//        tab2 = findViewById(R.id.tab_news);
//        tab3 = findViewById(R.id.tab_photo);
//        viewpager = findViewById(R.id.viewpager);

//        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tablayout.getTabCount());
//        viewpager.setAdapter(pagerAdapter);
//
//        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewpager.setCurrentItem(tab.getPosition());
//                if (tab.getPosition() == 0) {
//                    pagerAdapter.notifyDataSetChanged();
//                } else if (tab.getPosition() == 1) {
//                    pagerAdapter.notifyDataSetChanged();
//                } else if (tab.getPosition() == 2) {
//                    pagerAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
//

        //------------------------------------

        ListPhoto = new ArrayList<>();
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));

        //-------------------------
        RecyclerView photoRv = findViewById(R.id.rv_photo);
        PhotoAdapter phadapter = new PhotoAdapter(this, ListPhoto);

        photoRv.setLayoutManager(new GridLayoutManager(this, 3));
        photoRv.setAdapter(phadapter);

        //--------------------

        //------------------------

        ListNews = new ArrayList<>();
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));



        //------------------------

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public void news(View view) {


        Toast.makeText(getApplicationContext(),"Btn clickt",Toast.LENGTH_SHORT).show();
        RecyclerView photoRv = findViewById(R.id.rv_photo);
        PhotoAdapter phadapter = new PhotoAdapter(this, ListPhoto);

        photoRv.setLayoutManager(new GridLayoutManager(this, 3));
        photoRv.setAdapter(phadapter);

//        photoRv.Recycler.Clear
//        adapter.notifyDataSetChanged();
    }
}