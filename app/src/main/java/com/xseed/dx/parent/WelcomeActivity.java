package com.xseed.dx.parent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;

import com.xseed.dx.parent.base.BaseActivity;
import com.xseed.dx.parent.customView.FontTextView;

/**
 * Created by Manvendra Sah on 18/07/17.
 */

public class WelcomeActivity extends BaseActivity implements OnClickListener {

    private FontTextView tvParent, tvChild;
    private ImageView ivPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setupUI();
    }

    private void setupUI() {
        tvParent = (FontTextView) findViewById(R.id.tv_welcome_parent_name);
        tvChild = (FontTextView) findViewById(R.id.tv_welcome_child_name);
        ivPic = (ImageView) findViewById(R.id.iv_welcome_child_pic);

        FontTextView tvReport = (FontTextView) findViewById(R.id.tv_welcome_report);
        FontTextView tvWrongAccount = (FontTextView) findViewById(R.id.tv_welcome_wrong_account);

        tvReport.setOnClickListener(this);
        tvWrongAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_welcome_report:
                break;
            case R.id.tv_welcome_wrong_account:
                break;
            default:
                break;
        }
    }
}
