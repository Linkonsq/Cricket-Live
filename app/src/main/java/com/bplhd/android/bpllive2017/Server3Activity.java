package com.bplhd.android.bpllive2017;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Server3Activity extends Activity {
    private WebView webView;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server3);

        ////////////////ad
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3163725584935426/3992496461");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        webView = (WebView) findViewById(R.id.server3WebView);

        //open browser inside your app
        webView.setWebViewClient(new MyBroswer());
        String url = "http://prapti.crickint.com/piu3.html";
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);

        //Interstitial ad
        prepareAd();

        //ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                Log.i("Hello", "Ads");
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        prepareAd();
                    }
                });
            }
        }, 1, 10, TimeUnit.MINUTES);//startup delay, interval
    }

    //now lets override default browser  to open browser inside app

    private class MyBroswer extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void prepareAd() {
        //Interstitial ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3163725584935426/1529984659");
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");    //sample id
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scheduler.shutdown();
    }

    @Override
    protected void onStop() {
        super.onStop();
        scheduler.shutdown();
    }
}
