package com.pally.app.home;

import com.pally.app.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ShareFeedsFragment extends Fragment {

	private ViewSwitcher mViewSwitcher;
	private TextView mUpdateStatusText, mUploadPicText;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_share_feed, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mViewSwitcher = (ViewSwitcher) view.findViewById(R.id.status_container);
		mUpdateStatusText = (TextView) view
				.findViewById(R.id.update_status_text);
		mUpdateStatusText.setClickable(true);
		mUpdateStatusText.setOnClickListener(mClickedOnStatus);

		mUploadPicText = (TextView) view.findViewById(R.id.upload_photos_text);
		mUploadPicText.setClickable(true);
		mUploadPicText.setOnClickListener(mClickedOnUploadPics);

	}

	private View.OnClickListener mClickedOnStatus = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			mViewSwitcher.showNext();
			
		}
	};

	private View.OnClickListener mClickedOnUploadPics = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			mViewSwitcher.showNext();
		}
	};
}
