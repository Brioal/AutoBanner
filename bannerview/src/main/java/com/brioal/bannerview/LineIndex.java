package com.brioal.bannerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-8.
 */

class LineIndex extends View {
    private int mLineHeight;//线的高度，也是组件的高度
    private int mWidth;//组件宽度
    private int mCount;//总数
    private int mCurrentIndex;//当前下标
    private float mOffset;//当前下标的偏移
    private int mLineColor;//线的颜色
    private Paint mPaint;
    private int mLineWidth;//线的宽度

    //设置总数
    public void setCount(int count) {
        mCount = count;
    }

    //设置当前下标
    public void setCurrentIndex(int currentIndex) {
        mCurrentIndex = currentIndex;
        invalidate();
    }

    //设置当前的偏移
    public void setOffset(float offset) {
        mOffset = offset;
        invalidate();
    }

    //设置线的颜色
    public void setLineColor(int lineColor) {
        mLineColor = lineColor;
    }

    //设置线的高度
    public void setLineHeight(int lineHeight) {
        mLineHeight = lineHeight;
    }

    public LineIndex(Context context,int lineHeight) {
        super(context);
        mLineHeight = lineHeight;
        init();
    }

    private void init() {
        mLineColor = getResources().getColor(R.color.line_color);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(mLineColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mLineWidth = mWidth / mCount;
        setMeasuredDimension(mWidth, mLineHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制线条
        int x = (int) (mCurrentIndex * mLineWidth + mLineWidth * mOffset);
        Rect rect = new Rect();
        rect.left = x;
        rect.top = 0;
        rect.right = x+mLineWidth;
        rect.bottom = mLineHeight;

        if (rect.right > mWidth) {
            Rect leftRect = new Rect();
            leftRect.left = 0;
            leftRect.top = 0;
            leftRect.right = x+mLineWidth-mWidth;
            leftRect.bottom = mLineHeight;
            canvas.drawRect(leftRect, mPaint);
        }
        canvas.drawRect(rect, mPaint);
    }
}
