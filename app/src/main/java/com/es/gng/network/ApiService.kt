package com.es.gng.network

import com.es.gng.data.ItemDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/api/v1/items")
    fun searchItems(@Query("title") query: String): Call<ItemDTO>
}