package com.pally.app.search;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.pally.app.PallyContatns;
import com.pally.app.R;
import com.pally.app.basic.BaseActivity;
import com.pally.app.home.HomeActivity;

public class SearchFragment extends Fragment implements OnClickListener{

	private Toolbar mToolBar;
	private HomeActivity mHomeActivity;
	ImageButton gobutton;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_search, container,
				false);

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
		mToolBar.setTitle("Pally Search");
		mToolBar.setTitleTextColor(Color.WHITE);
		mToolBar.setNavigationOnClickListener(onToolBarClickListner);

		gobutton = (ImageButton) view.findViewById(R.id.gobutton);
		gobutton.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		((BaseActivity) getActivity()).addNewFragment(
				R.id.content_frame, new SearchResultFragment(),
				false, PallyContatns.SEARCH_RESULT_FRAGMENT);

	}

	private View.OnClickListener onToolBarClickListner = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			mHomeActivity.mDrawerLayout.openDrawer(Gravity.START);
		}
	};


}
