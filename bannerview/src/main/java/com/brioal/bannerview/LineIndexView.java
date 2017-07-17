package com.brioal.bannerview;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-8.
 */

public class LineIndexView extends BaseIndexView {
    private LineIndex mLineIndex;

    public LineIndexView(Context context, int lineHeight) {
        super(context);
        mLineIndex = new LineIndex(context, lineHeight);
        RelativeLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(mLineIndex, params);
    }

    //设置线的颜色
    public LineIndexView setLineColor(int lineColor) {
        mLineIndex.setLineColor(lineColor);
        return this;
    }

    @Override
    void setCount(int count) {
        mLineIndex.setCount(count);
    }

    @Override
    void setNextIndex(int selectedIndex) {
        mLineIndex.setCurrentIndex(selectedIndex);
    }

    @Override
    void setOffset(float offset) {
        mLineIndex.setOffset(offset);
    }
}
