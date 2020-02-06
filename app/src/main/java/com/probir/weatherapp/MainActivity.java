package com.probir.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView descripionTv, temperatureTv,cityNAmeTv,locationAndDate;
    TextView dateTv;

//    class Weather extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... address) {
//            try {
//                URL url = new URL(address[0]);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                InputStream is = connection.getInputStream();
//                InputStreamReader isr = new InputStreamReader(is);
//
//                int data = isr.read();
//                String content = "";
//                char ch;
//                while (data != -1) {
//                    ch = (char) data;
//                    content = content + ch;
//                    data = isr.read();
//                }
//                return content;
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        descripionTv = findViewById(R.id.tv_description);
        temperatureTv = findViewById(R.id.tv_temperature);
        cityNAmeTv=findViewById(R.id.tv_city_name);
        locationAndDate=findViewById(R.id.tv_location_and_date);
//        dateTv.findViewById(R.id.tv_date);

        String content;
        Weather weather = new Weather();
        try {
            content = weather.execute("https://api.myjson.com/bins/165hic").get();

            Log.e("content", content);

            //JSON
            JSONObject jsonObject = new JSONObject(content);
            String weatherdata = jsonObject.getString("weather");
            String maintemperature = jsonObject.getString("main");
            String cityName = jsonObject.getString("name");

            Log.e("cityName", cityName);
            Log.e("weatherdata", weatherdata);
            Date date = Calendar.getInstance().getTime();
            Log.e("Date", String.valueOf(date));

            SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
//          SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String dateOnly = df.format(date);
            Log.e("Date only", dateOnly);
            locationAndDate.setText(dateOnly);
            locationAndDate.setText(cityName + " " + dateOnly);

            //-------------Clear--------------

            //--------------------------------
            JSONArray jsonArray = new JSONArray(weatherdata);
            String main = "";
            String description = "";
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject weatherpart = jsonArray.getJSONObject(i);
                main = weatherpart.getString("main");
                description = weatherpart.getString("description");
            }
            Log.e("main", main);
            Log.e("description", description);

            descripionTv.setText(main);

//            --------------------------------
//            JSONObject cityNamePart = new JSONObject(cityName);
//            String city = cityNamePart.getString("name");
//            Log.i("City Name", city);

            cityNAmeTv.setText(cityName);
//            -----------------------------------

//            Date date = Calendar.getInstance().getTime();
//            Log.i("Date", String.valueOf(date));
//            --------------------------------

            JSONObject mainPart = new JSONObject(maintemperature);
            int temperatures = mainPart.getInt("temp");
            int convertToCel = (int) ((temperatures - 32) / 1.8000);

            Log.e("mainData", String.valueOf(convertToCel));
            temperatureTv.setText(String.valueOf(convertToCel));


            //    -------------------------


            //    -------------------------
        } catch (Exception e) {
            Log.e("MainActivity", "onCreate: " + e.getLocalizedMessage());
            e.printStackTrace();
        }

//        ----------------------------


    }

    public void go_to_place(View view) {
        Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }


}
