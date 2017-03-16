//package android.xwpeng.teventdispath.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.widget.LinearLayout;
//
///**
// * Created by xwpeng on 17-3-1.
// */
//
//public class StickyLayout extends LinearLayout {
//    private final static String TAG = "StickyLayout";
//    public StickyLayout(Context context) {
//        super(context);
//    }
//
//    public StickyLayout(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public StickyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    public StickyLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
//
//    private int mTouchSlop;
//    private int mLastX;
//    private int mLastY;
//    private int mLastXIntercept;
//    private int mLastYIntercept;
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        int intercepted = 0;
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                mLastXIntercept = x;
//                mLastYIntercept = y;
//                mLastX = x;
//                mLastY = y;
//                intercepted = 0;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int deltaX = x - mLastXIntercept;
//                int deltaY = y - mLastYIntercept;
//                if (mDisallowInterceptTouchEventOnHeader && y <= getHeader - getHeight()) {
//                    intercepted = 0;
//                }else if (Math.abs(deltaY) <= Math.abs(deltaX)) {
//                    intercepted = 0;
//                } else if (mStatus == STATUS_EXPANDED && deltaY <= -mTouchSlop) {
//                    intercepted = 1;
//                } else if (mGiveUpouchEventListener != null) {
//                    if (mGiveUpouchEventListener.giveUpTouchEvent(ev) && deltaY >= mTouchSlop) {
//                        intercepted = 1;
//                    }
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                intercepted = 0;
//                mLastXIntercept = mLastYIntercept = 0;
//                break;
//        }
//        Log.d(TAG, "intercepted: " + intercepted);
//        return intercepted != 0 && mIsSticky;
//    }
//
//    //据说是Ａｎｄｒｏｉd会支持鼠标功能，４.0加的。这个是鼠标事件的分发
//   @Override
//    public boolean onInterceptHoverEvent(MotionEvent event) {
//        return super.onInterceptHoverEvent(event);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (! mIsSticky) {
//            return true;
//        }
//        int x = (int)event.getX();
//        int y = (int)event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_MOVE:
//            int deltaX = x - mLastX;
//            int deltaY = y - mLastY;
//                mHeaderHeight += deltaY;
//                .....
//                break;
//            case MotionEvent.ACTION_UP:
//                int destHeight = 0;
//                if (mHeaderHeight <= mOriginalHeaderHeight * 0.5) {
//                    destHeight = 0;
//                    mStatus = STATUS_COLLAPSED;
//                } else {
//                    destHeight = mOriginalHeaderHeight;
//                    mStatus = STATUS_EXPANDED;
//                }
//                this.smoothSetHaderHeight(mHeaderHeight, destHeight, 500);
//                break;
//        }
//        mLastX = x;
//        mLastY = y;
//        return true;
//    }
//}
