package com.example.wasia.android6_atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private boolean logon = false;
    public static final int FUNC_LOGIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, FUNC_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FUNC_LOGIN && resultCode == RESULT_OK) {
            String uid = data.getStringExtra("LOGIN_USERID");
            String pwd = data.getStringExtra("LOGIN_PASSWORD");
            Log.d("RESULT:", uid + "/" + pwd);
        }
        else {
            finish();
        }
    }
}
