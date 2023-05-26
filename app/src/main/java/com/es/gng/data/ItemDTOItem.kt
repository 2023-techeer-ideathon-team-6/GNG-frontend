package com.es.gng.data


import com.google.gson.annotations.SerializedName

data class ItemDTOItem(
    @SerializedName("itemId")
    val itemId: Int,
    @SerializedName("maxBid")
    val maxBid: Int,
    @SerializedName("starCount")
    val starCount: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)