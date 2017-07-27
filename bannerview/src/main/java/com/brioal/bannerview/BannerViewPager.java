package com.brioal.bannerview;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import java.lang.reflect.Field;
import java.util.List;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

class BannerViewPager extends ViewPager implements View.OnClickListener {
    private List<BannerBean> mList;
    private BannerAdapter mAdapter;
    private Handler mHandler = new Handler();
    private long mDuration = 2500;
    private boolean isAnimation = false;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (isAnimation) {
                next();
            }
            mHandler.postDelayed(this, mDuration + 2000);
        }
    };
    private OnBannerClickListener mClickListener;
    private BaseIndexView mIndexView;

    public BannerViewPager setOnBannerClickListener(OnBannerClickListener listener) {
        this.mClickListener = listener;
        setOnClickListener(this);
        return this;
    }

    public BannerViewPager(Context context) {
        this(context, null);
    }

    public BannerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScroller();
    }

    private void initScroller() {
        BannerScrollHelper mScroller = null;
        try {
            Field mField;

            mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);

            mScroller = new BannerScrollHelper(getContext(),
                    new AccelerateInterpolator());
            mScroller.setmDuration(900);
            mField.set(this, mScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //设置数据源
    public BannerViewPager setList(List<BannerBean> list) {
        mList = list;
        return this;
    }

    //设置乱拨间隔
    public BannerViewPager setDuration(long duration) {
        mDuration = duration;
        return this;
    }

    //设置IndexView
    public BannerViewPager initIndexView(BaseIndexView indexView) {
        mIndexView = indexView;
        mIndexView.setCount(mList.size());
        return this;
    }

    public BannerViewPager build(FragmentManager manager) {
        isAnimation = true;
        mAdapter = new BannerAdapter(manager, mList);
        //设置适配器
        setAdapter(mAdapter);
        //开始自动轮播
        mHandler.postDelayed(mRunnable, mDuration + 2000);
        return this;
    }

    //自动切换到下一张
    private void next() {
        if (!isAnimation) {
            return;
        }
        setCurrentItem(getCurrentItem() + 1, true);
    }


    @Override
    public void onClick(View v) {
        System.out.println("Click");
        if (mClickListener != null) {
            mClickListener.click(mList.get(getCurrentItem() % mList.size()), getCurrentItem() % mList.size());
        }
    }

    long dasdas = 0;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dasdas = System.currentTimeMillis();
                isAnimation = false;
                System.out.println("Drag Start");
                break;
            case MotionEvent.ACTION_UP:
                if (System.currentTimeMillis() - dasdas < 100) {
                    mClickListener.click(mList.get(getCurrentItem() % mList.size()), getCurrentItem() % mList.size());
                }
                System.out.println("Drag End");
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isAnimation = true;
                    }
                }, 5000);
                break;
        }
        return super.onTouchEvent(ev);
    }

}
