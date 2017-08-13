package com.gostatz.gostatztrainer.activities;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gostatz.gostatztrainer.R;

import java.util.Date;

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
		FloatingActionButton fab = fragmentView.findViewById(R.id.fab);
		fab.setOnClickListener(view -> viewModel.addClient(new BusinessClient(new Date().getTime(), "Nov", "Nov")));
		
		
		return fragmentView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		viewModel.getBusinessClients().observe(this, client -> {
			// update UI
			Toast.makeText(getActivity(), "Changed!", Toast.LENGTH_SHORT).show();
		});
	}
}
