package app.bugit.networklayer.domain.googleSheet.useCase

import app.bugit.networklayer.data.model.BugUploadDto
import app.bugit.networklayer.data.model.Resource
import app.bugit.networklayer.domain.googleSheet.repository.GoogleSheetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UploadBugToGoogleSheetUseCase(
    private val googleSheetRepository: GoogleSheetRepository
) {

    operator fun invoke(title: String, description: String, imageUrl: String): Flow<Resource<BugUploadDto>> = flow {
        googleSheetRepository.uploadBugToGoogleSheet(title, description, imageUrl).collect { resource ->
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