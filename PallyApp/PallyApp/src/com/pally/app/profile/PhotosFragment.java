package com.pally.app.profile;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pally.app.R;

public class PhotosFragment extends Fragment {

	private RecyclerView mRecyclerView;
	private GridLayoutManager mLayoutManager;
	private PhotosAdapter photosAdapter;
	private OnScrollHideListener hideListener;

	
	
	public PhotosFragment() {

	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	

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
		mRecyclerView.setOnScrollListener(new HidingScrollListener() {
			@Override
			public void onHide() {
				//hideListener.onHideFromFragmentToActivity();
			}

			@Override
			public void onShow() {
				//hideListener.onShowFraomFragmentToActivity();
			}
		});

		photosAdapter = new PhotosAdapter();
		mRecyclerView.setAdapter(photosAdapter);
		
		
	}
	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
	}


	public OnScrollHideListener getHideListener() {
		return hideListener;
	}


	public void setHideListener(OnScrollHideListener hideListener) {
		this.hideListener = hideListener;
	}
	
	

	

	
}
