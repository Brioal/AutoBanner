package com.brioal.autobanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterCircleIndecator(View view) {
        Intent intent = new Intent(this, CirclePointActivity.class);
        startActivity(intent);
    }

    public void enterLineIndicator(View view) {
        Intent intent = new Intent(this, LineActivity.class);
        startActivity(intent);
    }
}
