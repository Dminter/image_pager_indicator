package com.zncm.image_pager_indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ImageViewIndicator extends LinearLayout implements ViewPager.OnPageChangeListener {

    private Context ctx;
    private LinearLayout content;
    private ViewPager pager;
    private ViewPager.OnPageChangeListener onPageChangeListener;
    private List<ImageView> mImageViews;

    public ImageViewIndicator(Context context) {
        super(context);
        this.ctx = context;
        init();
        initIndictor();
    }

    public ImageViewIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();

    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_imageview_indicator, this);
            content = (LinearLayout) findViewById(R.id.pager_indicator_container);
            mImageViews = new ArrayList<ImageView>();
        }
    }

    public void setPager(ViewPager pager) {
        this.pager = pager;
        this.pager.setOnPageChangeListener(this);
        if (pager != null) {
            initIndictor();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (this.onPageChangeListener != null) {
            this.onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        setCurrentItem(position);
        if (this.onPageChangeListener != null) {
            this.onPageChangeListener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (this.onPageChangeListener != null) {
            this.onPageChangeListener.onPageScrollStateChanged(state);
        }

    }

    private void setCurrentItem(int position) {
        if (pager != null && pager.getAdapter() != null) {
            int items = pager.getAdapter().getCount();
            for (int i = 0; i < items; i++) {
                ImageView imageView = mImageViews.get(i);
                if (imageView != null) {
                    if (i == position) {
                        imageView.setImageResource(R.drawable.dot_sel);
                    } else {
                        imageView.setImageResource(R.drawable.dot_unsel);
                    }
                }
            }
        }
    }


    public void initIndictor() {
        if (pager != null && pager.getAdapter() != null) {
            content.removeAllViews();
            mImageViews.removeAll(mImageViews);
            for (int i = 0; i < pager.getAdapter().getCount(); i++) {
                ImageView item = new ImageView(ctx);
                if (i == pager.getCurrentItem()) {
                    item.setImageResource(R.drawable.dot_sel);
                } else {
                    item.setImageResource(R.drawable.dot_unsel);
                }
                item.setPadding(0, 0, 30, 0);
                item.setTag(i);
                item.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = (Integer) v.getTag();
                        pager.setCurrentItem(position);
                    }
                });
                mImageViews.add(item);
                content.addView(item);
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener;
    }
}