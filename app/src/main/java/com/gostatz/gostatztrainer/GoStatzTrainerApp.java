package com.gostatz.gostatztrainer;

import android.app.Application;

import com.gostatz.gostatztrainer.di.AppComponent;
import com.gostatz.gostatztrainer.di.AppModule;
import com.gostatz.gostatztrainer.di.DaggerAppComponent;

/**
 * Created by sslavkov on 8/20/2017.
 */

public class GoStatzTrainerApp extends Application {
	private AppComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		appComponent = initDagger(this);
	}

	protected AppComponent initDagger(GoStatzTrainerApp application) {
		return DaggerAppComponent.builder()
				.appModule(new AppModule(application))
				.build();
	}

	public AppComponent getAppComponent() {
		return appComponent;
	}

}
