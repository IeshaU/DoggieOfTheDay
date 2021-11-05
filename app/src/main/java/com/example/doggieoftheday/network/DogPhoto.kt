package com.example.doggieoftheday.network

import com.squareup.moshi.Json

data class DogPhoto (

    @Json(name = "message") val imageUrl: String?,
    @Json(name = "status") val statusResponse: String?

        )