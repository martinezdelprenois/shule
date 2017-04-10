package com.example.marto.my_school_revierwer_4.SwipeViews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marto.my_school_revierwer_4.com.marto.signup.process.Home_one;
import com.example.marto.my_school_revierwer_4.R;

/**
 * Created by marto on 02-Apr-17.
 */

public class Introduction extends FragmentActivity{

    private Button skip;
    public Button signup;
    ViewPager vp;
    ViewPagerAdapter adapt;

    int[] layouts;

    @Override
    protected void onCreate(Bundle thiss){
        super.onCreate(thiss);
        setContentView(R.layout.layout);

        vp = (ViewPager)findViewById(R.id.pager1);

        skip = (Button)findViewById(R.id.btn_skip);
        signup = (Button)findViewById(R.id.btn_to_signup);



        layouts = new int[]{
                R.layout.intro_one,
                R.layout.intro_two
        };

        adapt = new ViewPagerAdapter();
        vp.setAdapter(adapt);
        vp.addOnPageChangeListener(viewListener);

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

           if(position == layouts.length-1){
               signup.setText("SIGN UP");
               skip.setVisibility(View.GONE);


           }
           else{
               signup.setText("NEXT");
               skip.setText("BACK");

           }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    public void btn_skip(View v){
        finish();
        startActivity(new Intent(this, Home_one.class));
    }

    private int getitem(int i){
        return vp.getCurrentItem() + 1;
    }

    public void signup(View v){

        int current = getitem(1);
        if(current < layouts.length){
            vp.setCurrentItem(current);
        }
        else{
            finish();
            startActivity(new Intent(this,Home_one.class));
        }

    }
    public class ViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position){
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position], container, false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {

            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            View v = (View) object;
            container.removeView(v);
        }
    }
}


