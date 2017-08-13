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
	
	private LiveData<List<BusinessClient>> businessClients;
	
	public void init() {
		List<BusinessClient> fake = new ArrayList<>();
		BusinessClient client = new BusinessClient(new Date().getTime(), "Svet", "Slavkov");
		fake.add(client);
	}
	
	public LiveData<List<BusinessClient>> getBusinessClients() {
		if (businessClients == null) {
			MutableLiveData<List<BusinessClient>> listMutableLiveData = new MutableLiveData<>();
			listMutableLiveData.setValue(new ArrayList<>());
			businessClients = listMutableLiveData;
		}
		return businessClients;
	}
	
	
	public void addClient(BusinessClient client) {
		MutableLiveData<List<BusinessClient>> data = new MutableLiveData<>();
		List<BusinessClient> value = businessClients.getValue();
		value.add(client);
		data.setValue(value);
		businessClients = data;
	}
}
