package com.brioal.bannerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

abstract class BaseIndexView extends RelativeLayout {

     abstract void setCount(int count);

     abstract void setNextIndex(int selectedIndex);

     abstract void setOffset(float offset);

    public BaseIndexView(Context context) {
        this(context, null);
    }

    public BaseIndexView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setPadding(5, 5, 5, 0);
    }
}
