package com.brioal.bannerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

 class CircleIndex extends View {
    private int mCount; // 总数
    private int mNextIndex;//要选中的下标
    private float mOffset = 0;//位置偏移量
    private int mCircleRadius = 10;//原点半径
    private int mHeight = 0;//高度
    private int mWidth = 0;//宽度
    private int mColorNormal;//一般的颜色
    private int mColorSelect;//选中的颜色
    private Paint mPaint;

    public CircleIndex(Context context) {
        super(context);
        init();
    }
    //设置原点半径
    public void setCircleRadius(int circleRadius) {
        mCircleRadius = circleRadius;
        invalidate();
    }

    //设置默认颜色
    public void setColorNormal(int colorNormal) {
        mColorNormal = colorNormal;
        invalidate();
    }

    //设置选中的颜色
    public void setColorSelect(int colorSelect) {
        mColorSelect = colorSelect;
        invalidate();
    }

    private void init() {
        mColorNormal = getResources().getColor(R.color.circle_color_normal);
        mColorSelect = getResources().getColor(R.color.circle_color_select);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public void setCount(int count) {
        mCount = count;
    }

    public void setNextIndex(int selectIndex) {
        mNextIndex = selectIndex;
        invalidate();
    }

    public void setOffset(float offset) {
        mOffset = offset;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mHeight = mCircleRadius * 4;
        mWidth = (3 * mCount + 1) * mCircleRadius;
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(mColorNormal);
        //绘制所有的未选中点
        for (int i = 0; i < mCount; i++) {
            int x = 2 * mCircleRadius + i * 3 * mCircleRadius;
            canvas.drawCircle(x, mHeight / 2, mCircleRadius, mPaint);
        }
        //绘制当前选中点的位置
        mPaint.setColor(mColorSelect);
        int x = (int) (2 * mCircleRadius + mNextIndex * 3 * mCircleRadius + 3 * mCircleRadius * mOffset);
        canvas.drawCircle(x, mHeight / 2, mCircleRadius, mPaint);
    }
}
