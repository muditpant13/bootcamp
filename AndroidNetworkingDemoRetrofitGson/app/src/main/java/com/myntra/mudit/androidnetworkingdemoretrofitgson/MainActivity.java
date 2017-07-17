package com.myntra.mudit.androidnetworkingdemoretrofitgson;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.myntra.mudit.androidnetworkingdemoretrofitgson.model.SearchResult;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private AppCompatImageView ivImg;
    private TextView tvResultText;
    private Button mButton;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImg = (AppCompatImageView) findViewById(R.id.iv_product_image);
        tvResultText = (TextView) findViewById(R.id.tv_result_text);
        mButton = (Button) findViewById(R.id.btn_send_request);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCanceledOnTouchOutside(false);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressDialog.setMessage("Getting data...");
                mProgressDialog.show();
                makeNetworkCall();
            }
        });
    }

    private void makeNetworkCall(){

        Call<JsonObject> searchServiceCall = ((NetworkingApplication)getApplication()).getSearchApi().getSearchData("nike");
        searchServiceCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                Gson gson = new GsonBuilder().create();

                JsonObject dataObject = response.body().getAsJsonObject("data");

                SearchResult searchResult = gson.fromJson(dataObject.getAsJsonObject("results"), SearchResult.class);

                Glide.with(getApplicationContext())
                        .load(searchResult.searchProductsList.get(0).searchImage)
                        .into(ivImg);

                tvResultText.setText(searchResult.searchProductsList.get(0).stylename);

                mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
