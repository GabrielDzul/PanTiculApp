package com.kokomusoft.panticul.fragments;


import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.kokomusoft.panticul.R;
import com.kokomusoft.panticul.utils.ScreenMeasures;

/**
 * A simple {@link Fragment} subclass.
 */
public class WhoIAmFragment extends Fragment {


    public WhoIAmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_who_iam, container, false);

        Point size = new Point();
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        display.getSize(size);

        int displayWidth = size.x;
        int displayHeigth = size.y;

        int statusBarHeight = ScreenMeasures.getStatusBarHeight(getActivity().
                getApplicationContext());
        //Multiplied x2 because of the tabBar under the action bar
        int actionBarHeight = ScreenMeasures.getActionBarHeight(getActivity()) * 2;
        int layoutHeight = displayHeigth - statusBarHeight - actionBarHeight;

        LinearLayout generalDataSection = (LinearLayout)rootView.
                findViewById(R.id.generalDataSection);

         LinearLayout.LayoutParams layoutParams = new LinearLayout.
                 LayoutParams(displayWidth, layoutHeight);
        generalDataSection.setLayoutParams(layoutParams);

        LinearLayout previousWorksSection = (LinearLayout)rootView.
                findViewById(R.id.previousWorksSection);
        previousWorksSection.setMinimumHeight(layoutHeight);
        previousWorksSection.setMinimumWidth(displayWidth);

        LinearLayout academicFormationSection = (LinearLayout)rootView.
                findViewById(R.id.academicFormationSection);
        academicFormationSection.setMinimumHeight(layoutHeight);
        academicFormationSection.setMinimumWidth(displayWidth);

        LinearLayout hobbiesSection = (LinearLayout)rootView.findViewById(
                R.id.hobbiesSection);
        hobbiesSection.setMinimumHeight(layoutHeight);
        hobbiesSection.setMinimumWidth(displayWidth);



        Log.d("screenHeight: ", String.valueOf(displayHeigth));
        Log.d("status bar height: ", String.valueOf(statusBarHeight));
        Log.d("action bar height: ", String.valueOf(actionBarHeight));



        return rootView;
    }


}
