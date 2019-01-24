package com.studentwelfare.onlinecontactviewer;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListContactFragment extends Fragment {


    public ListContactFragment() {
        // Required empty public constructor
    }

    ProgressDialog pd;
    ListView listView;
    final String API_URL = "http://dextert074.000webhostapp.com/android_api/list_contacts.php?username=";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_contact, container, false);

        SessionManagement sessionManagement = new SessionManagement(getContext());
        HashMap<String, String> map;
        map = sessionManagement.getPreference();


        listView = view.findViewById(R.id.list_contact);

        if(!sessionManagement.isLogin()){
            Toast.makeText(getContext(), "Please Login First", Toast.LENGTH_SHORT).show();
            getActivity().startActivity(new Intent(getActivity(),LoginPage.class));
            getActivity().finish();
        }


        getData(API_URL+map.get(SessionManagement.KEY_USERNAME));



        return view;
    }

    private void getData(String url) {

        pd = new ProgressDialog(getContext());
        pd.setCancelable(false);
        pd.setMessage("Loading Contacts");
        pd.setTitle("Fetching");
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

    private void parseHJson(String response) {
        String name, mobile,email;
        ListAdapter listAdapter = new ListAdapter(getContext(),R.layout.list_layout);

        listView.setAdapter(listAdapter);
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("contacts");
            int count = 0;
            while (count < jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                name = JO.getString("name");
                email = JO.getString("email");
                mobile = JO.getString("mobile");
                DataPack dataPack = new DataPack(getContext(),name, mobile,email);
                listAdapter.add(dataPack);
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
