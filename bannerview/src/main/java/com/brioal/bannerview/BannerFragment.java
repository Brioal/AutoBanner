package com.brioal.bannerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * email :brioal@foxmail.com
 * github : https://github.com/Brioal
 * Created by brioal on 17-1-7.
 */

public class BannerFragment extends Fragment {
    private BannerBean mBean;
    private View mRootView;
    private ImageView mIvImg;
    private TextView mTvTip;

    public static BannerFragment getInstance(BannerBean bannerBean) {
        BannerFragment fragment = new BannerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean", bannerBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBean = (BannerBean) getArguments().get("bean");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.item_banner, container, false);
        mIvImg = mRootView.findViewById(R.id.item_iv_img);
        mTvTip = mRootView.findViewById(R.id.item_tv_tip);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mBean == null) {
            return;
        }
        if (mBean.getTip() != null && !mBean.getTip().isEmpty()) {
            mTvTip.setVisibility(View.VISIBLE);
            mTvTip.setText(mBean.getTip());
        } else {
            mTvTip.setVisibility(View.GONE);
        }

        if (mBean.getImgUrl() != null && !mBean.getImgUrl().isEmpty()) {
            Glide.with(getActivity()).load(mBean.getImgUrl()).error(PicConfig.FAILED_PIC).into(mIvImg);
        }


    }
}
