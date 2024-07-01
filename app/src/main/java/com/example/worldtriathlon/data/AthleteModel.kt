package com.example.worldtriathlon.data

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class AthleteModel(
    @SerializedName("athlete_id")
    val id: Int,
    @SerializedName("athlete_title")
    val title: String,
    @SerializedName("athlete_gender")
    val gender: String,
    @SerializedName("athlete_categories")
    val category: String,
    @SerializedName("athlete_country_name")
    val country: String,
    @SerializedName("athlete_profile_image")
    val profileImage: String,
    @SerializedName("athlete_flag")
    val flag: String
)
