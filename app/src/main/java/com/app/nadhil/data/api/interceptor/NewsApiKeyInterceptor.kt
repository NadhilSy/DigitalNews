package com.app.nadhil.data.api.interceptor


import com.app.nadhil.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NewsApiKeyInterceptor @Inject constructor() : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url

        val url = originalHttpUrl.newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build()
        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}