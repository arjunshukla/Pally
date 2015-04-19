package com.pally.app.friends;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pally.app.R;

public class FriendsRequestFragment extends Fragment {

	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private AllFriendsAdapter allFriendsAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater
				.inflate(R.layout.fragment_all_friends, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);
		allFriendsAdapter = new AllFriendsAdapter();
		mRecyclerView.setAdapter(allFriendsAdapter);
	}
}
