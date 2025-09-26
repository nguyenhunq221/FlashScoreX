package com.vnc.flashscorex.api

import com.vnc.flashscorex.constant.Config
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val DOMAIN_FOOTBALL = Config.BASE_URL
    private fun getClient() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return client
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(DOMAIN_FOOTBALL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}