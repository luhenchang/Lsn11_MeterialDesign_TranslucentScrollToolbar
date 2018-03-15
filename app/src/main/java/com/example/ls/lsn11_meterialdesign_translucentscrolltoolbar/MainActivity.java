package com.example.ls.lsn11_meterialdesign_translucentscrolltoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements MyScrollView.TranslucentListener{
    private Toolbar mToolbar;
    private MyScrollView myScrollView;
    private ScrollView mScr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mToolbar= (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        myScrollView= (MyScrollView) findViewById(R.id.scroll_view);
        myScrollView.setTransluListenner(this);
        mScr.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public void TranslucentTobar(float alpha) {
        mToolbar.setAlpha(alpha);
    }
}
