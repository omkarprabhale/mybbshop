package com.omkar.mybbshop;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

import com.omkar.mybbshop.core.BBSuperActivity;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.http.Url;

public class BBSettingsActivity extends BBSuperActivity {

    @BindView(R.id.edtUrl)
    EditText edtUrl;

    @BindView(R.id.tvsave)
    TextView tvsave;

    public static  String AppUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbsettings);
        ButterKnife.bind(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        edtUrl.setText(preferences.getString("appUrl","http://192.168.0.152:4000/"));

    }
    @OnClick(R.id.tvsave)
    void saveUrl()
    {
        if(!edtUrl.getText().toString().equals("")) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            preferences.edit().putString("appUrl", edtUrl.getText().toString()).apply();
            AppUrl = edtUrl.getText().toString();

            startActivity(new Intent(this,BBLoginActivity.class));

        }
    }
}
