package com.pally.app.friends;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.pally.app.R;

public class AllFriendsAdapter extends RecyclerView.Adapter<ViewHolder> {

	public AllFriendsAdapter() {

	}

	@Override
	public int getItemCount() {

		return 20;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

		View v = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.friends_item_view, viewGroup, false);
		ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
		return navigationViewHolder;

	}

	public class ItemViewHolder extends RecyclerView.ViewHolder implements
			OnClickListener {

		public ItemViewHolder(View view) {
			super(view);
			view.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {

		}

	}

}
