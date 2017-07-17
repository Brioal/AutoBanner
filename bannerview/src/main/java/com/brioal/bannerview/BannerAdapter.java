package com.brioal.bannerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

 class BannerAdapter extends FragmentStatePagerAdapter {
    private List<BannerBean> mList;

    public BannerAdapter(FragmentManager fm, List<BannerBean> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return BannerFragment.getInstance(mList.get(position%mList.size()));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
