package app.bugit.networklayer.domain.googleSheet.di

import app.bugit.networklayer.data.remote.GoogleSheetApi
import app.bugit.networklayer.data.repository.GoogleSheetRepositoryImp
import app.bugit.networklayer.data.utils.NetworkUtilities
import app.bugit.networklayer.domain.googleSheet.repository.GoogleSheetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GoogleSheetRepositoryModule {

    @Provides
    @Singleton
    fun provideGoogleSheetRepository(
        networkUtilities: NetworkUtilities,
        googleSheetApi: GoogleSheetApi
    ): GoogleSheetRepository = GoogleSheetRepositoryImp(networkUtilities, googleSheetApi)
}