package com.omkar.mybbshop.bbhome;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.omkar.mybbshop.R;
import com.omkar.mybbshop.core.BBSuperActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;

import android.os.Handler;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Objects;

public class BBHomeActivity extends BBSuperActivity {

    @BindView(R.id.fragView)
    FrameLayout fragView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_timeslotts:
                    getBBtimeslottFragment();
                    return true;
                case R.id.navigation_experts:
                    getBBServiceFragment();
                    return true;
                case R.id.navigation_profile:
                    getBBprofileFragment();
                    return true;
            }
            return false;
        }
    };
    public void getBBServiceFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragView, new BBServiceFragment()).commit();
    }

    public void getBBtimeslottFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragView, new BBExpertiesNTimeslottsFragment()).commit();
    }

    public void getBBprofileFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragView, new BBProfileNCartFragment()).commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhome);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);

     new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openDialog();

            }
        },500);


        getBBtimeslottFragment();

    }

    private void openDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

// set the title of the Alert Dialog
        alertDialogBuilder.setTitle("Please");

// set dialog message
        alertDialogBuilder
                .setMessage("choose proper time slot,when you want service and get appointment with experts")
                .setCancelable(false)
                .setPositiveButton(("OK"),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                // what to do if YES is tapped
                                dialog.cancel();

                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

}
