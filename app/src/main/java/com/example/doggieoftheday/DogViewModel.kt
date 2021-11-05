package com.example.doggieoftheday

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doggieoftheday.network.DogPhoto
import com.example.doggieoftheday.network.DogPhotoApi
import kotlinx.coroutines.launch

class DogViewModel: ViewModel() {
    private val _dogPhoto = MutableLiveData<DogPhoto>()
    val dogPhoto: LiveData<DogPhoto> = _dogPhoto

    init {
        getNewPhoto()
    }

    fun getNewPhoto() {
        viewModelScope.launch {
            try {
                _dogPhoto.value = DogPhotoApi.retrofitService.getRandomPhoto()
            } catch (e: Exception) {
                Log.e("DogViewModel", "Error occurred: ${e.message}")
            }
        }
    }


}