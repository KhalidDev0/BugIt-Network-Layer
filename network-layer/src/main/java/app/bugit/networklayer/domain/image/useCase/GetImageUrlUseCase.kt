package app.bugit.networklayer.domain.image.useCase

import android.net.Uri
import app.bugit.networklayer.data.model.ImageUrlDto
import app.bugit.networklayer.data.model.Resource
import app.bugit.networklayer.domain.image.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetImageUrlUseCase(
    private val imageRepository: ImageRepository
) {

    operator fun invoke(imageUri: Uri): Flow<Resource<ImageUrlDto>> = flow {
        imageRepository.getImageUrl(imageUri).collect { resource ->
            when (resource) {
                is Resource.Loading -> {
                    emit(Resource.Loading())
                }
                is Resource.Success -> {
                    emit(Resource.Success(resource.data.body()!!))
                }
                is Resource.Error -> {
                    emit(Resource.Error(resource.error))
                }
            }
        }
    }
}