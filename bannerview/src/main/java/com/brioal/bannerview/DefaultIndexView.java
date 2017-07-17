package com.brioal.bannerview;

import android.content.Context;
import android.view.Gravity;
import android.widget.RelativeLayout;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

public class DefaultIndexView extends BaseIndexView {
    private CircleIndex mCircleIndex;

    public DefaultIndexView(Context context) {
        super(context);
        mCircleIndex = new CircleIndex(context);
        LayoutParams params = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.rightMargin = 20;
        params.leftMargin = 20;
        addView(mCircleIndex, params);
    }

    //设置原点半径
    public DefaultIndexView setPointSize(int size) {
        mCircleIndex.setCircleRadius(size);
        return this;
    }

    //设置位置
    public DefaultIndexView setPosition(int gravity) {
        LayoutParams params = (LayoutParams) mCircleIndex.getLayoutParams();
        switch (gravity) {
            case Gravity.CENTER:
                //放置在中间位置
                params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
            case Gravity.LEFT:
                //放置在左边
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                break;
            case Gravity.RIGHT:
                //放置在右边
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                break;
        }
        mCircleIndex.setLayoutParams(params);
        return this;
    }

    //设置原点的未选中颜色
    public DefaultIndexView setColorNormal(int colorNormal) {
        mCircleIndex.setColorNormal(colorNormal);
        return this;
    }

    //设置圆点的选中颜色
    public DefaultIndexView setColorSelect(int colorSelect) {
        mCircleIndex.setColorSelect(colorSelect);
        return this;
    }

    @Override
     void setCount(int count) {
        mCircleIndex.setCount(count);
    }

    @Override
     void setNextIndex(int selectedIndex) {
        mCircleIndex.setNextIndex(selectedIndex);
    }

    @Override
     void setOffset(float offset) {
        mCircleIndex.setOffset(offset);
    }

}
