package com.gostatz.gostatztrainer.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * Created by sslavkov on 8/13/17.
 */

public class BusinessClientListViewModel extends ViewModel {
	
	private LiveData<List<BusinessClient>> businessClients;
	private BusinessClientRepository businessClientRepository;
	
	public void init() {
		businessClientRepository = BusinessClientRepository.getInstance();
		businessClients = businessClientRepository.retrieve();
	}
	
	public LiveData<List<BusinessClient>> getBusinessClients() {
		businessClients = businessClientRepository.retrieve();
		return businessClients;
	}
	
}
