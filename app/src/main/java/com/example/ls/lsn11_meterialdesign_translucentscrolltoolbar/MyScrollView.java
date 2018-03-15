package com.example.ls.lsn11_meterialdesign_translucentscrolltoolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by 路很长~ on 2018/3/13.
 */

public class MyScrollView extends ScrollView {
    public interface TranslucentListener {
        /**
         * 透明度的回调
         *
         * @param alpha 0-1的透明度
         */
        void TranslucentTobar(float alpha);
    }
    private TranslucentListener mTranslucentLisenner;
    public void setTransluListenner(TranslucentListener mTranslucentLisenner){
        this.mTranslucentLisenner=mTranslucentLisenner;
    }
    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mTranslucentLisenner!=null){
            int scrollY=getScrollY();//花出去的高度
            int heightPixels=getContext().getResources().getDisplayMetrics().heightPixels;//屏幕高度
            if(scrollY<=heightPixels/3) {
                mTranslucentLisenner.TranslucentTobar(1-scrollY/(heightPixels/3f));//alpha=滑出去的高度/(screen_height/3f);
            }
        }
    }
}
