package com.omkar.mybbshop;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.omkar.mybbshop.core.BBSuperActivity;

import androidx.appcompat.app.AlertDialog;

public class BBsplashActivity extends BBSuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BBsplashActivity.this,BBSettingsActivity.class));
            }
        },1000);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
