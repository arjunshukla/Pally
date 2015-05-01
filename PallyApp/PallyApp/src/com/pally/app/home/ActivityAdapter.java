package com.pally.app.home;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.pally.app.R;

public class ActivityAdapter extends RecyclerView.Adapter<ViewHolder> {

	private static int VIEW_SINGLE_PICTURE = 1;
	private static int VIEW_SINGLE_STATUS = 2;
	private static int VIEW_MULTIPLE_PICTURE = 3;

	public ActivityAdapter() {

	}

	@Override
	public int getItemCount() {

		return 10;
	}

	@Override
	public int getItemViewType(int position) {

		if (position == 1) {
			return VIEW_SINGLE_PICTURE;
		} else if (position == 2) {
			return VIEW_MULTIPLE_PICTURE;
		} else {
			return VIEW_SINGLE_STATUS;
		}

	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		if (viewHolder instanceof ItemViewHolder) {

		}

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

		if (viewType == VIEW_SINGLE_PICTURE) {
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(
					R.layout.single_pic_view, viewGroup, false);
			ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
			return navigationViewHolder;
		}

		if (viewType == VIEW_MULTIPLE_PICTURE) {
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(
					R.layout.multiple_pic_view, viewGroup, false);
			ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
			return navigationViewHolder;
		}

		if (viewType == VIEW_SINGLE_STATUS) {
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(
					R.layout.single_text_view, viewGroup, false);
			ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
			return navigationViewHolder;
		}

		return null;
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

	public interface OnActivityItemClickLisnter {

		public void onActivityItemClicked(int position);

	}

}
