package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 用于测试滑动冲突竖向滑动与RecyclerView列表侧滑
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
            //下面这样写不行　在ACIION_DOWN事件的时候，已经调用requestDisallowInterceptTouchEvent设置标记位为true,
            // 看源码知，之后事件序列的其他事件父View都不会判断是否要拦截，直接将intercepted设置为false.
            // 这个时候想要父View去处理滑动事件，只有调用requestDisallowInterceptTouchEvent(false)改变标记位的值为false.
      /*      if (Math.abs(mLastY - y) > Math.abs(mLastX - x)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }*/
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

}
