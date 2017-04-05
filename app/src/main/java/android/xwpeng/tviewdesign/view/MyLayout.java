package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.xwpeng.tviewdesign.util.SystemUtil;

/**
 * Created by xwpeng on 16-12-21.
 * 自定义linearlayout
 */

public class MyLayout extends LinearLayout {
    private final static String TAG = "MyLayout";
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean a = super.dispatchTouchEvent(ev);
        Log.d(TAG, "dispatchTouchEvent " + SystemUtil.getEventName(ev.getAction()) + " return: " + a);
        return a;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean a = super.onInterceptTouchEvent(ev);
/*   h     boolean a = false;
        if (ev.getAction() == 0) {
            a = true;
        }*/
/*        boolean a = false;
        if (ev.getAction() == 2) {
            a = true;
        }*/
//        boolean a = true;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        Log.d(TAG, "onInterceptTouchEvent " + SystemUtil.getEventName(ev.getAction()) + " return: " + a);
        return a;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean a = super.onTouchEvent(event);
        Log.d(TAG, "onTouchEvent " + SystemUtil.getEventName(event.getAction()) + " return: " + a);
        return a;
    }


}
