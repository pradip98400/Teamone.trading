package com.bridge;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bridge.Login;
import com.bridge.bridge.R;

public class TEAMONE extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamone);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent LoginIntent =new Intent(TEAMONE.this, Login.class);
                startActivity(LoginIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
