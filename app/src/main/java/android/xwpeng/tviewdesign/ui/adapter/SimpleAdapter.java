package android.xwpeng.tviewdesign.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.xwpeng.tviewdesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwpeng on 16-12-23.
 */

public class SimpleAdapter extends RecyclerView.Adapter {
    private List<String> mData;

    public SimpleAdapter() {
        mData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mData.add("测试数据: " + i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.itemTextview.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextview;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTextview = (TextView) itemView.findViewById(R.id.item_simple_textview);
        }
    }
}
