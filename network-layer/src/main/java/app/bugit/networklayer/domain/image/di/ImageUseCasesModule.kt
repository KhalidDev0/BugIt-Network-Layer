package app.bugit.networklayer.domain.image.di

import app.bugit.networklayer.domain.image.repository.ImageRepository
import app.bugit.networklayer.domain.image.useCase.GetImageUrlUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImageUseCasesModule {

    @Provides
    @Singleton
    fun provideGetImageUrlUseCase(
        imageRepository: ImageRepository
    ): GetImageUrlUseCase =
        GetImageUrlUseCase(imageRepository)
}