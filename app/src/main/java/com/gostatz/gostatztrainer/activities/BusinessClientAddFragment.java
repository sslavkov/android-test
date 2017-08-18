package com.gostatz.gostatztrainer.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gostatz.gostatztrainer.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class BusinessClientAddFragment extends Fragment implements Validator.ValidationListener {

	private Validator validator;
	private Map<Integer, Integer> editTextToLayoutMap;

	@NotEmpty(messageResId = R.string.error_required)
	@BindView(R.id.business_client_first_name)
	TextInputEditText firstName;
	@BindView(R.id.layout_business_client_first_name)
	TextInputLayout firstNameLayout;

	@NotEmpty(messageResId = R.string.error_required)
	@BindView(R.id.business_client_last_name)
	TextInputEditText lastName;
	@BindView(R.id.layout_business_client_last_name)
	TextInputLayout lastNameLayout;

//	@NotEmpty
//	@Email
	@BindView(R.id.business_client_email)
	TextInputEditText email;

	@NotEmpty(messageResId = R.string.error_required)
	@Email(messageResId = R.string.error_email)
	@BindView(R.id.layout_business_client_email)
	TextInputLayout emailLayout;

	public BusinessClientAddFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_business_client_add, container, false);
		ButterKnife.bind(this, rootView);

		setHasOptionsMenu(true); // enables to see menu items

		setUpValidator();
		return rootView;
	}

	private void setUpValidator() {
		validator = new Validator(this);
		validator.registerAdapter(TextInputLayout.class, new TextInputLayoutAdapter());
		validator.setValidationListener(this);
	}


	@Override
	public void onValidationSucceeded() {
		Toast.makeText(getActivity(), "Successful validation", Toast.LENGTH_SHORT).show();

//		NavUtils.navigateUpFromSameTask(getActivity()); // navigate UP
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
		Toast.makeText(getActivity(), "Failed validation", Toast.LENGTH_SHORT).show();
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

	// TODO - check the action from keyboard - to validate
	private void validate() {
		validator.validate();
	}
}
