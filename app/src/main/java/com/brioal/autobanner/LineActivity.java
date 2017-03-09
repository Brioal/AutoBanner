package com.brioal.autobanner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.brioal.bannerview.BannerBean;
import com.brioal.bannerview.BannerView;
import com.brioal.bannerview.LineIndexView;
import com.brioal.bannerview.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

public class LineActivity extends AppCompatActivity {
    private BannerView mBannerView;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        mBannerView = (BannerView) findViewById(R.id.line_banner);
        List<BannerBean> list = new ArrayList<>();
        list.add(new BannerBean("http://119.29.116.206/pics/01.jpg", "", ""));
        list.add(new BannerBean("http://119.29.116.206/pics/02.jpg", "", ""));
        list.add(new BannerBean("http://119.29.116.206/pics/03.jpg", "", ""));
        list.add(new BannerBean("http://119.29.116.206/pics/04.jpg", "", ""));
        list.add(new BannerBean("http://119.29.116.206/pics/05.jpg", "", ""));

        mBannerView.initViewPager(list, 2000, new OnBannerClickListener() {
            @Override
            public void click(BannerBean bean, int position) {
                showToast(position + "");
            }
        })
                .initIndex(new LineIndexView(this, 9).setLineColor(Color.RED))
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
