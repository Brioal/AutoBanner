package com.brioal.bannerview;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

public class BannerView extends RelativeLayout {
    private BannerViewPager mViewPager;
    private BaseIndexView mBaseIndexView;
    private Context mContext;
    private List<BannerBean> mList;
    private boolean isGallery = false;//是否画廊效果
    private BaseTransformer mTransformer;//切换动画

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public BannerView initViewPager(List<BannerBean> list, int duration, OnBannerClickListener listener) {
        mList = list;
        mViewPager = new BannerViewPager(mContext);
        List<BannerBean> data = new ArrayList<>();
        data.addAll(list);
        mViewPager.setList(data).setDuration(duration).setOnBannerClickListener(listener);
        return this;
    }

    public BannerView initIndex(BaseIndexView indexView) {
        mBaseIndexView = indexView;
        return this;
    }

    //设置是否画廊效果
    public BannerView setGallery(boolean gallery) {
        isGallery = gallery;
        return this;
    }

    //设置切换动画
    public BannerView setTransDormer(BaseTransformer transDormer) {
        mTransformer = transDormer;
        return this;
    }

    public void build(FragmentManager manager) {
        if (mTransformer != null) {
            mViewPager.setPageTransformer(true, mTransformer);
        }
        mViewPager.setId(Integer.valueOf(3));
        mViewPager.build(manager);
        mViewPager.setCurrentItem(mList.size());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mBaseIndexView.setNextIndex(position % mList.size() - 1);
                mBaseIndexView.setOffset(positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        RelativeLayout.LayoutParams viewPagerParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (isGallery) {
            mViewPager.setClipChildren(false);
            setClipChildren(false);
            mViewPager.setPageMargin(16);
            viewPagerParams.leftMargin = 80;
            viewPagerParams.rightMargin = 80;
        }
        viewPagerParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(mViewPager, viewPagerParams);
        if (mBaseIndexView == null) {
            mBaseIndexView = new DefaultIndexView(mContext);
        }
        mViewPager.initIndexView(mBaseIndexView);
        RelativeLayout.LayoutParams indexParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        indexParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        addView(mBaseIndexView, indexParams);
    }

}
