package com.bplhd.android.bpllive2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Banner ad
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3163725584935426/3992496461");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Find the view that shows the WatchLiveActivity
        TextView watchLive = (TextView) findViewById(R.id.watchLive);

        //Set a clicklistener on that view
        watchLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent watchLiveIntent = new Intent(MainActivity.this, WatchLiveActivity.class);
                startActivity(watchLiveIntent);
            }
        });

        //Find the view that shows the LiveScoreActivity
        TextView liveScore = (TextView) findViewById(R.id.liveScore);

        //Set a clicklistener on that view
        liveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent liveScoreIntent = new Intent(MainActivity.this, LiveScoreActivity.class);
                startActivity(liveScoreIntent);
            }
        });

        //Find the view that shows the AboutUsActivity
        TextView aboutUs = (TextView) findViewById(R.id.aboutUs);

        //Set a clicklistener on that view
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent aboutUsIntent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(aboutUsIntent);
            }
        });
    }
}
