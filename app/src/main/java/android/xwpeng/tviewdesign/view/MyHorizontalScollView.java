package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by xwpeng on 16-12-23.
 * 自定义水平滑动View
 */

public class MyHorizontalScollView extends ViewGroup {

    public MyHorizontalScollView(Context context) {
        super(context);
        init();
    }

    public MyHorizontalScollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyHorizontalScollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyHorizontalScollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private float mRawX, mRawY;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;

    //分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;
    //分别记录上次滑动的坐标(onInterceptTounchEvent)
    private int mLastXIntercept;
    private int mLastYIntercept;


    private void init() {
        if (mScroller == null) {
            mScroller = new Scroller(getContext());
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthWrap = 0;
        int heightWrap = 0;
        int childCount = getChildCount();
        int widthUsed;
        int heightUsed;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            MarginLayoutParams p = (MarginLayoutParams) childView.getLayoutParams();
            if (childView.getVisibility() != View.GONE) {
                //支持padding与子ViewMargin
                widthUsed = widthWrap + getPaddingLeft() + getPaddingRight() + p.leftMargin + p.rightMargin;
                heightUsed = heightWrap + getPaddingTop() + getPaddingBottom() + p.topMargin + p.bottomMargin;
                measureChildWithMargins(childView, widthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed);
                widthWrap = widthWrap + childView.getMeasuredWidth() + getPaddingTop() + getPaddingBottom();
                heightWrap = heightWrap + childView.getMeasuredHeight() + getPaddingRight() + getPaddingLeft();
            }
        }
        //处理wrap_content问题
        if (widthMeasureMode == MeasureSpec.AT_MOST && heightMeasureMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthWrap, heightWrap);
        } else if (widthMeasureMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthWrap, heightMeasureSize);
        } else if (heightMeasureMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthMeasureSize, heightWrap);
        } else {
            setMeasuredDimension(widthMeasureSize, heightMeasureSize);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //处理padding,位置只要看top与left即可
        int top = getPaddingTop();
        int left = getPaddingLeft();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() != View.GONE) {
                int childWidth = childView.getMeasuredWidth();
                int childHeight = childView.getMeasuredHeight();
                LayoutParams lp = (LayoutParams) childView.getLayoutParams();
                //处理子View的Margin
                int right = left + lp.topMargin + childWidth;
                int bottom = top + lp.leftMargin + childHeight;
                childView.layout(left, top, right, bottom);
                top = right;
                left = bottom;
            }
        }
    }

/*    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
*//*        // 外部拦截方法一：
        float rawX = ev.getRawX();
        float rawY = ev.getRawY();
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            boolean intercepted = Math.abs(rawX - mRawX) > Math.abs(rawY - mRawY);
            return intercepted;
        }
        mRawX = rawX;
        mRawY = rawY;
        mLastX = (int)rawX;
        mLastY = (int)rawY;
        return super.onInterceptTouchEvent(ev);*//*
      *//*
       //外部拦截方法二：
       boolean intercepted = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercepted = false;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                    intercepted = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                intercepted = Math.abs(deltaX) > Math.abs(deltaY);
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
        }
        mLastX = x;
        mLastY = y;
        mLastXIntercept = x;
        mLastYIntercept = y;
        return intercepted;*//*
        //内部拦截父View需要的代码
        mLastX = (int) ev.getRawX();
        mLastY = (int) ev.getRawY();
        if (MotionEvent.ACTION_DOWN == ev.getAction()) {
            if (!mScroller.isFinished()) {
                mScroller.abortAnimation();
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mVelocityTracker.addMovement(event);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                scrollBy(-deltaX, 0);
                break;
            case MotionEvent.ACTION_UP:
                //回弹效果?
//                int scollX = getScrollX();
//                mVelocityTracker.computeCurrentVelocity(1000);
//                float xVelocity = mVelocityTracker.getXVelocity();
//                if (Math.abs(xVelocity) > 50) {
//                    mChildIndex = xVelocity > 0 ? mChildIndex - 1 : mChildIndex + 1;
//                } else {
//                    mChildIndex = (scollX + mChildWidth / 2) / mChildWidth;
//                }
//                mChildIndex = Math.max(0, Math.min(mChildIndex, mChildSize -1));
//                int dx = mChildIndex * mChildWidth - scollX;
//                smoothScrollBy(dx , 0);
//                mVelocityTracker.clear();
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }

    private void smoothScrollBy(int dx, int dy) {
        mScroller.startScroll(getScrollX(), 0, dx, 500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mVelocityTracker.recycle();
        super.onDetachedFromWindow();
    }*/

    @Override
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public android.view.ViewGroup.LayoutParams generateLayoutParams(
            AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(
            android.view.ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity = -1;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
/*
            TypedArray ta = c.obtainStyledAttributes(attrs,
                    R.styleable.MyHorizontalScollView);

            gravity = ta.getInt(R.styleable.MyHorizontalScollView_layout_gravity, -1);

            ta.recycle();*/
            // TODO: 17-3-31
        }

        public LayoutParams(int width, int height) {
            this(width, height, -1);
        }

        public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.gravity = gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }
    }

}
