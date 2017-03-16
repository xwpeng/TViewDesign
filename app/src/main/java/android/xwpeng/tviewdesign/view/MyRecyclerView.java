package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by xwpeng on 17-2-27.
 */

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private float mLastX;
    private float mLastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float x = ev.getRawX();
        float y = ev.getRawY();
        if (MotionEvent.ACTION_DOWN == ev.getAction()) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (MotionEvent.ACTION_MOVE == ev.getAction()) {
            if (Math.abs(mLastY - y) < Math.abs(mLastX - x)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            //todo　下面这样写不行,不知道为什么
      /*      if (Math.abs(mLastY - y) > Math.abs(mLastX - x)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }*/
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

}
