package com.omkar.mybbshop;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.omkar.mybbshop.bbhome.BBHomeActivity;
import com.omkar.mybbshop.core.BBSuperActivity;
import com.omkar.mybbshop.data_services.BBRetrofitclient;
import com.omkar.mybbshop.model.BBClientLogin;
import com.omkar.mybbshop.model.BBLoginResp;


import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BBLoginActivity extends BBSuperActivity {
    @BindView(R.id.llLogin)
    LinearLayout llLogin;

    @BindView(R.id.llRegister)
    LinearLayout llRegister;

    @BindView(R.id.usrusr)
    EditText usrusr;

    @BindView(R.id.usrusr1)
    EditText usrusr1;

    @BindView(R.id.pswrdd)
    EditText pswrdd;

    @BindView(R.id.pswrdd1)
    EditText pswrdd1;

    @BindView(R.id.loginTv)
    TextView loginTv;

    @BindView(R.id.mailTv)
    EditText mailTv;

    @BindView(R.id.mobphoneTv)
    EditText mobPhoneTv;

    @BindView(R.id.noacctTv)
    TextView noacctTv;

    @BindView(R.id.backTv)
    TextView backTv;

    @BindView(R.id.registerTv)
    TextView registerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bblogin);
        ButterKnife.bind(this);

    }


    public boolean checkEmptyFields() {
        if (usrusr.getText().toString().isEmpty()) {
            return false;
        } else if (pswrdd.getText().toString().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @OnClick(R.id.noacctTv)
    public void openRegisteration() {
        llRegister.setVisibility(View.VISIBLE);
        llLogin.setVisibility(View.GONE);
        loginTv.setVisibility(View.GONE);
        registerTv.setVisibility(View.VISIBLE);
        noacctTv.setVisibility(View.GONE);
        backTv.setVisibility(View.VISIBLE);
    }


    @OnClick(R.id.backTv)
    public void backToLogin() {
        backTv.setVisibility(View.GONE);
        noacctTv.setVisibility(View.VISIBLE);
        llRegister.setVisibility(View.GONE);
        llLogin.setVisibility(View.VISIBLE);
        loginTv.setVisibility(View.VISIBLE);
        registerTv.setVisibility(View.GONE);
    }

    public void makeAllEmptyFields(){
        usrusr.setText("");
        pswrdd.setText("");

    }
    @OnClick(R.id.loginTv)
    public void checkforLogin() {
        try {

            if (checkEmptyFields()) {
                Call<BBLoginResp> resp = BBRetrofitclient.getInstance().getMyApi().getLoginDetails(new BBClientLogin(usrusr.getText().toString(), pswrdd.getText().toString()));
                resp.enqueue(new Callback<BBLoginResp>() {
                    @Override
                    public void onResponse(Call<BBLoginResp> call, Response<BBLoginResp> response) {
                        if (response.isSuccessful() && response.body() != null && response.body().status.equals("success")) {
                            makeAllEmptyFields();
                            startActivity(new Intent(getApplicationContext(), BBHomeActivity.class));

                        } else {
                            makeAllEmptyFields();
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BBLoginActivity.this);
                            alertDialogBuilder.setTitle("Error");
                            alertDialogBuilder.setMessage("User not recognized");
                            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialogBuilder.setCancelable(false);

                            alertDialogBuilder.show();

                        }
                    }

                    @Override
                    public void onFailure(Call<BBLoginResp> call, Throwable t) {
                        makeAllEmptyFields();
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BBLoginActivity.this);
                        alertDialogBuilder.setTitle("Network issue");
                        alertDialogBuilder.setMessage("some network issue try again");
                        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialogBuilder.setCancelable(false);

                        alertDialogBuilder.show();
                    }
                });
            } else {
                showErrorForEmpty();

            }
        }catch (Exception e)
        {
            Log.e(e.toString(),e.getMessage());
        }
    }
  public void showErrorForEmpty(){
      AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
      alertDialogBuilder.setTitle("Invalid operation");
      alertDialogBuilder.setMessage("Please fill all fields and try again");
      alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              dialog.cancel();
          }
      });
      alertDialogBuilder.setCancelable(false);

      alertDialogBuilder.show();
  }
    @Override
    public void onBackPressed() {
        if (noacctTv.getVisibility() == View.VISIBLE) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

// set the title of the Alert Dialog
            alertDialogBuilder.setTitle("MyBBshop");

// set dialog message
            alertDialogBuilder
                    .setMessage("Are you sure to exit from application")
                    .setCancelable(false)
                    .setPositiveButton(("YES"),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // what to do if YES is tapped
                                    finishAffinity();
                                    System.exit(0);
                                }
                            }).setNeutralButton(("CANCEL"),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int id) {
                            // code to do on CANCEL tapped
                            dialog.cancel();
                        }
                    })

                    .setNegativeButton(("NO"),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // code to do on NO tapped
                                    dialog.cancel();
                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();

            alertDialog.show();
        } else {
            backTv.setVisibility(View.GONE);
            noacctTv.setVisibility(View.VISIBLE);
            llRegister.setVisibility(View.GONE);
            llLogin.setVisibility(View.VISIBLE);
            loginTv.setText(getString(R.string.login));
        }
    }
}
