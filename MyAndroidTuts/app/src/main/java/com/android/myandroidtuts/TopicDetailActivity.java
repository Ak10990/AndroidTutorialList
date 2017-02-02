package com.android.myandroidtuts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by akanksha on 11/1/17.
 */
public class TopicDetailActivity extends AppCompatActivity {

    public static final String TOPIC_EXTRA = "TOPIC_EXTRA";
    private String detail = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        initValues();
        initViews();
    }

    private void initValues() {
        if (getIntent().hasExtra(TOPIC_EXTRA)) {
            detail = ((Topic) getIntent().getExtras().getParcelable(TOPIC_EXTRA)).getDetail();
        }
    }

    private void initViews() {
        TextView itemName = (TextView) findViewById(R.id.item_name);
        itemName.setText(Html.fromHtml(detail));
    }

}
