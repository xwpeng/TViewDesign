package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.xwpeng.tviewdesign.util.SystemUtil;

/**
 * Created by xwpeng on 16-12-21.
 * 自定义button
 */

public class MyButton extends Button {

    public String TAG = "MyButton";

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setTag(String tag) {
        TAG  = tag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean a = false;
//        if (0 != event.getAction()) {
//            a = super.onTouchEvent(event);
//        }
//        a = super.onTouchEvent(event);
/*        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                a = false;
                break;
            default:
                a = true;
                break;
        }*/
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                a = false;
                break;
            default:
                a = super.onTouchEvent(event);
                break;
        }
            Log.d(TAG, "onTouchEvent " + SystemUtil.getEventName(event.getAction()) + " return: " + a);
            return a;
        }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
            boolean a = false;
            a = super.dispatchTouchEvent(event);
            Log.d(TAG, "dispatchTouchEvent " + SystemUtil.getEventName(event.getAction()) + " return: " + a);
            return a;
        }
}