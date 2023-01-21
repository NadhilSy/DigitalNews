package com.app.nadhil.data.repository

import android.util.Log
import com.app.nadhil.data.api.NewsApi
import com.app.nadhil.data.api.response.Source
import javax.inject.Inject

class NewsSourceRepositoryImpl @Inject constructor(private val newsApi: NewsApi) :
    NewsSourceRepository {
    override suspend fun getByCategory(category: String): List<Source> {
        try {
            val response =
                newsApi.getSourceByCategory(category, "en")
            if (response.isSuccessful) {
                response.body().let {
                    return response.body()!!.sources
                }
            } else {
                throw Exception("Request can not be processed")
            }
        } catch (e: Exception) {
            e.message?.let { Log.d("News API ", it) }
            throw Exception(e.message)
        }
    }
}