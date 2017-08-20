package com.gostatz.gostatztrainer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gostatz.gostatztrainer.R;
import com.mikepenz.materialdrawer.Drawer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessClientListActivity extends AppCompatActivity {
	
	@BindView(R.id.fab)
	FloatingActionButton fab;
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business_clients_list);
		ButterKnife.bind(this);
		
		fab.setOnClickListener(onClick -> startActivity(new Intent(BusinessClientListActivity.this, BusinessClientAddActivity.class)));
		
		setSupportActionBar(toolbar);
		
		setUpNavDrawer();
	}
	
	private void setUpNavDrawer() {
		
		Drawer drawer = NavigationDrawerHelper.getDefaultDrawerBuilder(this, toolbar).build();
	}
	
}
