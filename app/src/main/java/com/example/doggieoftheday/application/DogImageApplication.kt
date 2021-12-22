package com.example.doggieoftheday.application

import android.app.Application
import com.example.doggieoftheday.data.ImageDatabase
import kotlinx.coroutines.InternalCoroutinesApi

class ImageApplication : Application ()  {
    @InternalCoroutinesApi
    val databse: ImageDatabase by lazy {
        ImageDatabase.getDatabase(this )
    }
}