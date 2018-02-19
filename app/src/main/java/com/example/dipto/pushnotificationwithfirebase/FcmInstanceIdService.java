package com.example.dipto.pushnotificationwithfirebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Dipto on 2/18/2018.
 */

public class FcmInstanceIdService extends FirebaseInstanceIdService {

    SharedPreferences sharedPreferences ;
    String TAG = "FcmInstanceIdService" ;

    @Override
    public void onTokenRefresh() {
        String recent_token = FirebaseInstanceId.getInstance().getToken() ;
        sharedPreferences = getApplicationContext().getSharedPreferences(Utils.prefs, Context.MODE_PRIVATE) ;
        SharedPreferences.Editor editor = sharedPreferences.edit() ;
        editor.putString(Utils.fcm_token, recent_token) ;
        editor.commit() ;
        String token = sharedPreferences.getString(Utils.fcm_token, "") ;
        Log.d(TAG, token) ;
    }
}
