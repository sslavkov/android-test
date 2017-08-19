package com.gostatz.gostatztrainer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.gostatz.gostatztrainer.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class BusinessClientAddFragment extends Fragment implements Validator.ValidationListener {

	private Validator validator;
	private Unbinder unbinder;
	
	private BusinessClientRepository businessClientRepository;

	@BindView(R.id.business_client_first_name)
	TextInputEditText firstName;
	@Length(trim = true, min = ValidationConstants.NAME_MIN, max = ValidationConstants.NAME_MAX, messageResId = R.string.error_name)
	@BindView(R.id.layout_business_client_first_name)
	TextInputLayout firstNameLayout;

	@BindView(R.id.business_client_last_name)
	TextInputEditText lastName;
	@Length(trim = true, min = ValidationConstants.NAME_MIN, max = ValidationConstants.NAME_MAX, messageResId = R.string.error_name)
	@BindView(R.id.layout_business_client_last_name)
	TextInputLayout lastNameLayout;

	@BindView(R.id.business_client_email)
	TextInputEditText email;
	@Email(messageResId = R.string.error_email)
	@BindView(R.id.layout_business_client_email)
	TextInputLayout emailLayout;
	
	@BindViews({ R.id.layout_business_client_first_name, R.id.layout_business_client_last_name, R.id.layout_business_client_email })
	List<TextInputLayout> allFields; // easy access to all validated fields

	public BusinessClientAddFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_business_client_add, container, false);
		unbinder = ButterKnife.bind(this, rootView);

		setHasOptionsMenu(true); // enables to see menu items
		initValidator();
		initEventListeners();
		businessClientRepository = BusinessClientRepository.getInstance(); // TODO - replace with DI
		
		return rootView;
	}
	
	@Override
	public void onDestroyView() {
		unbinder.unbind();
		super.onDestroyView();
	}
	
	private void initEventListeners() {
		// deals with when keyboard presses done
		email.setOnEditorActionListener((view, actionId, event) -> {
			if ((actionId == EditorInfo.IME_ACTION_DONE) || (event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))) {
				validate();
			}
			return false;
		});
	}
	
	private void initValidator() {
		validator = new Validator(this);
		validator.registerAdapter(TextInputLayout.class, new TextInputLayoutAdapter());
		validator.setValidationListener(this);
	}
	
	private void validate() {
		clearErrors();
		validator.validate();
	}
	
	private void clearErrors() {
		for (TextInputLayout field : allFields) {
			field.setError(null);
		}
	}

	@Override
	public void onValidationSucceeded() {
		Toast.makeText(getActivity(), "Successful validation", Toast.LENGTH_SHORT).show();
		// create save model here
		save();
		startActivity(new Intent(getActivity(), BusinessClientInfoActivity.class));
//		NavUtils.navigateUpFromSameTask(getActivity()); // navigate UP - or go elsewhere
	}
	
	private void save() {
//		startActivity(new Intent(BusinessClientListActivity.this, BusinessClientAddActivity.class))

//		private static final String UID_KEY = "uid";
		BusinessClient businessClient = businessClientRepository.create(new BusinessClient(new Date().getTime(), "Svet", "Slavkov"));
//		startDetailsActivity() - pass object and add to details activity as parcelable
	}
	
	@Override
	public void onValidationFailed(List<ValidationError> errors) {
		for (ValidationError error : errors) {
			View view = error.getView();
			String message = error.getCollatedErrorMessage(getActivity());

			// Display error messages ;)
			if (view instanceof TextInputLayout) {
				((TextInputLayout) view).setError(message);
			} else {
				Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
			}
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_save) {
			validate();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
