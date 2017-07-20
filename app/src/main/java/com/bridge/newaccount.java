package com.bridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import com.bridge.bridge.BackgroundTask;
import com.bridge.bridge.R;

public class newaccount extends AppCompatActivity {
  //  DatabaseHelper helper = new DatabaseHelper(this);
  EditText USername, PAss, REpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);
        USername = (EditText) findViewById(R.id.uname);
        PAss = (EditText) findViewById(R.id.pass);
        REpass = (EditText) findViewById(R.id.repass);
    }

    public void onRegisterClick(View v) {
        if (USername.getText().length() > 0 && PAss.getText().length() > 0 && REpass.getText().length() > 0) {
            if (v.getId() == R.id.registerbtn) {
                EditText username = (EditText) findViewById(R.id.uname);
                EditText pass1 = (EditText) findViewById(R.id.pass);
                EditText pass2 = (EditText) findViewById(R.id.repass);

                String usernamestr = username.getText().toString();
                String pass1str = pass1.getText().toString();
                String pass2str = pass2.getText().toString();

                if (!pass1str.equals(pass2str)) {
                    //popup message
                    Toast pass = Toast.makeText(newaccount.this, "Password Doesn't Match!", Toast.LENGTH_SHORT);
                    pass.show();
                } else {

                    String type = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute(type, usernamestr, pass1str, pass2str);
                    finish();
                    //store username and password to database

                    /*Toast temp = Toast.makeText(newaccount.this, "Registered Successfully!", Toast.LENGTH_SHORT);
                    temp.show();
                    Intent i = new Intent(newaccount.this, Login.class);
                    startActivity(i);*/
                }
            }
        }
        else
        {Toast.makeText(getBaseContext(), "You cannot leave any field empty", Toast.LENGTH_LONG).show();}
    }
}
        /*    if(!pass1str.equals(pass2str))
            {
                //popup message
                Toast pass = Toast.makeText(newaccount.this, "Password Doesn't Match!" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //store username and password to database
                /*Contact c = new Contact();
                c.setUname(usernamestr);
                c.setPass(pass1str);
                helper.insertContact(c);*/
          /*      Toast temp = Toast.makeText(newaccount.this, "Registered Successfully!" , Toast.LENGTH_SHORT);
                temp.show();
                Intent i = new Intent(newaccount.this, Login.class);
                startActivity(i);
            }*/

//}
