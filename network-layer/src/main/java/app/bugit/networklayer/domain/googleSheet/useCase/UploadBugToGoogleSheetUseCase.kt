package app.bugit.networklayer.domain.googleSheet.useCase

import app.bugit.networklayer.data.model.BugUploadDto
import app.bugit.networklayer.data.model.Resource
import app.bugit.networklayer.domain.googleSheet.repository.GoogleSheetRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class UploadBugToGoogleSheetUseCase(
    private val googleSheetRepository: GoogleSheetRepository
) {

    operator fun invoke(title: String, description: String, imageUrl: String): Flow<Resource<Response<BugUploadDto>>> {
        return googleSheetRepository.uploadBugToGoogleSheet(title, description, imageUrl)
    }
}