package com.app.nadhil

import com.app.nadhil.di.components.*
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication(){


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .coreComponent(provideCoreComponent())
            .articleComponent(provideArticleComponent())
            .newsSourceComponent(provideNewsSourceComponent())
            .build()
}

    private fun provideCoreComponent(): CoreComponent {
        return DaggerCoreComponent.factory().application(this)
    }

    private fun provideArticleComponent(): ArticleComponent {
        return DaggerArticleComponent.builder().coreComponent(provideCoreComponent()).build()
    }

    private fun provideNewsSourceComponent(): NewsSourceComponent {
        return DaggerNewsSourceComponent.builder().coreComponent(provideCoreComponent()).build()
    }

}