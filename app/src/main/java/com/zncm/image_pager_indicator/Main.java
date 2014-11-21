package com.zncm.image_pager_indicator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by MX on 11/21 0021.
 */
public class Main extends Activity {

    ViewPager mViewPager;
    ImageViewIndicator mIndicator;

    int imgs[] = new int[]{
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mViewPager = (ViewPager) findViewById(R.id.mViewPage);
        mIndicator = (ImageViewIndicator) findViewById(R.id.mInficator);

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgs.length;
            }


            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }


            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(container.getContext());
                imageView.setImageResource(imgs[position]);
                container.addView(imageView);
//                container.addView(imageView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        mIndicator.setPager(mViewPager);
    }
}
