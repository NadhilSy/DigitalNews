package com.app.nadhil.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.nadhil.data.api.NewsApi
import com.app.nadhil.data.api.response.Article
import com.app.nadhil.data.api.response.NewsResponse
import retrofit2.Response

class ArticlePaging (
    private val source: String,
    private val keyword: String?,
    private val searchIn: String?,
    private val service: NewsApi
    ) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val pageNumber = params.key ?: 1
        return try {
            val response: Response<NewsResponse> = if (keyword == null){
                service.getHeadlineNews(source, pageNumber, 15)
            } else {
                service.searchHeadlineNews(source, keyword, searchIn ?: "title,description",pageNumber, 15)
            }
            var nextKey : Int? = null
            if (response.isSuccessful){
                response.body()?.let {
                    nextKey = if (response.body()!!.articles.isEmpty()){
                        null
                    } else {
                        pageNumber + 1
                    }
                }
                Log.d("Next key Article", nextKey.toString())
            } else {
                throw Exception("Request can not be processed")
            }
            return LoadResult.Page(
                data = response.body()!!.articles,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception){
            e.message?.let { Log.d("News API ", it) }
            LoadResult.Error(e)
        }

    }

}