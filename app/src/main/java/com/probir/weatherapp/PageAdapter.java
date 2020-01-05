package com.probir.weatherapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numoftab;

    public PageAdapter(FragmentManager fm, int numoftab) {
        super(fm);
        this.numoftab = numoftab;
    }

    public PageAdapter(FragmentManager fm) {
        super(fm);

    }

    //---------------------Implementation----------------------
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new tab1();
            case 1:
                return new tab2();
            case 2:
                return new tab3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return POSITION_NONE;
    }
}
