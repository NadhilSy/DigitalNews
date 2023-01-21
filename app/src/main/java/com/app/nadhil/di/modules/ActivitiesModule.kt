package com.app.nadhil.di.modules

import com.app.nadhil.di.scopes.ArticleScope
import com.app.nadhil.di.scopes.NewsSourceScope
import com.app.nadhil.ui.MainActivity
import com.app.nadhil.ui.article.ArticleFragment
import com.app.nadhil.ui.newssource.NewsSourceFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @NewsSourceScope
    @ContributesAndroidInjector
    abstract fun contributeNewsSourceFragment(): NewsSourceFragment

    @ArticleScope
    @ContributesAndroidInjector
    abstract fun contributeArticleFragment(): ArticleFragment
}