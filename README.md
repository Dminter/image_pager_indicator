image_pager_indicator
=====================
#1.viewpager滑动下面的imageview指示器跟着滚动
#2.点击imageview指示器可定位到对应viewpager页面
#示例代码
ImageViewIndicator mIndicator = (ImageViewIndicator) findViewById(R.id.mInficator);
mIndicator.setPager(mViewPager);
mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                
            }
            @Override
            public void onPageSelected(int i) {

            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
<FrameLayout
        android:layout_width="fill_parent"
        android:layout_height="fill_parent">

        <android.support.v4.view.ViewPager

            android:id="@+id/mViewPage"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:layout_gravity="center_horizontal"/>


        <com.zncm.image_pager_indicator.ImageViewIndicator
            android:layout_width="wrap_content"
            android:id="@+id/mInficator"
            android:layout_height="wrap_content"
            android:layout_gravity="center|bottom"
            android:layout_marginBottom="20dp"
            android:gravity="center_horizontal"/>
</FrameLayout>
![图示](https://github.com/Dminter/image_pager_indicator/blob/master/pic/device-2014-11-21-153439.png)
