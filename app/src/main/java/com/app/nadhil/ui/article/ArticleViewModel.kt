package com.app.nadhil.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.app.nadhil.data.api.response.Article
import com.app.nadhil.data.repository.ArticleRepository
import javax.inject.Inject

class ArticleViewModel @Inject constructor(private val newsRepository: ArticleRepository) : ViewModel() {
    var keyword : String? = null

    fun getArticleBySource(
        sourceId : String,
        keyword : String?,
        searchIn : String?
    ) : LiveData<PagingData<Article>> {
        return newsRepository.getBySourcePaging(sourceId, keyword, searchIn)
    }
}