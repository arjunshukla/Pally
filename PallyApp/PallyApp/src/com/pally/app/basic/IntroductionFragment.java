package com.pally.app.basic;

import com.pally.app.PallyContatns;
import com.pally.app.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class IntroductionFragment extends Fragment implements OnClickListener {

	private Button mLoginButton, mSignUpButton;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_introduction, container,
				false);

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mLoginButton = (Button) view.findViewById(R.id.login);
		mSignUpButton = (Button) view.findViewById(R.id.signup);
		mLoginButton.setOnClickListener(this);
		mSignUpButton.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v == mLoginButton) {
			((BaseActivity) getActivity()).addNewFragment(R.id.basic_container,
					new LoginFragment(), true, PallyContatns.LOGIN_FRAGMENT);
		}

		if (v == mSignUpButton) {
			((BaseActivity) getActivity()).addNewFragment(R.id.basic_container,
					new SignUpFragment(), true, PallyContatns.SIGUNP_FRAGMENT);
		}
	}

}
