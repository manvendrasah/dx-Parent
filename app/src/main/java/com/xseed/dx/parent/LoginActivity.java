package com.xseed.dx.parent;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.xseed.dx.parent.base.BaseActivity;
import com.xseed.dx.parent.customView.FontEditText;
import com.xseed.dx.parent.customView.FontTextView;
import com.xseed.dx.parent.utils.Utils;

/**
 * Created by Manvendra Sah on 18/07/17.
 */

public class LoginActivity extends BaseActivity implements OnClickListener {

    private FontEditText tvPhone;
    private FontTextView tvErrorPhone;
    private Spinner mSpinner;
    private CountryAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setupUI();
    }

    private void setupUI() {
        tvPhone = (FontEditText) findViewById(R.id.tv_login_phone);
        FontTextView tvLogin = (FontTextView) findViewById(R.id.tv_login_login);
        mSpinner = (Spinner) findViewById(R.id.sp_login_country);
        tvErrorPhone = (FontTextView) findViewById(R.id.tv_login_error_ph);
        spinnerAdapter = new CountryAdapter(this);
        mSpinner.setAdapter(spinnerAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerAdapter.setSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinner.setSelection(0);
        tvLogin.setOnClickListener(this);
        tvPhone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.tv_login_phone || id == EditorInfo.IME_ACTION_DONE) {
                    submitForm();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Validating form and calling validate user api
     */
    private void submitForm() {
        hideKeyboard();
        hideSnackBar();
        if (validatePhone()) {
            //api call
            if (Utils.isNetworkConnected(this)) {
                // Show a progress spinner, and kick off a background task to
                // perform the user login attempt.
                //  showProgress(getString(R.string.loading));
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            } else {
                showSnackBar(tvErrorPhone, getString(R.string.no_internet_connection), getString(R.string.retry_caps), this);
            }
        }
    }

    /*
    * Validate phone number
    * */
    private boolean validatePhone() {
        String phoneNumber = tvPhone.getText().toString().trim();
        if (Utils.isValidPhone(phoneNumber)) {
            tvErrorPhone.setVisibility(View.INVISIBLE);
            return true;
        } else {
            tvErrorPhone.setVisibility(View.VISIBLE);
            requestFocus(tvPhone);
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_login:
                submitForm();
                break;
            case android.support.design.R.id.snackbar_action:
                submitForm();
                break;
            default:
                break;
        }
    }

    /*
    * text input watcher class
    * */
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.tv_login_phone:
                    validatePhone();
                    break;
            }
        }
    }

}
