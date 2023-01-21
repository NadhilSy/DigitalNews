package com.app.nadhil.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.app.nadhil.data.api.response.Article


interface ArticleRepository {
    fun getBySourcePaging(
        source: String, keyword: String?,
        searchIn: String?
    ): LiveData<PagingData<Article>>
}