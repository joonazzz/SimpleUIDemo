package com.example.joonas.simpleuidemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * Created by joonas on 17.11.2017.
 *
 * Simple StringListAdapter for RecyclerView.
 */

public class StringListAdapter extends RecyclerView.Adapter<StringListAdapter.CustomViewHolder> {

    public interface ItemClickListener {
        void onItemClicked(int position);
    };

    private String[] mListData;
    private ItemClickListener mOnClickListener;


    public StringListAdapter(String[] stringList) {
        mListData = stringList;
    }

    public void setOnItemClickListener(ItemClickListener l){
        mOnClickListener = l;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.string_list_row, null);
        final CustomViewHolder viewHolder = new CustomViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(mOnClickListener != null){
                    int position = viewHolder.getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        mOnClickListener.onItemClicked(viewHolder.getAdapterPosition());
                    }
                    else{
                        // Item has been removed from adapter, but UI was not updated yet
                    }
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        customViewHolder.textView.setText(mListData[i]);
    }

    @Override
    public int getItemCount() {
        return mListData.length;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.tv_string_list);
        }
    }
}