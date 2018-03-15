package com.example.ls.lsn11_meterialdesign_translucentscrolltoolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

/**
 * Created by 路很长~ on 2018/3/13.
 */

public class MyListView extends ListView {
    public interface ListScrollTranslate {
        void transListenner(float alpha);
    }

    private ListScrollTranslate mTransliener;

    public void setTranLinner(ListScrollTranslate mscrollListenner) {
        this.mTransliener = mscrollListenner;
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mTransliener != null) {
            int scrollY;
            View c =getChildAt(0);

            if (c == null)
            {
                scrollY=0;

            }
            int firstVisiblePosition =getFirstVisiblePosition();
            int top = c.getTop();
            Log.e("topY",top+"");
            Log.e("firstVisibaleTop",firstVisiblePosition * c.getHeight()+"");
            Log.e("getChilder",getChildCount()+"");
            scrollY=-top + firstVisiblePosition * c.getHeight() ;
            int screenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
            if (scrollY <= screenHeight / 3f) {
                mTransliener.transListenner(1 - scrollY / (screenHeight / 3f));
            }
        }
    }
}
