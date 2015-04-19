package com.pally.app.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pally.app.R;

public class AboutMeFragment extends Fragment {

	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private AboutMeAdapter aboutMeAdapter;
	public static String[] mUserProfileHeader = { "Birth Date:", "Gender:",
			"Country:", "City:", "Language:", "About:" };

	public static String[] mUserProfileInfo = { "April 12 1989", "Female",
			"London", "San Francisco", "English, Mandarin, Cantonese",
			"I love to travel and make new friends and want to do lot of acting" };

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_about, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);
		aboutMeAdapter = new AboutMeAdapter();
		mRecyclerView.setAdapter(aboutMeAdapter);

	}
}
