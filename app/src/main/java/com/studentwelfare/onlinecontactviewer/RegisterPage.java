package com.studentwelfare.onlinecontactviewer;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RegisterPage extends AppCompatActivity {


    final String API_URL = "http://dextert074.000webhostapp.com/android_api/insert_user.php?username=";

    Button register, backtoLogin;
    EditText usern,pass,mobile;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        register = findViewById(R.id.reg_signup);
        backtoLogin = findViewById(R.id.backto_login);
        usern = findViewById(R.id.register_username);
        pass = findViewById(R.id.register_password);
        mobile = findViewById(R.id.register_mobile);


        backtoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterPage.this, LoginPage.class));
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!usern.getText().toString().trim().equals("") && !pass.getText().toString().trim().equals("") && !mobile.getText().toString().trim().equals("")){
                    getData(API_URL+usern.getText().toString().trim()+"&mobile="+mobile.getText().toString().trim()+"&password="+pass.getText().toString().trim());
                }else{
                    Toast.makeText(RegisterPage.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private void getData(String url) {

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Registering new user");
        pd.setTitle("Please Wait");
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
                        Toast.makeText(RegisterPage.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(request);
    }

    private void parseHJson(String data){

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            while (count < jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                Toast.makeText(this, ""+JO.getString("response"), Toast.LENGTH_SHORT).show();
                count++;
            }
            startActivity(new Intent(RegisterPage.this, LoginPage.class));
            finish();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
