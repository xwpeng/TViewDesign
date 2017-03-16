package android.xwpeng.tviewdesign.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.xwpeng.tviewdesign.R;
import android.xwpeng.tviewdesign.ui.adapter.SimpleAdapter;
import android.xwpeng.tviewdesign.view.MyRecyclerView;
import android.xwpeng.tviewdesign.view.MyScollView;

/**
 * Created by xwpeng on 16-12-23.
 * 测试滑动冲突
 */

public class ScollConflictActivity extends AppCompatActivity {
    private MyScollView mMyScollView;
    private RecyclerView mRecyclerView;
    private MyRecyclerView mMyRecyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoll_conflict);
        mMyScollView = (MyScollView) findViewById(R.id.t_scoll_conflict_myscollview);
       /* mRecyclerView = (RecyclerView) findViewById(R.id.t_scoll_conflict_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new SimpleAdapter());*/
        mMyRecyclerView = (MyRecyclerView) findViewById(R.id.t_scoll_conflict_recyclerview);
        mMyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyRecyclerView.setAdapter(new SimpleAdapter());
    }
}
