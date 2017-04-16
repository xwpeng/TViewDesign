package android.xwpeng.tviewdesign.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.xwpeng.tviewdesign.R;

/**
 * 测试自定义view,主要是View的绘制
 * Created by xwpeng on 16-12-27.
 */

public class CustomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
 /*       findViewById(R.id.coustomview_finger_move_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FingerMoveActivity.this, "as", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
