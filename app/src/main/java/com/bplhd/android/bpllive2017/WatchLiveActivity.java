package com.bplhd.android.bpllive2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class WatchLiveActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_live);

        ////////////////ad
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3163725584935426/3992496461");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Find the view that shows the Server1 Activity
        Button server1 = (Button) findViewById(R.id.server1);

        //Set a clicklistener on that view
        server1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent server1Intent = new Intent(WatchLiveActivity.this, Server1Activity.class);
                startActivity(server1Intent);
            }
        });

        //Find the view that shows the Server2 Activity
        Button server2 = (Button) findViewById(R.id.server2);

        //Set a clicklistener on that view
        server2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent server2Intent = new Intent(WatchLiveActivity.this, Server2Activity.class);
                startActivity(server2Intent);
            }
        });

        //Find the view that shows the Server3 Activity
        Button server3 = (Button) findViewById(R.id.server3);

        //Set a clicklistener on that view
        server3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent server3Intent = new Intent(WatchLiveActivity.this, Server3Activity.class);
                startActivity(server3Intent);
            }
        });

        //Find the view that shows the Server4 Activity
        Button server4 = (Button) findViewById(R.id.server4);

        //Set a clicklistener on that view
        server4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent server4Intent = new Intent(WatchLiveActivity.this, Server4Activity.class);
                startActivity(server4Intent);
            }
        });

        //Find the view that shows the Server5 Activity
        Button server5 = (Button) findViewById(R.id.server5);

        //Set a clicklistener on that view
        server5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent server5Intent = new Intent(WatchLiveActivity.this, Server5Activity.class);
                startActivity(server5Intent);
            }
        });
    }
}
