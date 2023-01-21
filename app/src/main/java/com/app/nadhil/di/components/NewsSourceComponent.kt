package com.app.nadhil.di.components

import com.app.nadhil.data.repository.NewsSourceRepository
import com.app.nadhil.di.modules.NewsSourceModule
import com.app.nadhil.di.scopes.NewsSourceScope
import dagger.Component

@NewsSourceScope
@Component(modules = [NewsSourceModule::class], dependencies = [CoreComponent::class])
interface NewsSourceComponent {
    fun provideNewsSourceRepository() : NewsSourceRepository
}