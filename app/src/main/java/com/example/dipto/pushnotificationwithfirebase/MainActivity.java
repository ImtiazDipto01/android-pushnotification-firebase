package com.example.dipto.pushnotificationwithfirebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button mybtn ;
    private SharedPreferences sharedPreferences;
    public String TAG = "FCM_TOKEN" ;
    private String fcm_token ;
    private String URL = "https://programmerimtiaz.000webhostapp.com/fcm_insert.php" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybtn = findViewById(R.id.send_fcm_token) ;

        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getApplicationContext().getSharedPreferences(Utils.prefs, Context.MODE_PRIVATE) ;
                fcm_token = sharedPreferences.getString(Utils.fcm_token, "") ;
                if(fcm_token.isEmpty()){
                    Log.d(TAG, "nothing") ;
                }
                else{
                    Log.d(TAG, fcm_token) ;
                }


                /*StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        })
                        {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<String, String>() ;
                                params.put("fcm_token", fcm_token) ;
                                return super.getParams();
                            }
                        };
                        VolleySingleTone.getInstance(MainActivity.this).addToRequestQueue(stringRequest);*/
            }
        });
    }
}
