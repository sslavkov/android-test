package com.gostatz.gostatztrainer.activities;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gostatz.gostatztrainer.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class BusinessClientListFragment extends LifecycleFragment {
	
	private BusinessClientListViewModel viewModel;
	
	public BusinessClientListFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_business_clients_list, container, false);
		
		viewModel = ViewModelProviders.of(this).get(BusinessClientListViewModel.class);
		
		return fragmentView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		viewModel.getBusinessClients().observe(this, clients -> {
			// update UI
			Toast.makeText(getActivity(), "Changed!", Toast.LENGTH_SHORT).show();
		});
	}
}
