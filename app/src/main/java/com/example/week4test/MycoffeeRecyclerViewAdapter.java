package com.example.week4test;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4test.CoffeeListFragment.OnListFragmentInteractionListener;
import com.example.week4test.dummy.DummyContent.DummyItem;
import com.example.week4test.model.datasource.coffee.CoffeeResponse;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MycoffeeRecyclerViewAdapter extends RecyclerView.Adapter<MycoffeeRecyclerViewAdapter.ViewHolder> {
    CoffeeResponse coffeeResponse;
    List<CoffeeResponse> mValues = null;
    private final OnListFragmentInteractionListener mListener;

    public MycoffeeRecyclerViewAdapter(CoffeeResponse items, OnListFragmentInteractionListener listener) {
        coffeeResponse = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_coffee, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.nameList.setText(mValues.get(position).getName());
        holder.descList.setText(mValues.get(position).getDesc());
        Glide.with(holder.coffeeImageList).load(mValues.get(position).getImageUrl());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameList;
        public final TextView descList;
        public final ImageView coffeeImageList;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            nameList =  view.findViewById(R.id.tvNameList);
            descList =  view.findViewById(R.id.tvSDescList);
            coffeeImageList = view.findViewById(R.id.imgCoffeeList);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
