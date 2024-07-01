package com.example.worldtriathlon.data

import com.example.worldtriathlon.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://api.triathlon.org/v1/"

    private val httpClient: OkHttpClient
        get(){
            val clientBuilder = OkHttpClient.Builder()
            val apikey = BuildConfig.apikey
            clientBuilder.addInterceptor{ chain ->
                val original: Request = chain.request()
                val requestBuilder: Request.Builder = original.newBuilder()
                    .header("apikey", apikey)
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
            return clientBuilder.build()
        }

    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}