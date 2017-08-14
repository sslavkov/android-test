package com.gostatz.gostatztrainer.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gostatz.gostatztrainer.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class BusinessClientAddFragment extends Fragment {
	
	public BusinessClientAddFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_business_client_add, container, false);
	}
}
