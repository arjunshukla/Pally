package com.pally.app.search;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pally.app.R;
import com.pally.app.customview.RoundedImageView;

public class SearchResultAdapter extends RecyclerView.Adapter<ViewHolder>{


	public SearchResultAdapter() {

	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int arg1) {
		if (viewHolder instanceof ItemViewHolder) {

		}

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.search_result_view, viewGroup, false);
		ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
		return navigationViewHolder;
	}


	public class ItemViewHolder extends RecyclerView.ViewHolder implements
	OnClickListener {
		public RoundedImageView mPhotosView;

		public ItemViewHolder(View view) {
			super(view);
			mPhotosView = (RoundedImageView) view.findViewById(R.id.search_result_view);
			mPhotosView.setOnClickListener(this);
			view.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {

		}

	}
	
	
}
