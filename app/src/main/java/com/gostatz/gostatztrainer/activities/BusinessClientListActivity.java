package com.gostatz.gostatztrainer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gostatz.gostatztrainer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessClientListActivity extends AppCompatActivity {
	
	@BindView(R.id.fab)
	FloatingActionButton fab;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business_clients_list);
		ButterKnife.bind(this);
		
		fab.setOnClickListener(onClick -> startActivity(new Intent(BusinessClientListActivity.this, BusinessClientAddActivity.class)));
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}
	
}
