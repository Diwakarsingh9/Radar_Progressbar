package com.apporio.radar_progressbar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.apporio.radarprogressbarlibrary.RadarProgressView;

public class MainActivity extends Activity {
    LinearLayout llforprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llforprogress = (LinearLayout) findViewById(R.id.llforprogress);
        llforprogress.addView(new RadarProgressView(this));
    }
}
