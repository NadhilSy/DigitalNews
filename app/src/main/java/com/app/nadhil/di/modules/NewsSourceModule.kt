package com.app.nadhil.di.modules

import com.app.nadhil.data.repository.NewsSourceRepository
import com.app.nadhil.data.repository.NewsSourceRepositoryImpl
import com.app.nadhil.di.scopes.NewsSourceScope
import dagger.Binds
import dagger.Module

@Module
abstract class NewsSourceModule {
    @Binds
    @NewsSourceScope
    abstract fun bindsNewsSourceModule (newsSourceRepositoryImpl: NewsSourceRepositoryImpl) : NewsSourceRepository
}