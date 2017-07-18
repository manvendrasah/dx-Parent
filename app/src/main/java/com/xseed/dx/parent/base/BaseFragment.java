package com.xseed.dx.parent.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.xseed.dx.parent.R;

/**
 * Created by Shakeeb on 02/11/16.
 */
public class BaseFragment extends Fragment {
    protected Context mContext;
    private ProgressDialog mProgress;
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        fragmentManager = getActivity().getSupportFragmentManager();
    }

    protected void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void showSnack(Context context, int stringID) {

        Snackbar.make(((Activity) context).findViewById(android.R.id.content), stringID, Snackbar.LENGTH_LONG)
                .show();
    }

    protected void showProgress() {
        showProgress(getString(R.string.progress_msg));
    }

    protected void showProgress(String msg) {
        if (mProgress == null) {
            mProgress = new ProgressDialog(mContext);
            mProgress.setCancelable(false);
            mProgress.getWindow().setGravity(Gravity.CENTER);
            mProgress.setMessage(msg);
            mProgress.setIndeterminate(true);
        }
        if (!mProgress.isShowing()) {
            mProgress.show();
        }
    }

    protected void hideProgress() {
        if (mContext.getMainLooper().getThread().equals(Thread.currentThread())) {

            hideProgressInternal();
        } else {
            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideProgressInternal();
                }
            });
        }

    }

    private void hideProgressInternal() {
        if (mProgress != null && mProgress.isShowing() && !((Activity) mContext).isFinishing()) {
            mProgress.dismiss();
        }
    }

    protected void showToast(String msg) {
        Toast.makeText(mContext.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
   /* */

    /**
     * Method to replace the current fragment with the new fragment.
     *//*
    protected void replaceFragmentWithBackStack(Fragment frag) {
        String backStateName = frag.getClass().getName();
        fragmentManager.beginTransaction()
                .replace(R.id.contentMain_frameLayout, frag, backStateName)
                .addToBackStack(backStateName)
                .commit();
    }*/
    protected boolean popCurrentFragment() {
        return fragmentManager.popBackStackImmediate();
    }

}
