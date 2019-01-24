package com.studentwelfare.onlinecontactviewer;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {
    Button login_page, toSignup;
    ProgressDialog pd;
    EditText username_login, password_login;

    AlertDialog.Builder alertDialog;
    SessionManagement sessionManagement;
    final String API_URL = "http://dextert074.000webhostapp.com/android_api/select_user.php?username=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username_login = findViewById(R.id.login_username);
        password_login = findViewById(R.id.login_password);
        login_page = findViewById(R.id.login_now);
        toSignup = findViewById(R.id.to_signup);



        toSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginPage.this, RegisterPage.class));

                finish();
            }
        });


        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username_login.getText().toString().trim().equals("") && !password_login.getText().toString().trim().equals("")){
                    getData(API_URL+username_login.getText().toString().trim());
                }else{
                    Toast.makeText(LoginPage.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void getData(String url) {

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Loading");
        pd.setTitle("Authentication");
        pd.show();

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.dismiss();
                        parseHJson(response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      pd.dismiss();
                      Toast.makeText(LoginPage.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(request);
    }

    private void parseHJson(String data){
        String username, password, mobile;

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("userdata");
            int count = 0;
            while (count < jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                username = JO.getString("username");
                password = JO.getString("password");
                mobile = JO.getString("mobile");
                if(username.equals(username_login.getText().toString().trim()) && password.equals(password_login.getText().toString().trim())){
                    Toast.makeText(this, "Access Granted", Toast.LENGTH_SHORT).show();
                    sessionManagement = new SessionManagement(this);
                    sessionManagement.createSession(username, password, mobile);
                    startActivity(new Intent(LoginPage.this, HomePage.class));
                    finish();

                }else{
                    alertDialog =  new AlertDialog.Builder(this);
                    alertDialog.setTitle("Authentication failed");
                    alertDialog.setMessage("Please input valid password");
                    //alertDialog.setIcon(getResources().getDrawable(R.drawable.m_enable));

                    alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /*
    response demo
    [
        "userdata":{
        {
            "username":"hi",
            "password":"gs",
            "mobile":"3434",
        },
        {
            "username":"sdlkfads",
            "password":"gs",
            "mobile":"3434",
        },
        .....
        .....
        }

    ]

     */


}
