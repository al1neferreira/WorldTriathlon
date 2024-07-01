package com.example.worldtriathlon.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.worldtriathlon.data.ApiService
import com.example.worldtriathlon.data.AthleteModel
import com.example.worldtriathlon.data.AthleteResponse
import com.example.worldtriathlon.data.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun AthletesListScreen() {
     var athleteListings by remember {
         mutableStateOf<List<AthleteModel>>(emptyList())
     }

    val apiService = RetrofitClient.retrofitInstance.create(ApiService::class.java)
    val callAthleteListings = apiService.getAthleteListings()

    callAthleteListings.enqueue(object : Callback<AthleteResponse> {
        override fun onResponse(call: Call<AthleteResponse>, response: Response<AthleteResponse>) {
            if (response.isSuccessful){
                val athlete = response.body()?.data
                if(athlete != null){
                    athleteListings = athlete
                    Log.d("MainActivity", "${response.body()}")
                }
            } else{
                Log.d("MainActivity", "Request Error:: ${response.errorBody()}")
            }
        }

        override fun onFailure(call: Call<AthleteResponse>, t: Throwable) {
            Log.d("MainActivity", "Network Error :: ${t.message}")
        }
    })
}


