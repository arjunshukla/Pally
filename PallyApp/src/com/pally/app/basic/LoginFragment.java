package com.pally.app.basic;

import com.pally.app.PallyContatns;
import com.pally.app.R;
import com.pally.app.home.HomeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LoginFragment extends Fragment implements OnClickListener {

	private Button mDoLoginButton;
	private TextView mForgetPassword;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_login, container, false);

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mDoLoginButton = (Button) view.findViewById(R.id.loginButton);
		mDoLoginButton.setOnClickListener(this);

		mForgetPassword = (TextView) view
				.findViewById(R.id.forget_password_textview);
		mForgetPassword.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v == mDoLoginButton) {
			startActivity(new Intent(getActivity(), HomeActivity.class));
			getActivity().finish();
		}
		if (v == mForgetPassword) {
			((BaseActivity) getActivity()).addNewFragment(R.id.basic_container,
					new ForgetPasswordFragment(), true,
					PallyContatns.FORGET_PASSWORD_FRAGMENT);
		}

	}

}
