package com.example.leelay.galleyviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        float density = getResources().getDisplayMetrics().density;
        GalleyViewPager viewPager = (GalleyViewPager) findViewById(R.id.viewPager);
        viewPager.setPageMargin((int) (20*density));
        viewPager.setEndWidth((int) (80*density));
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(container.getContext());
                imageView.setImageResource(R.mipmap.car);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                container.addView(imageView);
                return imageView;

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

viewPager.setOffscreenPageLimit(5);

    }
}
