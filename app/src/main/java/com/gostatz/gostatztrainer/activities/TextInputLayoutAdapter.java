package com.gostatz.gostatztrainer.activities;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import com.mobsandgeeks.saripaar.adapter.ViewDataAdapter;

/**
 * Created by sslavkov on 8/17/2017.
 */

public class TextInputLayoutAdapter implements ViewDataAdapter<TextInputLayout, String> {

    @Override
    public String getData(final TextInputLayout til) {
        return getText(til);
    }

    private String getText(TextInputLayout til) {
        EditText editText = til.getEditText();
        return editText == null ? "" : editText.getText().toString();
    }
}