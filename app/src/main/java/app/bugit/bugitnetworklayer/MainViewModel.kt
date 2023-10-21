package app.bugit.bugitnetworklayer

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.bugit.networklayer.data.model.Resource
import app.bugit.networklayer.domain.image.useCase.GetImageUrlUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getImageUrlUseCase: GetImageUrlUseCase
): ViewModel() {

    fun getImageUrl(imageUri: Uri?){
        if (imageUri == null) return

        getImageUrlUseCase(imageUri).onEach { resource ->
            when(resource){
                is Resource.Loading -> Log.d("Test", "Loading image")
                is Resource.Success -> Log.d("Test", resource.data.toString())
                is Resource.Error -> Log.d("Test", resource.error.toString())
            }
        }.launchIn(viewModelScope)
    }
}