package com.show.zyh.show_time.utils;

import android.graphics.Rect;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;

/**
 * 触摸委托工具类
 * Created by zyh(2422634506@qq.com)
 * 2017:13:43
 */

public class TouchDelegates {
    /**
     * 增加触屏面积
     * @param additional
     * @param view
     */
    public static void extendTouchRang(final  int additional , final View view ){
        //view
        view.post(new Runnable() {
            @Override
            public void run() {
                Rect rect=new Rect();
                view.getHitRect(rect);
                rect.left-=additional;
                rect.right+=additional;
                rect.top-=additional;
                rect.bottom+=additional;
                TouchDelegate touchDelegate=new TouchDelegate(rect,view);
                View parent= (View) view.getParent();
                if(parent instanceof View){
                    parent.setTouchDelegate(touchDelegate);
                }
            }
        });
    }
}
