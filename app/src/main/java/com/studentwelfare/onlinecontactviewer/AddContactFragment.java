package com.studentwelfare.onlinecontactviewer;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {


    EditText _name, mobile, email, address;
    Button btnAdd;
    ProgressDialog pd;
    final String API_URL = "http://dextert074.000webhostapp.com/android_api/add_contact.php?username=";
    SessionManagement sessionManagement;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        btnAdd = view.findViewById(R.id.btnAddContact);
        _name = view.findViewById(R.id.add_name);
        email = view.findViewById(R.id.add_email);
        mobile = view.findViewById(R.id.add_mobile);
        address = view.findViewById(R.id.add_address);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!_name.getText().toString().trim().equals("") &&
                        !email.getText().toString().trim().equals("") &&
                        !mobile.getText().toString().trim().equals("") &&
                        !address.getText().toString().trim().equals("") ){
                    sessionManagement = new SessionManagement(getContext());
                    HashMap<String, String> map;
                    map = sessionManagement.getPreference();
                    String username = map.get(SessionManagement.KEY_USERNAME);
                    getData(API_URL+username+"&name="+_name.getText()+"&mobile="+mobile.getText()+"&email="+email.getText()+"&address="+address.getText());

                }else{
                    Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void getData(String url) {

        pd = new ProgressDialog(getContext());
        pd.setCancelable(false);
        pd.setMessage("Adding new contact");
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
                        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(getContext()).add(request);
    }

    private void parseHJson(String data){

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            while (count < jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                Toast.makeText(getContext(), ""+JO.getString("response"), Toast.LENGTH_SHORT).show();
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
