package com.gostatz.gostatztrainer.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gostatz.gostatztrainer.R;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class BusinessClientAddFragment extends Fragment {
	
	
	@BindView(R.id.business_client_first_name)
	TextInputEditText firstName;
	
	@BindView(R.id.business_client_last_name)
	TextInputEditText lastName;
	
	@NotEmpty
	@Email
	@BindView(R.id.business_client_email)
	TextInputEditText email;
	
	public BusinessClientAddFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_business_client_add, container, false);
		ButterKnife.bind(this, rootView);
		
		return rootView;
	}
}
