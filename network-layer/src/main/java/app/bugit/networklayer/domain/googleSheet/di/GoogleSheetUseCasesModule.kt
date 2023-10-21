package app.bugit.networklayer.domain.googleSheet.di

import app.bugit.networklayer.domain.googleSheet.repository.GoogleSheetRepository
import app.bugit.networklayer.domain.googleSheet.useCase.UploadBugToGoogleSheetUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GoogleSheetUseCasesModule {

    @Provides
    @Singleton
    fun provideUploadBugToGoogleSheetUseCase(
        googleSheetRepository: GoogleSheetRepository
    ): UploadBugToGoogleSheetUseCase =
        UploadBugToGoogleSheetUseCase(googleSheetRepository)
}