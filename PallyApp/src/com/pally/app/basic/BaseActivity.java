package com.pally.app.basic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

public class BaseActivity extends ActionBarActivity {

	public void addNewFragment(int container_id, Fragment fragmentToAdd,
			boolean allowBackStack, String fragmentTag) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.add(container_id, fragmentToAdd, fragmentTag);
		if (allowBackStack) {
			fragmentTransaction.addToBackStack(null);
		}
		fragmentTransaction.commit();

	}
}
