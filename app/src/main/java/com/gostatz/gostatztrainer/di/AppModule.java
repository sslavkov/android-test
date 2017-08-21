package com.gostatz.gostatztrainer.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sslavkov on 8/20/2017.
 */

@Module
public class AppModule {
	private Application application;

	public AppModule(Application application) {
		this.application = application;
	}

	@Provides
	@Singleton
	public Context provideContext() {
		return application;
	}
}
