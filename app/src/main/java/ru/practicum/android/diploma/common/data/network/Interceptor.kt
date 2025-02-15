package ru.practicum.android.diploma.common.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.practicum.android.diploma.BuildConfig


val headerInterceptor = Interceptor { chain ->
    val originalRequest = chain.request()
    val modifiedRequest = originalRequest.newBuilder()
        .addHeader("Authorization", "Bearer ${BuildConfig.HH_ACCESS_TOKEN}")
        .addHeader("HH-User-Agent", "Practicum HH Client/1.0 (zod15ru@gmail.com)")
        .build()
    chain.proceed(modifiedRequest)
}

val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(headerInterceptor)
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.hh.ru/")
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val headHunterApi = retrofit.create(HeadHunterApi::class.java)

