package android.xwpeng.tviewdesign.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.xwpeng.tviewdesign.R;

/**
 *  测试View滑动
 * Created by xwpeng on 17-2-20.
 *
 */

public class ScollActivity extends AppCompatActivity {
    private ScrollView mScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoll);
        mScrollView = (ScrollView) findViewById(R.id.scroll_view);

        mScrollView.post(new Runnable() {
            @Override
            public void run() {
                //scoll方法，移动View中内容
//                mScrollView.scrollTo(1000, 1000);
                //动画方法
                // View动画
    //                Animation animation = AnimationUtils.loadAnimation(ScollActivity.this, R.anim.anim_scoll_view);
    //                mScrollView.setAnimation(animation);
                //属性动画
//                ObjectAnimator.ofFloat(mScrollView, "translationX", 0, 100).setDuration(1000).start();
//改变LayoutParams
                ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) mScrollView.getLayoutParams();
                p.width += 100;
                p.leftMargin += 100;
                mScrollView.requestLayout();

            }
        });


    }
}
