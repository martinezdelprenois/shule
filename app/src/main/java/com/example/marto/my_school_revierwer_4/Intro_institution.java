package com.example.marto.my_school_revierwer_4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.marto.my_school_revierwer_4.R.layout.activity_intro_institution;

public class Intro_institution extends Activity {


    private ViewPagerAdapter adapt;
    ViewPager pager;
    private TextView[] dots;
    Button next,skip;
    private LinearLayout dotsLayout;
  Intro_tutorial_Manager int_manager;
    private int[] layouts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int_manager = new Intro_tutorial_Manager(this);
        if(!int_manager.check()){ // if the app isnot open for the first time

            int_manager.setfirst(false);
            Intent i = new Intent(Intro_institution.this, Insitution_home.class);
            startActivity(i);
            finish();

        }
        if(Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        }

        pager = (ViewPager)findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.dotsdots);
        skip = (Button) findViewById(R.id.skip);
        next = (Button)findViewById(R.id.nexting);
        setContentView(R.layout.beginner_intro_institution);
        layouts = new int[]{
                activity_intro_institution,
                R.layout.activity_intro_institution_2,
                R.layout.activity_intro_institution_3
        };

        addbottomdots(0);
        changestatusbarcolor();
         adapt = new ViewPagerAdapter();
        pager.setAdapter(adapt);
        pager.addOnPageChangeListener(viewListener);

        skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(Intro_institution.this, Insitution_home.class);
                startActivity(i);
                finish();
            }


        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int current = getitem(+1);
                if(current < layouts.length)
                    pager.setCurrentItem(current);

                else{
                    Intent i  = new Intent(Intro_institution.this, Insitution_home.class);
                    startActivity(i);
                    finish();
                }
            }


        });

    }

    private void addbottomdots(int position){
        dots = new TextView[layouts.length];
        int[] coloractive = getResources().getIntArray(R.array.actives);
        int[] colorinactive = getResources().getIntArray(R.array.actives);
        dotsLayout.removeAllViews();
        for(int i=0; i < dots.length; i++){

            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorinactive[position]);
            dotsLayout.addView(dots[i]);

        }
        if(dots.length >0){

            dots[position].setTextColor(coloractive[position]);
        }

    }

    private int getitem(int i){
        return pager.getCurrentItem() + 1;
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addbottomdots(position);
            if(position == dots.length-1){

                next.setText("PROCEED");
                skip.setVisibility(View.GONE);
            }

            else{
                next.setText("NEXT");
                skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private void changestatusbarcolor(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

public class ViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;

    @Override
    public Object instantiateItem(ViewGroup container,int position){
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
