package android.xwpeng.tviewdesign.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.xwpeng.tviewdesign.R;

/**
 * Created by xwpeng on 16-12-27.
 * 圆形的自定义View
 */

public class CircleView extends View {
    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView, defStyleAttr, 0);
        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.RED);
        mRadius = a.getDimension(R.styleable.CircleView_circle_radius, 0);
        mWrapWidth = mWrapHeight = 2 * (int)mRadius;
        a.recycle();
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private Paint mPaint;
    private int mColor = Color.parseColor("#ff0000");
    private float mRadius;
    private int mWrapWidth;
    private int mWrapHeight;
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**draw
         * 1.绘制背景background.draw(canvas)
         * 3.绘制自己onDraw
         * 4.绘制children(dispatchDraw)
         * 6.绘制装饰(onDrawScrollBars)
         */
        int width = getWidth();
        int height = getHeight();
        //padding处理
        int sizeLimit = Math.min(width - getPaddingTop() - getPaddingBottom(), height - getPaddingLeft() - getPaddingRight()) / 2;
        mRadius =  mRadius == 0 ? sizeLimit : mRadius;
        mRadius = Math.min(sizeLimit, mRadius);
        canvas.drawCircle(width / 2, height /2 , mRadius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 处理wrap的默认宽高
         */
        int  widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int  widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);
        int  heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int  heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);
       if (widthMeasureMode == MeasureSpec.AT_MOST && heightMeasureMode == MeasureSpec.AT_MOST) {
           //设置成默认的大小
           setMeasuredDimension(mWrapWidth, mWrapHeight);
       } else if (widthMeasureMode == MeasureSpec.AT_MOST) {
           setMeasuredDimension(mWrapWidth, heightMeasureSize);
       } else if(heightMeasureMode == MeasureSpec.AT_MOST) {
           setMeasuredDimension(widthMeasureSize, mWrapHeight);
       }
    }

}
