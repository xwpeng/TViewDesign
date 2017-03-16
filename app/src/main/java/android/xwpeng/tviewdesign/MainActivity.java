package android.xwpeng.tviewdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.xwpeng.tviewdesign.ui.FingerMoveActivity;
import android.xwpeng.tviewdesign.ui.DispatchActivity;
import android.xwpeng.tviewdesign.ui.ScollActivity;
import android.xwpeng.tviewdesign.ui.ScollConflictActivity;

/**
 * Created by xwpeng on 16-12-23.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_t_dispath).setOnClickListener(this);
        findViewById(R.id.main_t_scoll_conflict).setOnClickListener(this);
        findViewById(R.id.main_t_custom_view).setOnClickListener(this);
        findViewById(R.id.main_scoll_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_t_dispath:
                startActivity(new Intent(MainActivity.this, DispatchActivity.class));
                break;
            case R.id.main_t_scoll_conflict:
                startActivity(new Intent(MainActivity.this, ScollConflictActivity.class));
                break;
            case R.id.main_t_custom_view:
                startActivity(new Intent(MainActivity.this, FingerMoveActivity.class));
                break;
            case R.id.main_scoll_view:
                startActivity(new Intent(MainActivity.this, ScollActivity.class));
                break;
        }
    }
}
