package com.app.nadhil.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.app.nadhil.data.api.NewsApi
import com.app.nadhil.data.api.response.Article
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : ArticleRepository {
    override fun getBySourcePaging(
        source: String, keyword: String?,
        searchIn: String?
    ): LiveData<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 15, enablePlaceholders = false, initialLoadSize = 2),
            pagingSourceFactory = {
                ArticlePaging(source, keyword, searchIn, newsApi)
            }, initialKey = 1
        ).liveData
    }

}