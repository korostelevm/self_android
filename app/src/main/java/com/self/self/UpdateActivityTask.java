package com.self.self;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 5/7/15.
 */

public class UpdateActivityTask extends AsyncTask<String, Void, String> {

    private static final String TAG = "async task";
    private Exception exception;

    protected String doInBackground(String... params) {


        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.mikekorostelev.com/~bits/self/db/user/mike/update");
        Log.i(TAG, "adding");
        try {
            // Add your data

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("activity", params[0]));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            Log.i(TAG, "added");
            Log.i(TAG, response.getEntity().toString());

            ResponseHandler<String> responseHandler=new BasicResponseHandler();
            String json = httpclient.execute(httppost, responseHandler);
            //JSONObject response=new JSONObject(responseBody);

            return(json);

        } catch (ClientProtocolException e) {
            return e.toString();
            // TODO Auto-generated catch block
        } catch (IOException e) {
            return e.toString();
            // TODO Auto-generated catch block
        }


    }

    protected void onPostExecute(String response) {
        // TODO: check this.exception
        // TODO: do something with the feed
        Log.i(TAG, "the response = " + response);
        


    }

}
