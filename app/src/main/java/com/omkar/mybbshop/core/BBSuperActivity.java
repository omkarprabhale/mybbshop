package com.omkar.mybbshop.core;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import com.omkar.mybbshop.BBnetwork.BBNetworkReceiver;
import com.omkar.mybbshop.BBnetwork.BBNetworkstate;
import com.omkar.mybbshop.BBnetwork.BBerroractivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BBSuperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(new BBNetworkReceiver(), filter);
        if(BBNetworkstate.getConnectivityStatus(getApplicationContext()) == 0)
        {
            Toast.makeText(getApplicationContext(), BBNetworkstate.getConnectivityStatusString(getApplicationContext()),Toast.LENGTH_LONG).show();

        }

    }

}
