package com.myntra.mudit.androidnetworkingdemoretrofitgson;

import android.app.Application;

import com.myntra.mudit.androidnetworkingdemoretrofitgson.service.SearchApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author mudit.pant on 14/07/17.
 */

public class NetworkingApplication extends Application {

    private static String BASE_URL = "http://developer.myntra.com";

    private Retrofit mRetrofit;

    private SearchApi mSearchApi;

    @Override
    public void onCreate() {

        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mSearchApi = mRetrofit.create(SearchApi.class);

    }

    public SearchApi getSearchApi(){
        return mSearchApi;
    }
}
