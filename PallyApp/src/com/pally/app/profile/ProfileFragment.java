package com.pally.app.profile;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pally.app.R;
import com.pally.app.customview.ChangeColorListner;
import com.pally.app.customview.SlidingTabLayout;

public class ProfileFragment extends Fragment implements ChangeColorListner {

	
	private SlidingTabLayout mSlidingTabLayout;
	private ViewPager mViewPager;
	private List<SamplePagerItem> mTabs = new ArrayList<SamplePagerItem>();

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_profile, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		addTabs();
		mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
		mViewPager.setAdapter(new SampleFragmentPagerAdapter(getActivity()
				.getSupportFragmentManager()));
		mSlidingTabLayout = (SlidingTabLayout) view
				.findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setDistributeEvenly(true);
		mSlidingTabLayout.setViewPager(mViewPager);
		mSlidingTabLayout.setColorChangeListner(this);

	}
	
	private void addTabs() {
		mTabs.add(new SamplePagerItem(getString(R.string.app_name), // Title
				Color.BLACK, // Indicator color
				Color.WHITE // Divider color
				, 0));

		mTabs.add(new SamplePagerItem(getString(R.string.app_name), // Title
				Color.BLACK, // Indicator color
				Color.WHITE // Divider color
				, 1));
		
		mTabs.add(new SamplePagerItem(getString(R.string.app_name), // Title
				Color.BLACK, // Indicator color
				Color.WHITE // Divider color
				, 2));


	}
	
	
	

	@Override
	public void onChangeColorCompleted(int i) {

	}
	
	class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

		SampleFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			return mTabs.get(i).createFragment();
		}

		@Override
		public int getCount() {
			return mTabs.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTabs.get(position).getTitle();
		}

	}

	static class SamplePagerItem {
		// Note: Your consumer key and secret should be obfuscated in your
		// source code before shipping.

		private final CharSequence mTitle;
		private final int mIndicatorColor;
		private final int mDividerColor;
		private final int mPosition;

		SamplePagerItem(CharSequence title, int indicatorColor,
				int dividerColor, int position) {
			mTitle = title;
			mIndicatorColor = indicatorColor;
			mDividerColor = dividerColor;
			mPosition = position;
		}

		/**
		 * @return A new {@link Fragment} to be displayed by a {@link ViewPager}
		 */
		Fragment createFragment() {
			if (mPosition == 0) {
				return new PostsFragment();
			} else if (mPosition == 1) {
				return new AboutMeFragment();
			} else {
				return new PhotosFragment();
			}
		}

		/**
		 * @return the title which represents this tab. In this sample this is
		 *         used directly by
		 *         {@link android.support.v4.view.PagerAdapter#getPageTitle(int)}
		 */
		CharSequence getTitle() {
			return mTitle;
		}

		/**
		 * @return the color to be used for indicator on the
		 *         {@link SlidingTabLayout}
		 */
		int getIndicatorColor() {
			return mIndicatorColor;
		}

		/**
		 * @return the color to be used for right divider on the
		 *         {@link SlidingTabLayout}
		 */
		int getDividerColor() {
			return mDividerColor;
		}
	}

}
