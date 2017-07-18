package com.xseed.dx.parent.base;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by Abhi on 25/07/16.
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgress;
    private Snackbar snackBar;
    protected boolean isStopped = false, isPaused = false;

    public void showProgress(String message) {
        if (mProgress == null) {
            mProgress = new ProgressDialog(this);
            mProgress.setCancelable(false);
            mProgress.getWindow().setGravity(Gravity.CENTER);
            mProgress.setMessage(message);
            mProgress.setIndeterminate(true);
        }

        if (!mProgress.isShowing()) {
            mProgress.show();
        }

    }

    public void hideProgress() {
        if (getMainLooper().getThread().equals(Thread.currentThread())) {

            hideProgressInternal();
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideProgressInternal();
                }
            });
        }

    }

    protected void showToast(final String msg) {

        if (getMainLooper().getThread().equals(Thread.currentThread())) {

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    protected void showShortToast(final String msg) {

        if (getMainLooper().getThread().equals(Thread.currentThread())) {

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


    private void hideProgressInternal() {
        if (mProgress != null && mProgress.isShowing() && !isFinishing()) {
            mProgress.dismiss();
        }
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, 0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPaused = false;
        isStopped = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isPaused = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isStopped = true;
    }

    /*
   * keyboard request
   * */
    protected void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    protected void showSnackBar(View anchor, String msg) {
        //  if (snackBar == null || !snackBar.isShownOrQueued()) {
        snackBar = Snackbar.make(anchor, msg, Snackbar.LENGTH_LONG);
        snackBar.show();
        //  }
    }

    protected void showSnackBar(View anchor, String msg, String btnText, OnClickListener clickListener) {
        // if (snackBar == null || !snackBar.isShown()) {
        snackBar = Snackbar.make(anchor, msg, Snackbar.LENGTH_INDEFINITE);
        snackBar.setAction(btnText, clickListener);
        snackBar.show();
        // }
    }

    protected void hideSnackBar() {
        if (snackBar != null && snackBar.isShown()) {
            snackBar.dismiss();
        }
    }
}
