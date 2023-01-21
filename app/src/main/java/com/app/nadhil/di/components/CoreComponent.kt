package com.app.nadhil.di.components

import android.app.Application
import com.app.nadhil.data.api.NewsApi
import com.app.nadhil.di.modules.CoreModule
import com.bumptech.glide.RequestManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {
    fun newsApi(): NewsApi
    fun glideRequestManager(): RequestManager

    @Component.Factory
    interface Factory {
        fun application(@BindsInstance app: Application) : CoreComponent
    }
}