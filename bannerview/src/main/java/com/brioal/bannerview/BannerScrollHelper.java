package com.brioal.bannerview;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

class BannerScrollHelper extends Scroller {

    private int mDuration = 1500;

    public BannerScrollHelper(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    public void setmDuration(int time) {
        mDuration = time;
    }

    public int getmDuration() {
        return mDuration;
    }
}
