package app.bugit.networklayer.data.remote

import app.bugit.networklayer.data.model.ImageUrlDto
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ImageApi {

    @Multipart
    @POST("upload")
    suspend fun getImageUrl(
        @Query("key") apiKey: String = "b06754b1c306f876b420b94bb984b24c",
        @Part imageFormData: MultipartBody.Part
    ): Response<ImageUrlDto>
}