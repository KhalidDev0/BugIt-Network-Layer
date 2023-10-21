package app.bugit.networklayer.domain.image.di

import android.content.Context
import app.bugit.networklayer.data.remote.ImageApi
import app.bugit.networklayer.data.repository.ImageRepositoryImp
import app.bugit.networklayer.data.utils.NetworkUtilities
import app.bugit.networklayer.domain.image.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImageRepositoryModule {

    @Provides
    @Singleton
    fun provideImageRepository(
        networkUtilities: NetworkUtilities,
        imageApi: ImageApi,
        @ApplicationContext context: Context,
    ): ImageRepository = ImageRepositoryImp(networkUtilities, imageApi, context)
}