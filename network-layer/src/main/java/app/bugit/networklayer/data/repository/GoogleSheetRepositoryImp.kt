package app.bugit.networklayer.data.repository

import app.bugit.networklayer.data.model.BugUploadDto
import app.bugit.networklayer.data.model.Resource
import app.bugit.networklayer.data.remote.GoogleSheetApi
import app.bugit.networklayer.data.utils.NetworkUtilities
import app.bugit.networklayer.domain.googleSheet.repository.GoogleSheetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class GoogleSheetRepositoryImp @Inject constructor(
    private val networkUtilities: NetworkUtilities,
    private val googleSheetApi: GoogleSheetApi
): GoogleSheetRepository {

    override fun uploadBugToGoogleSheet(title: String, description: String, imageUrl: String): Flow<Resource<Response<BugUploadDto>>> = flow {
        networkUtilities.safeApiCall {
            googleSheetApi.uploadBugToGoogleSheet(title, description, imageUrl)
        }.collect { results -> emit(results) }
    }
}