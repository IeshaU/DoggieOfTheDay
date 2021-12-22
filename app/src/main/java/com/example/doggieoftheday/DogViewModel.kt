package com.example.doggieoftheday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doggieoftheday.network.DogPhoto
import com.example.doggieoftheday.network.DogPhotoApi
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    val dogPhoto: Any
        get() {
            TODO()
        }
}

val _dogPhoto = MutableLiveData<DogPhoto>()
    val dogPhoto: LiveData<DogPhoto> = _dogPhoto

    private val _status = MutableLiveData<String>()
    val status:LiveData<String> = _status

    fun getNewPhoto() {
        try {
            val viewModelScope = null
            viewModelScope?.launch {
                _dogPhoto.value = DogPhotoApi.retrofitService.getRandomPhoto()
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }

    fun getPhotoByBreed(breedType: String?) {
        try {
            val viewModelScope = null
            viewModelScope?.launch {
                val response = DogPhotoApi.retrofitService.getPhotoByBreed(breedType!!)
                _dogPhoto.value = response!!
                _status.value = response?.statusResponse!!
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }