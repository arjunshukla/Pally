package com.pally.app;

import com.pally.app.R;
import com.pally.app.R.layout;

import android.app.Activity;
import android.os.Bundle;

public class PallyApplication extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}


	
}
