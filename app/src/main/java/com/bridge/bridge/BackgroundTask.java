package com.bridge.bridge;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.system.Os;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bridge.Login;
import com.bridge.bridge.homee;
import com.bridge.newaccount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import static android.R.attr.type;

/**
 * Created by pradip on 5/24/2017.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context ctx;

    // AlertDialog alertDialog;
    public BackgroundTask(Context ctx) {

        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute()

    {
        super.onPreExecute();
       /* alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information..");*/
    }

    @Override


    protected String doInBackground(String... params) {
        String register_url = "http://192.168.0.109//webapp/register.php";
        String login_url = "http://192.168.0.109/webapp/login.php";
        String type = params[0];
        if (type.equals("register")) {
            String usernamestr = params[1];
            String pass1str = params[2];
            String pass2str = params[3];
            try {
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String post_data = URLEncoder.encode("usernamestr", "UTF-8") + "=" + URLEncoder.encode(usernamestr, "UTF-8") + "&"
                        + URLEncoder.encode("pass1str", "UTF-8") + "=" + URLEncoder.encode(pass1str, "UTF-8") + "&"
                        + URLEncoder.encode("pass2str", "UTF-8") + "=" + URLEncoder.encode(pass2str, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                StringBuilder sb = new StringBuilder();
                String result = "";
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                httpURLConnection.disconnect();
                IS.close();
                return "Registration Success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // e.printStackTrace();
                return "exception";
            }
        } else {
            if (type.equals("login")) {
                String username1str = params[1];
                String pass11str = params[2];
                try {
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream OS = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                    String post_data = URLEncoder.encode("username1str", "UTF-8") + "=" + URLEncoder.encode(username1str, "UTF-8") + "&"
                            + URLEncoder.encode("pass11str", "UTF-8") + "=" + URLEncoder.encode(pass11str, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();
                    InputStream IS = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                    String result = "";//success
                    String line = "";

                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    IS.close();
                    httpURLConnection.disconnect();
                    return result;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                   // e.printStackTrace();
                    return "exception";
                }
            }
        }
        return null;
    }


    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success...")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else{
            //ctx.startActivity(new Intent(ctx, home.class));
    /*    alertDialog.setMessage(result);
            alertDialog.show();*/
            if(result.equals("Login successfull"))
            {
                ctx.startActivity(new Intent(ctx, homee.class));
            }
            else if(result.equals("exception")){
                Toast toast= Toast.makeText(ctx, "Connection Failed!", Toast.LENGTH_LONG);
                toast.show();
            }
            else /*if(result.equals("Login failed..."))*/{
                Toast toast= Toast.makeText(ctx, "Username or Password is incorrect", Toast.LENGTH_SHORT);
                toast.show();
            }


        }
    }
}
