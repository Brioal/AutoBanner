package com.brioal.bannerview;

import java.io.Serializable;

/**
 * Banner 的数据实体
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

public  class BannerBean implements Serializable{
    private String mImgUrl;//图片地址
    private String mTip;//图片提示
    private String mIndex;//实体数据

    public BannerBean(String imgUrl) {
        mImgUrl = imgUrl;
    }

    public BannerBean(String imgUrl, String tip, String index) {
        mImgUrl = imgUrl;
        mTip = tip;
        mIndex = index;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public BannerBean setImgUrl(String imgUrl) {
        mImgUrl = imgUrl;
        return this;
    }

    public String getTip() {
        return mTip;
    }

    public BannerBean setTip(String tip) {
        mTip = tip;
        return this;
    }

    public String getIndex() {
        return mIndex;

    }

    public BannerBean setIndex(String index) {
        mIndex = index;
        return this;
    }
}
