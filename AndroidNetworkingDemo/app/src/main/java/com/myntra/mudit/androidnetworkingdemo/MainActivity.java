package com.myntra.mudit.androidnetworkingdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    ProgressDialog mProgressDialog;
    TextView tvResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn_send_request);
        tvResultText = (TextView) findViewById(R.id.tv_result_text);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetNetworkCallAsync getNetworkCallAsync = new GetNetworkCallAsync();
                getNetworkCallAsync.execute();
            }
        });

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    class GetNetworkCallAsync extends AsyncTask<String, String, String>{

        HttpURLConnection urlConnection;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog.setMessage("Requesting data");
            mProgressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {


            StringBuilder result = new StringBuilder();

            try {
                URL url = new URL("http://developer.myntra.com/search/data/nike");
                urlConnection = (HttpURLConnection) url.openConnection();
                //urlConnection.setRequestMethod("GET");

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }


            return result.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvResultText.setText(s);
            mProgressDialog.dismiss();
        }
    }
}
