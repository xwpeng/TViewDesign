package android.xwpeng.tviewdesign.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.xwpeng.tviewdesign.R;
import android.xwpeng.tviewdesign.view.MyButton;
import android.xwpeng.tviewdesign.view.MyLayout;

/**
 * 测试事件分发
 */
public class DispatchActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "t_dispatchActivity";
    private MyLayout mMyLayout;
    private MyButton mMyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_dispatch);
        mMyLayout = (MyLayout) findViewById(R.id.t_dispatch_mylayout);
        mMyLayout.setOnClickListener(this);
        mMyButton = (MyButton) findViewById(R.id.t_dispatch_mybutton);
        mMyButton.setOnClickListener(this);
        mMyButton.setTag("MyButton1");
//        mMyLayout.setEnabled(false);
//        mMyButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
////                boolean a = true;
//                boolean a = false;
//                Log.d(TAG, "onTouch " + SystemUtil.getEventName(event.getAction()) + " return: " + a);
//                return a;
//            }
//        });
//        mMyButton.setEnabled(false);
//        mMyButton.getParent().requestDisallowInterceptTouchEvent(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t_dispatch_mylayout:
                Toast.makeText(this, "myLayout clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.t_dispatch_mybutton:
                Toast.makeText(this, "myButton clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
