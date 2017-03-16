package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * 跟着手指移动
 * Created by xwpeng on 16-12-29.
 */

public class FingerMoveView extends View implements GestureDetector.OnGestureListener {
    public FingerMoveView(Context context) {
        super(context);
        init();
    }

    public FingerMoveView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public FingerMoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public FingerMoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private int mLastX;
    private int mLastY;
    private GestureDetector mGestureDetector;

    private void init() {
        if (mGestureDetector == null) {
            mGestureDetector = new GestureDetector(this);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
              /*
               //1.利用属性动画实现
               ObjectAnimator.ofFloat(this, "translationX", 0, x).setDuration(100).start();
                ObjectAnimator.ofFloat(this, "translationY", 0, y).setDuration(100).start();*/
          /*
            //2.利用translation实现
                setTranslationX(getTranslationX() + x - mLastX);
                setTranslationY(getTranslationY() + y - mLastY);*/
                //利用margin实现,会影响其他view
                ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) getLayoutParams();
                p.leftMargin = p.leftMargin + x - mLastX;
                p.topMargin = p.topMargin + y - mLastY;
//                setLayoutParams(p);
                requestLayout();
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }
}
