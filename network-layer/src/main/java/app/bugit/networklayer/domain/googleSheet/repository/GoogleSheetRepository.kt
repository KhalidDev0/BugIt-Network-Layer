package app.bugit.networklayer.domain.googleSheet.repository

import app.bugit.networklayer.data.model.BugUploadDto
import app.bugit.networklayer.data.model.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface GoogleSheetRepository {
    fun uploadBugToGoogleSheet(title: String, description: String, imageUrl: String): Flow<Resource<Response<BugUploadDto>>>
}