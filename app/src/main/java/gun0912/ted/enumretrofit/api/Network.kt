package gun0912.ted.enumretrofit.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createApiService(): ApiService =

    Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addConverterFactory(EnumConverterFactory())
        .build()
        .create(ApiService::class.java)

