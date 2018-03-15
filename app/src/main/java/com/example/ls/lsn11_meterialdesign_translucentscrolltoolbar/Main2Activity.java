package com.example.ls.lsn11_meterialdesign_translucentscrolltoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements MyListView.ListScrollTranslate {
    private Toolbar mToolbar;
    private MyListView myListView;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        initData();
        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        myListView = (MyListView) findViewById(R.id.list_view);
        myListView.setTranLinner(this);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_list_item_1, itemList);//适配器
        myListView.setAdapter(myAdapter);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,RecylerViewTranslate.class));
            }
        });
    }

    public void initData() {
        itemList = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            itemList.add("测试数据" + i);
        }
    }



    @Override
    public void transListenner(float alpha) {
        mToolbar.setAlpha(alpha);

    }
}
