package com.bridge;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bridge.bridge.BackgroundTask;
import com.bridge.bridge.R;

import static com.bridge.bridge.R.id.Password;
import static com.bridge.bridge.R.id.newaccount;



public class Login extends AppCompatActivity {
    EditText username1, pass11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         username1 = (EditText) findViewById(R.id.namefield);
         pass11 = (EditText) findViewById(R.id.passwordfield);
       // init();
    }

    /*public void Database()
    {
        exportDatabase();
    }*/

  /*  public Button Login;

    public void init() {
        setContentView(R.layout.activity_login);*/

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Login) {
            {

                String username1str = username1.getText().toString();
                String pass11str = pass11.getText().toString();
                String type = "login";
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(type, username1str, pass11str);

                //finish();




   /*      if(pass.equals(password))
            {
              /*  Intent btn = new Intent(Login.this, Home.class);
                startActivity(btn);*/
     /*           Intent i = new Intent(Login.this, home.class);
               // i.putExtra("username",str);
                startActivity(i);
            }
            else
            {
                //popup message
                Toast temp = Toast.makeText(Login.this, "Username and Password don't Match!" , Toast.LENGTH_SHORT);
                temp.show();
            }
        }
    }*/



       /* Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn = new Intent(Login.this, Home.class);
                startActivity(btn);
            }
        });*/


            }
        }
    }
    public void clickExit(View v) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    public void registeraccount(View view) {
        Intent next = new Intent(Login.this, newaccount.class);
        startActivity(next);
    }

}


