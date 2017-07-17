package com.myntra.mudit.androidnetworkingdemoretrofitgson.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author mudit.pant on 14/07/17.
 */

public class SearchResult {

    @SerializedName("products")
    public List<SearchProducts> searchProductsList;

}
