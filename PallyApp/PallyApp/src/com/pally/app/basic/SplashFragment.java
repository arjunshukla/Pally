package com.pally.app.basic;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pally.app.PallyContatns;
import com.pally.app.R;

public class SplashFragment extends Fragment {

	private static int SPLASH_TIME_OUT = 1000;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_splash, container, false);

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initApp();
	}

	private void initApp() {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				((BaseActivity) getActivity()).addNewFragment(
						R.id.basic_container, new IntroductionFragment(),
						false, PallyContatns.INTRODUCTION_FRAGMENT);
			}
		}, SPLASH_TIME_OUT);
	}

}
