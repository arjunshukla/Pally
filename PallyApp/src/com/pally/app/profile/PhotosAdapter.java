package com.pally.app.profile;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pally.app.R;

public class PhotosAdapter extends RecyclerView.Adapter<ViewHolder> {

	public PhotosAdapter() {

	}

	@Override
	public int getItemCount() {

		return 20;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		if (viewHolder instanceof ItemViewHolder) {

		}
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.photos_view, viewGroup, false);
		ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
		return navigationViewHolder;
	}

	public class ItemViewHolder extends RecyclerView.ViewHolder implements
			OnClickListener {
		public ImageView mPhotosView;

		public ItemViewHolder(View view) {
			super(view);
			mPhotosView = (ImageView) view.findViewById(R.id.photos_view);
			mPhotosView.setOnClickListener(this);
			view.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {

		}

	}

}
