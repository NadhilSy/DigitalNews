package com.app.nadhil.di.components

import com.app.nadhil.data.repository.ArticleRepository
import com.app.nadhil.di.modules.ArticleModule
import com.app.nadhil.di.scopes.ArticleScope
import dagger.Component

@ArticleScope
@Component(modules = [ArticleModule::class], dependencies = [CoreComponent::class])
interface ArticleComponent {
    fun providerArticleRepository(): ArticleRepository
}