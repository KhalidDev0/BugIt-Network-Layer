package app.bugit.networklayer.data.remote

import app.bugit.networklayer.data.model.BugUploadDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleSheetApi {

    @GET("exec")
    suspend fun uploadBugToGoogleSheet(
        @Query("title") title: String,
        @Query("description") description: String,
        @Query("imageUrl") imageUrl: String
    ): Response<BugUploadDto>
}