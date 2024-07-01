package com.example.worldtriathlon.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("athletes?per_page=10")
    fun getAthleteListings(): Call<AthleteResponse>
}