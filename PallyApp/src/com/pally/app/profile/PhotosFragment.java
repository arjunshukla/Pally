package com.pally.app.profile;

import com.pally.app.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhotosFragment extends Fragment {

	private RecyclerView mRecyclerView;
	private GridLayoutManager mLayoutManager;
	private PhotosAdapter photosAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_photos, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new GridLayoutManager(getActivity(), 3);
		mRecyclerView.setLayoutManager(mLayoutManager);
		photosAdapter = new PhotosAdapter();
		mRecyclerView.setAdapter(photosAdapter);

	}
}
