package com.gostatz.gostatztrainer.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gostatz.gostatztrainer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessClientInfoActivity extends AppCompatActivity {
	
	@BindView(R.id.business_client_info_edit_fab)
	FloatingActionButton editFab;
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business_client_info);
		ButterKnife.bind(this);
		
		setUpActionBar();
		
		editFab.setOnClickListener(view -> Snackbar.make(view, "Clicked Edit", Snackbar.LENGTH_LONG)
				.setAction("Action", null).show());
		
	}
	
	private void setUpActionBar() {
		setSupportActionBar(toolbar);
		ActionBar supportActionBar = getSupportActionBar();
		if (supportActionBar == null) {
			return;
		}
		supportActionBar.setDisplayHomeAsUpEnabled(true);
	}
}
