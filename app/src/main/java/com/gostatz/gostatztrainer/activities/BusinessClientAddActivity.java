package com.gostatz.gostatztrainer.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gostatz.gostatztrainer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessClientAddActivity extends AppCompatActivity {
	
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business_client_add);
		ButterKnife.bind(this);
		
		setUpActionBar();
	}
	
	private void setUpActionBar() {
		setSupportActionBar(toolbar);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_share);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
}
