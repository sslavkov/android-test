package com.gostatz.gostatztrainer.di;

import com.gostatz.gostatztrainer.activities.BusinessClientAddFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sslavkov on 8/20/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

	void inject(BusinessClientAddFragment target);
}
