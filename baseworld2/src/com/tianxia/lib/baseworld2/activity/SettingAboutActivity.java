package com.tianxia.lib.baseworld2.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.tianxia.lib.baseworld2.R;

public class SettingAboutActivity extends BaseActivity{

    private TextView mAppTitle;
    private Button mAppHeaderBack = null;
    private View mAppHeaderBackDivider;

    private TextView mSettingAboutVersionTextView;
    private WebView mSettingAboutLinkWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_about_activity);

        mAppTitle = (TextView) findViewById(R.id.app_title);
        mAppHeaderBack = (Button) findViewById(R.id.app_header_back);
        mAppHeaderBackDivider = findViewById(R.id.app_header_back_divider);

        mAppTitle.setText(R.string.setting_about_title);
        mAppHeaderBack.setVisibility(View.VISIBLE);
        mAppHeaderBackDivider.setVisibility(View.VISIBLE);
        mAppHeaderBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mSettingAboutVersionTextView = (TextView) findViewById(R.id.setting_about_version);
        PackageInfo pinfo;
        try {
            pinfo = this.getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            mSettingAboutVersionTextView.setText(pinfo.versionName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        mSettingAboutLinkWebView = (WebView) findViewById(R.id.setting_about_link);
        mSettingAboutLinkWebView.loadUrl("file:///android_asset/setting_about_link.html");
    }
}
