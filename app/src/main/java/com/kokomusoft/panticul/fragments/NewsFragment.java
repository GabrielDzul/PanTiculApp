package com.kokomusoft.panticul.fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.kokomusoft.panticul.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        WebView newsWebView = (WebView)rootView.findViewById(R.id.newsWebView);
        newsWebView.getSettings().setAppCacheMaxSize( 5 * 1024 * 1024 ); // 5MB
        newsWebView.getSettings().setAppCachePath(getActivity().
                getApplicationContext().getCacheDir().getAbsolutePath() );
        newsWebView.getSettings().setAllowFileAccess( true );
        newsWebView.getSettings().setAppCacheEnabled( true );
        newsWebView.getSettings().setJavaScriptEnabled( true );
        newsWebView.getSettings().setCacheMode( WebSettings.LOAD_DEFAULT ); // load online by default

        if ( !isNetworkAvailable() ) { // loading offline
            newsWebView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }

        newsWebView.loadUrl("http://stackoverflow.com/questions/14549638/webview-not-displaying-website-when-offline");
        //newsWebView.loadUrl("http://gabrieldzul.com");

        return rootView;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager)getActivity().
                        getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
