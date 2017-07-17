package com.myntra.mudit.androidnetworkingdemoretrofitgson.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author mudit.pant on 14/07/17.
 */

public class SearchProducts {

    @SerializedName("discount")
    public Integer discount;

    @SerializedName("brands_filter_facet")
    public String brandsFilterFacet;

    @SerializedName("search_image")
    public String searchImage;

    @SerializedName("discounted_price")
    public Integer discountedPrice;

    @SerializedName("gender_from_cms")
    public String genderFromCms;

    @SerializedName("score")
    public Integer score;

    @SerializedName("sizes")
    public String sizes;

    @SerializedName("price")
    public Integer price;

    @SerializedName("product_additional_info")
    public String productAdditionalInfo;

    @SerializedName("stylename")
    public String stylename;

    @SerializedName("id")
    public String id;

    @SerializedName("style_store1_sort_field")
    public Integer styleStore1SortField;

    @SerializedName("product")
    public String product;

    @SerializedName("dre_landing_page_url")
    public String dreLandingPageUrl;

    @SerializedName("global_attr_article_type")
    public String globalAttrArticleType;

    @SerializedName("global_attr_brand")
    public String globalAttrBrand;

    @SerializedName("image_entries")
    public List<String> imageEntries = null;

    @SerializedName("global_attr_base_colour")
    public String globalAttrBaseColour;

    @SerializedName("imageEntry_default")
    public String imageEntryDefault;

    @SerializedName("colour_variant")
    public Boolean colourVariant;

    @SerializedName("styleid")
    public Integer styleid;

    @SerializedName("allSkuForSizes")
    public List<String> allSkuForSizes = null;

    @SerializedName("global_attr_colour1")
    public String globalAttrColour1;

    @SerializedName("dre_discount_label")
    public String dreDiscountLabel;

    @SerializedName("discount_label")
    public String discountLabel;

}
