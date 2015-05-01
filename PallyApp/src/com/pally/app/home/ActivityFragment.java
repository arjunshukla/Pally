package com.pally.app.home;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pally.app.R;

public class ActivityFragment extends Fragment {

	private Toolbar mToolBar;
	private HomeActivity mHomeActivity;
	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_activity, container, false);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mHomeActivity = (HomeActivity) activity;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mToolBar = (Toolbar) view.findViewById(R.id.toolbar);
		mToolBar.setNavigationIcon(R.drawable.menu);
		mToolBar.setTitle("Activity");
		mToolBar.setTitleTextColor(Color.WHITE);
		mToolBar.setNavigationOnClickListener(onToolBarClickListner);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);
		ActivityAdapter activityAdapter = new ActivityAdapter();
		mRecyclerView.setAdapter(activityAdapter);

	}

	private View.OnClickListener onToolBarClickListner = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			mHomeActivity.mDrawerLayout.openDrawer(Gravity.START);
		}
	};
}