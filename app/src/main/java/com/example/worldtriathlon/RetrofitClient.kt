package com.example.worldtriathlon

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.triathlon.org/v1/"

object RetrofitClient {

    private val httpClient: OkHttpClient
        get(){
            val clientBuilder = OkHttpClient.Builder()
            val apikey = ""
            clientBuilder.addInterceptor{ chain ->
                val original: Request = chain.request()
                val requestBuilder: Request.Builder = original.newBuilder()
                    .header("accept", "application/json $apikey")
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