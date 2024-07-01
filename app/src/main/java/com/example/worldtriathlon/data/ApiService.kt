package com.example.worldtriathlon.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("athletes?per_page=10")
    fun getAthleteListings(@Query("elite") elite: Boolean = true
    ): Call<AthleteResponse>
}