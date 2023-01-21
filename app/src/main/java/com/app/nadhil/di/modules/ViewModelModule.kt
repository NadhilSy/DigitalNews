package com.app.nadhil.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.nadhil.di.ViewModelKey
import com.app.nadhil.ui.ViewModelFactory
import com.app.nadhil.ui.article.ArticleViewModel
import com.app.nadhil.ui.newssource.NewsSourceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewsSourceViewModel::class)
    abstract fun bindNewsSourceViewModel(newsSourceViewModel: NewsSourceViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    abstract fun bindArticleViewModel(articleViewModel: ArticleViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}