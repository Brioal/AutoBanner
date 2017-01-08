package com.brioal.autobanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.brioal.bannerview.BannerBean;
import com.brioal.bannerview.BannerView;
import com.brioal.bannerview.DefaultIndexView;
import com.brioal.bannerview.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

public class CirclePointActivity extends AppCompatActivity {
    private BannerView mBannerView;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_point);
        mBannerView = (BannerView) findViewById(R.id.circle_bannerView);
        List<BannerBean> list = new ArrayList<>();
        list.add(new BannerBean("http://123.206.20.217/brioalcode/up//4d27d2f4cc47a3cf87b60ac1a2b3ae9c510.png", "第一", ""));
        list.add(new BannerBean("http://123.206.20.217/brioalcode/up//6322dbed206f0c7a5f94dc1d638bb933783.jpg", "第一", ""));
        list.add(new BannerBean("http://123.206.20.217/brioalcode/up//c526cbe82e762e9f4cdef618db1a4f38139.jpg", "第一", ""));
        list.add(new BannerBean("http://123.206.20.217/brioalcode/up//3349eb20e1cf80a9773c7cae5834c6ed923.jpg", "第一", ""));
        list.add(new BannerBean("http://123.206.20.217/brioalcode/up//877f4ff245d55f60948e575f2726bfd1214.jpg", "第一", ""));
        mBannerView.initViewPager(list, 2000, new OnBannerClickListener() {
            @Override
            public void click(BannerBean bean, int position) {
                showToast(position + "");
            }
        })
                .initIndex(new DefaultIndexView(this).setPointSize(6))
                .build(getSupportFragmentManager());
    }

    private void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
