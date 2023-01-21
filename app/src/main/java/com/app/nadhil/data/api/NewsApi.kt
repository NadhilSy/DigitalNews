package com.app.nadhil.data.api

import com.app.nadhil.data.api.response.NewsResponse
import com.app.nadhil.data.api.response.NewsSourceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getHeadlineNews(
        @Query("sources") source: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ) : Response<NewsResponse>

    @GET("everything")
    suspend fun searchHeadlineNews(
        @Query("sources") source: String,
        @Query("q") keyword: String,
        @Query("searchIn") searchIn: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ) : Response<NewsResponse>

    @GET("sources")
    suspend fun getSourceByCategory(
        @Query("category") category: String,
        @Query("language") language: String
    ) : Response<NewsSourceResponse>
}