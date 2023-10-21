package app.bugit.networklayer.domain.image.repository

import android.net.Uri
import app.bugit.networklayer.data.model.ImageUrlDto
import app.bugit.networklayer.data.model.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ImageRepository {
    fun getImageUrl(imageUri: Uri): Flow<Resource<Response<ImageUrlDto>>>
}