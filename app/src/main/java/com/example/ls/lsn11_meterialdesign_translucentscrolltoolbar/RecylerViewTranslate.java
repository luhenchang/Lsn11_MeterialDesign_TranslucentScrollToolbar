package com.example.ls.lsn11_meterialdesign_translucentscrolltoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewTranslate extends AppCompatActivity {
    RecyclerView  recyclerView;
    private Toolbar app_Toolbar;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recyler_view_translate);
        recyclerView= (RecyclerView) findViewById(R.id.recyler_view);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        int scrollY1=recyclerView.getScrollY();
        Log.e("scrollY1",scrollY1+"");
        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.e("scrollY",scrollY+"");
                int scrollYs=0;
                View view=recyclerView.getChildAt(0);

                if(view==null){
                    scrollYs=0;
                }

                scrollYs=-view.getTop()+((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition()*view.getHeight();
                int screenHeight=getResources().getDisplayMetrics().heightPixels;
                if(scrollYs<screenHeight/3f){

                    transListenner(1-scrollYs/(screenHeight/3f));

                }
            }
        });
        app_Toolbar= (Toolbar) findViewById(R.id.app_toolbar);
        app_Toolbar.setTitle("RecylerView渐变");
        mData=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            mData.add("item="+i);
        }
        RecylerViewApdater madapter=new RecylerViewApdater(this,mData);
        recyclerView.setAdapter(madapter);
        madapter.notifyDataSetChanged();
    }
    public void transListenner(float alpha) {
        Log.e("alpheass",alpha+"");
        app_Toolbar.setAlpha(alpha);

    }
}
