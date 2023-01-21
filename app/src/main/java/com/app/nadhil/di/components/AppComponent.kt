package com.app.nadhil.di.components

import com.app.nadhil.BaseApplication
import com.app.nadhil.di.modules.ActivitiesModule
import com.app.nadhil.di.modules.ViewModelModule
import com.app.nadhil.di.scopes.ActivityScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ActivityScope
@Component(
    modules = [AndroidInjectionModule::class, ActivitiesModule::class, ViewModelModule::class],
    dependencies = [CoreComponent::class, ArticleComponent::class, NewsSourceComponent::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {
}