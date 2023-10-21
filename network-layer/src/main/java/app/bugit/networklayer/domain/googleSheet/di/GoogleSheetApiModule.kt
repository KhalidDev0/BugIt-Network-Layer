package app.bugit.networklayer.domain.googleSheet.di

import app.bugit.networklayer.data.remote.GoogleSheetApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object GoogleSheetApiModule {

    @Provides
    fun provideGoogleSheetApiModule(retrofit: Retrofit): GoogleSheetApi = retrofit.create(GoogleSheetApi::class.java)
}