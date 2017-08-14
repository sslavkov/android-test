package com.gostatz.gostatztrainer.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_business_client_add, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_save) {
			Toast.makeText(this, "Saving...", Toast.LENGTH_SHORT).show();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	private void setUpActionBar() {
		setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_share);
		supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle(R.string.client_add);
	}
	
}
