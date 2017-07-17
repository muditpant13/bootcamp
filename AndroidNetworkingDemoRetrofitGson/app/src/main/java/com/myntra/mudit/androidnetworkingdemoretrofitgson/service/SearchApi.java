package com.myntra.mudit.androidnetworkingdemoretrofitgson.service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * @author mudit.pant on 14/07/17.
 */

public interface SearchApi {

    @GET("v2/search/data/{query}")
    Call<JsonObject> getSearchData(@Path("query") String query);

}
