package com.gostatz.gostatztrainer.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sslavkov on 8/13/17.
 */

public class BusinessClientListViewModel extends ViewModel {
	
	private MutableLiveData<List<BusinessClient>> businessClients;
	
	public void init() {
		List<BusinessClient> fake = new ArrayList<>();
		BusinessClient client = new BusinessClient(new Date().getTime(), "Svet", "Slavkov");
		fake.add(client);
	}
	
	public LiveData<List<BusinessClient>> getBusinessClients() {
		if (businessClients == null) {
			businessClients = new MutableLiveData<>();
			businessClients.setValue(new ArrayList<>());
		}
		return businessClients;
	}
	
	
	public void addClient(BusinessClient client) {
		List<BusinessClient> value = businessClients.getValue();
		value.add(client);
		businessClients.setValue(value);
	}
}
