package com.app.nadhil.di.modules

import com.app.nadhil.data.repository.ArticleRepository
import com.app.nadhil.data.repository.ArticleRepositoryImpl
import com.app.nadhil.di.scopes.ArticleScope
import dagger.Binds
import dagger.Module

@Module
abstract class ArticleModule {
    @Binds
    @ArticleScope
    abstract fun bindsArticleModule(articleRepositoryImpl: ArticleRepositoryImpl) : ArticleRepository
}