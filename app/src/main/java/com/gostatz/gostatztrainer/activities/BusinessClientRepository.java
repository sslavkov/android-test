package com.gostatz.gostatztrainer.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sslavkov on 8/18/17.
 */

class BusinessClientRepository {
	
	private MutableLiveData<List<BusinessClient>> businessClients;
	private static BusinessClientRepository INSTANCE = null;
	
	
	private BusinessClientRepository() {}
	
	public BusinessClient create(BusinessClient client) {
		return client;
	}
	
	public LiveData<List<BusinessClient>> retrieve() {
		if (businessClients == null) {
			businessClients = new MutableLiveData<>();
			businessClients.setValue(new ArrayList<>());
		}
		
		return businessClients;
	}
	
	public static BusinessClientRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BusinessClientRepository();
		}
		
		return INSTANCE;
	}

}
