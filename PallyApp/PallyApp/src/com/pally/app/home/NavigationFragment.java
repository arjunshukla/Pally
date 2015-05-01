package com.pally.app.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pally.app.PallyContatns;
import com.pally.app.R;
import com.pally.app.basic.BaseActivity;
import com.pally.app.basic.BasicActivity;
import com.pally.app.chat.ChatFragment;
import com.pally.app.friends.FriendsFragment;
import com.pally.app.home.NavigationAdapter.OnNavigationItemClickLisnter;
import com.pally.app.notification.NotificationFragment;
import com.pally.app.profile.ProfileFragment;
import com.pally.app.search.SearchFragment;
import com.pally.app.settings.SettingsFragment;

public class NavigationFragment extends Fragment implements
		OnNavigationItemClickLisnter {

	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private NavigationAdapter navigationAdapter;
	private HomeActivity mHomeActivity;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_navigation, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);
		navigationAdapter = new NavigationAdapter();
		navigationAdapter.setNavigationClickListner(this);
		mRecyclerView.setAdapter(navigationAdapter);

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mHomeActivity = (HomeActivity) activity;
	}

	@Override
	public void onNavigationItemClicked(int position) {

		if (position == 1) {
			mHomeActivity.mDrawerLayout.closeDrawers();
			((BaseActivity) getActivity()).addNewFragment(R.id.content_frame,
					new ActivityFragment(), false,
					PallyContatns.ACTIVITY_FRAGMENT);
		}

		if (position == 2) {
			mHomeActivity.mDrawerLayout.closeDrawers();
			((BaseActivity) getActivity()).addNewFragment(R.id.content_frame,
					new ProfileFragment(), false,
					PallyContatns.PROFILE_FRAGMENT);
		}
		if (position == 3) {
			mHomeActivity.mDrawerLayout.closeDrawers();
			((BaseActivity) getActivity()).addNewFragment(R.id.content_frame,
					new FriendsFragment(), false,
					PallyContatns.FRIENDS_FRAGMENT);
		}
		if (position == 4) {
			mHomeActivity.mDrawerLayout.closeDrawers();
			((BaseActivity) getActivity()).addNewFragment(R.id.content_frame,
					new ChatFragment(), false, PallyContatns.CHAT_FRAGMENT);
		}
		if (position == 5) {
			mHomeActivity.mDrawerLayout.closeDrawers();
			((BaseActivity) getActivity()).addNewFragment(R.id.content_frame,
					new SearchFragment(), false, PallyContatns.SEARCH_FRAGMENT);
		}
		if (position == 6) {
			mHomeActivity.mDrawerLayout.closeDrawers();
			((BaseActivity) getActivity()).addNewFragment(R.id.content_frame,
					new NotificationFragment(), false,
					PallyContatns.NOTIFICATION_FRAGMENT);
		}

		if (position == 7) {
			mHomeActivity.mDrawerLayout.closeDrawers();
			((BaseActivity) getActivity()).addNewFragment(R.id.content_frame,
					new SettingsFragment(), false,
					PallyContatns.SETTINGS_FRAGMENT);
		}
		if (position == 8) {
			startActivity(new Intent(getActivity(), BasicActivity.class));
			getActivity().finish();
		}

	}

}
