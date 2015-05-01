package com.pally.app.profile;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pally.app.R;

public class AboutMeAdapter extends RecyclerView.Adapter<ViewHolder> {

	public AboutMeAdapter() {

	}

	@Override
	public int getItemCount() {

		return AboutMeFragment.mUserProfileInfo.length;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		if (viewHolder instanceof ItemViewHolder) {
			((ItemViewHolder) viewHolder).mItemHeader.setText(""
					+ AboutMeFragment.mUserProfileHeader[position]);

			((ItemViewHolder) viewHolder).mItemValue.setText(""
					+ AboutMeFragment.mUserProfileInfo[position]);

		}
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.about_me_tiem, viewGroup, false);
		ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
		return navigationViewHolder;
	}

	public class ItemViewHolder extends RecyclerView.ViewHolder implements
			OnClickListener {
		public TextView mItemHeader, mItemValue;

		public ItemViewHolder(View view) {
			super(view);
			mItemHeader = (TextView) view.findViewById(R.id.about_me_header);
			mItemHeader.setOnClickListener(this);

			mItemValue = (TextView) view.findViewById(R.id.about_me_value);
			mItemValue.setOnClickListener(this);
			view.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {

		}

	}

}
