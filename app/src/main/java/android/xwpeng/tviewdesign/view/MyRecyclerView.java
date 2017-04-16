package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

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
    private boolean slop;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float x = ev.getRawX();
        float y = ev.getRawY();
        if (MotionEvent.ACTION_DOWN == ev.getAction()) {
            getParent().requestDisallowInterceptTouchEvent(true);
            slop = false;
        }
        if (MotionEvent.ACTION_MOVE == ev.getAction()) {
            if (Math.abs(mLastY - y) < Math.abs(mLastX - x)) {
                if (!slop) getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                int touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                if (Math.abs(y - mLastY) > touchSlop) {
                    //已经开始了竖向滑动
                    slop = true;
                }
            }
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

}
