package com.pally.app.basic;

import android.os.Bundle;

import com.pally.app.PallyContatns;
import com.pally.app.R;

public class BasicActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic);
		addNewFragment(R.id.basic_container, new SplashFragment(), false,
				PallyContatns.SPLASH_FRAGMENT);
	}
	

}
