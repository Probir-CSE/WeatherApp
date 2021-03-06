package com.probir.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class WeatherDetails extends AppCompatActivity {

    TextView tvWeather, tvNews, tvPhoto, tempTv;
    View viewWeather, viewNews, viewPhoto;

    List<PhotoConstractor> ListPhoto;
    List<PhotoConstractor> ListNews;
    private RecyclerView photoRv;
    private PhotoAdapter phadapter;
    private Context context = this;

//    private TabLayout tablayout;
//    private ViewPager viewpager;
//    private TabItem tab1, tab2, tab3;
//    public PageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_weather_details);
        tempTv = findViewById(R.id.tv_temp);

        tvWeather = findViewById(R.id.tv_weather);
        tvNews = findViewById(R.id.tv_news);
        tvPhoto = findViewById(R.id.tv_photo);

        viewWeather = findViewById(R.id.view_weather);
        viewNews = findViewById(R.id.view_news);
        viewPhoto = findViewById(R.id.view_photo);

//-------------onclick text Color Change---------------------------
        tvWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tvWeather.setText("Weather!");
//                tvWeather.setBackgroundColor(0xFF9C27B0);
                tvWeather.setTextColor(0xFF9C27B0);
                viewWeather.setBackgroundColor(0xFF9C27B0);
                viewWeather.setVisibility(View.VISIBLE);

                tvNews.setTextColor(getResources().getColor(R.color.LightDark));
                viewNews.setVisibility(View.GONE);
                tvPhoto.setTextColor(getResources().getColor(R.color.LightDark));
                viewPhoto.setVisibility(View.GONE);

                weaterRV();
                photoRv.setLayoutManager(new GridLayoutManager(context, 3));
                photoRv.setAdapter(new PhotoAdapter(getApplicationContext(), ListPhoto));
//                viewWeather.setVisibility(View.GONE);
//                tvWeather.setBackgroundResource(R.color.Purple);
            }
        });
        //----------------------End of onclick text Color Change------------------------
        tvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvNews.setTextColor(0xFF9C27B0);
                viewNews.setBackgroundColor(0xFF9C27B0);
                viewNews.setVisibility(View.VISIBLE);

                tvWeather.setTextColor(getResources().getColor(R.color.LightDark));
                viewWeather.setVisibility(View.GONE);
                tvPhoto.setTextColor(getResources().getColor(R.color.LightDark));
                viewPhoto.setVisibility(View.GONE);
                newsRV();
                photoRv.setLayoutManager(new GridLayoutManager(context, 3));
                photoRv.setAdapter(new PhotoAdapter(getApplicationContext(), ListPhoto));
            }
        });

        tvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvPhoto.setTextColor(0xFF9C27B0);
                viewPhoto.setBackgroundColor(0xFF9C27B0);
                viewPhoto.setVisibility(View.VISIBLE);

                tvNews.setTextColor(getResources().getColor(R.color.LightDark));
                viewNews.setVisibility(View.GONE);
                tvWeather.setTextColor(getResources().getColor(R.color.LightDark));
                viewWeather.setVisibility(View.GONE);
                photoRV();
                photoRv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                photoRv.setAdapter(new PhotoAdapter(getApplicationContext(), ListPhoto));
            }
        });

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
        weaterRV();

        //-------------------------
        photoRv = findViewById(R.id.rv_photo);
        phadapter = new PhotoAdapter(this, ListPhoto);

        photoRv.setLayoutManager(new GridLayoutManager(this, 3));
        photoRv.setAdapter(phadapter);

        //--------------------

        //------------------------
//
//        ListNews = new ArrayList<>();
//        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
//        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
//        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
//        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
//        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
//        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
//        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
//

        //------------------------
        Weather weatherdata = new Weather();
        try {
            String content = weatherdata.execute("http://api.openweathermap.org/data/2.5/weather?id=1337179&appid=020d1042f22d9f7dd46628c5b5505f06&units=Imperial").get();
//            Log.i("All Data", content);

            JSONObject jsonMainWeatherObject = new JSONObject(content);
            String main = jsonMainWeatherObject.getString("main");
            Log.i("Main Data", main);

            JSONObject tempData = new JSONObject(main);
            int temp = tempData.getInt("temp");
            int convertToCel = (int) ((temp - 32) / 1.8000);
            Log.i("Temperature:", String.valueOf(convertToCel));


            tempTv.setText(String.valueOf(convertToCel));


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

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

    private void weaterRV() {
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
    }

    private void photoRV() {
        ListPhoto = new ArrayList<>();
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
    }

    private void newsRV() {
        ListPhoto = new ArrayList<>();
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
        ListPhoto.add(new PhotoConstractor(R.drawable.sunrise));
        ListPhoto.add(new PhotoConstractor(R.drawable.sun2));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


//    public void news(View view) {
//
//
//        Toast.makeText(getApplicationContext(),"Btn clickt",Toast.LENGTH_SHORT).show();
//        RecyclerView photoRv = findViewById(R.id.rv_photo);
//        PhotoAdapter phadapter = new PhotoAdapter(this, ListPhoto);
//
//        photoRv.setLayoutManager(new GridLayoutManager(this, 3));
//        photoRv.setAdapter(phadapter);
//
////        photoRv.Recycler.Clear
////        adapter.notifyDataSetChanged();
//    }
}
