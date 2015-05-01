package com.pally.app.home;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.pally.app.PallyContatns;
import com.pally.app.R;
import com.pally.app.basic.BaseActivity;

public class HomeActivity extends BaseActivity {

	public DrawerLayout mDrawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		addNewFragment(R.id.content_frame, new ActivityFragment(), false,
				PallyContatns.ACTIVITY_FRAGMENT);
	}

	
	@Override
	public void onBackPressed() {
		mDrawerLayout.openDrawer(Gravity.START);
	}
}
