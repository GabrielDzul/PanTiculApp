package com.kokomusoft.panticul;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.kokomusoft.panticul.fragments.ContactFragment;
import com.kokomusoft.panticul.fragments.NewsFragment;
import com.kokomusoft.panticul.fragments.PresentationFragment;
import com.kokomusoft.panticul.fragments.ProposalsFragment;
import com.kokomusoft.panticul.fragments.WhoIAmFragment;
import com.kokomusoft.panticul.fragments.WhyAmIDifferentFragment;

/**
 * Created by Gabriel on 10/02/2015.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = { "Noticias", "Inicio", "¿Quíen Soy?",
            "Propuestas", "Contacto" };

    public PagerAdapter(android.support.v4.app.FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        //return MainActivity.PlaceholderFragment.newInstance(position + 1);

        switch (position){
            case 0:
                return new NewsFragment();
            case 1:
                return new PresentationFragment();
            case 2:
                return new WhoIAmFragment();
            case 3:
                return new ProposalsFragment();
            /*case 4:
                return new WhyAmIDifferentFragment();*/
            case 4:
                return new ContactFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }
}
