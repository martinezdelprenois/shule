package com.example.marto.my_school_revierwer_4.SwipeViews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by marto on 02-Apr-17.
 */

public class PageAdapte extends FragmentPagerAdapter {

    Introduction ed = new Introduction();


    public PageAdapte(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Intro_one();

            case 1:
                return new Intro_two();


        }


        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
