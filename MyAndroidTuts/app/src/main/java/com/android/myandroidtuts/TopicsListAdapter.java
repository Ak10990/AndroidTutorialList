package com.android.myandroidtuts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.android.myandroidtuts.TopicDetailActivity.TOPIC_EXTRA;

/**
 * Created by akanksha on 11/1/17.
 */
public class TopicsListAdapter extends RecyclerView.Adapter<TopicsListAdapter.ViewHolder> {

    private Context mContext;
    private List<Topic> mList;

    public TopicsListAdapter(Context context, List<Topic> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Topic topic = mList.get(position);
        holder.itemName.setText(Html.fromHtml(topic.getHead()));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemName;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            itemName = (TextView) view.findViewById(R.id.item_name);
        }

        @Override
        public void onClick(View view) {
            int position = (int) itemView.getTag();
            Topic topic = mList.get(position);
            Intent intent = new Intent(mContext, TopicDetailActivity.class);
            intent.putExtra(TOPIC_EXTRA, topic);
            mContext.startActivity(intent);
        }
    }
}
