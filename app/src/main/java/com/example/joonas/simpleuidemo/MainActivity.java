package com.example.joonas.simpleuidemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements StringListAdapter.ItemClickListener {

    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private StringListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] myDataset = {"Text Elements", "Widgets", "Layouts"};
    private Class<?>[] activities = {TextActivity.class, WidgetActivity.class, LayoutActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new StringListAdapter(myDataset);
        mAdapter.setOnItemClickListener(this);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }


    @Override
    public void onItemClicked(int position) {
        Log.d(TAG, "onItemClicked()");
        Log.d(TAG, "    position = " + position);

        Intent newActivity = new Intent(this,  activities[position]);
        startActivity(newActivity);

        Toast.makeText(this, myDataset[position], Toast.LENGTH_SHORT).show();
    }

}


