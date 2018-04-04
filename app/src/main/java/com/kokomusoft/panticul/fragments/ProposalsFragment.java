package com.kokomusoft.panticul.fragments;


import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kokomusoft.panticul.R;
import com.kokomusoft.panticul.utils.ScreenMeasures;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProposalsFragment extends Fragment {


    public ProposalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_proposals, container, false);

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

        LinearLayout proposalSectionIntro = (LinearLayout)rootView.findViewById(
                R.id.proposalSectionIntro);
        proposalSectionIntro.setMinimumWidth(displayWidth);
        proposalSectionIntro.setMinimumHeight(layoutHeight);

        LinearLayout socialAndFamiliar = (LinearLayout)rootView.findViewById(
                R.id.socialAndFamiliarSection);
        socialAndFamiliar.setMinimumWidth(displayWidth);
        socialAndFamiliar.setMinimumHeight(layoutHeight);

        LinearLayout healthAndEnvironment = (LinearLayout)rootView.findViewById(
                R.id.healthAndEnvironmentSection);
        healthAndEnvironment.setMinimumWidth(displayWidth);
        healthAndEnvironment.setMinimumHeight(layoutHeight);

        // Inflate the layout for this fragment
        return rootView;
    }


}
