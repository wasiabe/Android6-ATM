package com.example.wasia.android6_atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText edUserid;
    private EditText edPassword;
    private String uid;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
    }

    public void logon (View view) {
        uid = edUserid.getText().toString();
        pwd = edPassword.getText().toString();
        if (uid.equals("albert") && pwd.equals("123")) {
            Toast.makeText(this,getString(R.string.login_id),Toast.LENGTH_LONG);
            getIntent().putExtra("LOGIN_USERID", uid);
            getIntent().putExtra("LOGIN_PASSWORD", pwd);
            setResult(RESULT_OK, getIntent());
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.AppTitle)
                    .setMessage(getString(R.string.loginFailed))
                    .setPositiveButton(R.string.ButtonOK, null)
                    .show();
        }

    }

    private void findViews() {
        edUserid = (EditText) findViewById(R.id.edUserid);
        edPassword = (EditText) findViewById(R.id.edPassword);
    }
}
