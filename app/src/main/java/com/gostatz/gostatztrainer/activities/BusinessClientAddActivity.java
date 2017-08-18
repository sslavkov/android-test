package com.gostatz.gostatztrainer.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.gostatz.gostatztrainer.R;

public class BusinessClientAddActivity extends AppCompatActivity {
	
	@BindView(R.id.toolbar)
	Toolbar toolbar;

	@BindDrawable(R.drawable.ic_close_black_24dp)
	protected Drawable mCloseIcon;

	@BindColor(R.color.md_white_1000)
	int mColorWhite;

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
//
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
//
//	private void save() {
//		Toast.makeText(this, "Saving...", Toast.LENGTH_SHORT).show();
//		NavUtils.navigateUpFromSameTask(this); // navigate UP
//	}
	
	
	private void setUpActionBar() {
		setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }

		mCloseIcon.setTint(mColorWhite);
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
		supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle(R.string.client_add);
	}
	
}
