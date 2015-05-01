package com.pally.app.home;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pally.app.R;

public class NavigationAdapter extends RecyclerView.Adapter<ViewHolder> {

	private static int VIEW_HEADER = 0;
	private static int VIEW_NORMAL = 1;
	private OnNavigationItemClickLisnter itemClickLisnter;

	public static String[] mAppNavigationMenu = { "Dummy", "Activity",
			"Profile", "Friends", "Chat", "Pally Search", "Notification",
			"Settings", "Logout" };

	public NavigationAdapter() {

	}

	@Override
	public int getItemCount() {

		return mAppNavigationMenu.length;
	}

	@Override
	public int getItemViewType(int position) {

		if (position == 0) {
			return VIEW_HEADER;
		} else {
			return VIEW_NORMAL;
		}

	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		if (viewHolder instanceof ItemViewHolder) {
			((ItemViewHolder) viewHolder).mItemName.setText(""
					+ mAppNavigationMenu[position]);
		}

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		if (viewType == VIEW_HEADER) {
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(
					R.layout.navigation_header, viewGroup, false);
			HeaderViewHolder navigationViewHolder = new HeaderViewHolder(v);
			return navigationViewHolder;
		}

		if (viewType == VIEW_NORMAL) {
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(
					R.layout.navigation_item, viewGroup, false);
			ItemViewHolder navigationViewHolder = new ItemViewHolder(v);
			return navigationViewHolder;
		}

		return null;
	}

	public class HeaderViewHolder extends RecyclerView.ViewHolder implements
			OnClickListener {

		public HeaderViewHolder(View view) {
			super(view);
			view.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {

		}

	}

	public class ItemViewHolder extends RecyclerView.ViewHolder implements
			OnClickListener {
		public TextView mItemName;

		public ItemViewHolder(View view) {
			super(view);
			mItemName = (TextView) view.findViewById(R.id.navigation_item);
			mItemName.setOnClickListener(this);
			view.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			if (v == mItemName) {
				if (itemClickLisnter != null) {
					itemClickLisnter.onNavigationItemClicked(getPosition());
				}
			}

		}

	}

	public void setNavigationClickListner(
			OnNavigationItemClickLisnter itemClickLisnter) {
		this.itemClickLisnter = itemClickLisnter;
	}

	public interface OnNavigationItemClickLisnter {

		public void onNavigationItemClicked(int position);

	}

}
