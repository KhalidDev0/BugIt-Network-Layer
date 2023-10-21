package app.bugit.networklayer.domain.image.di

import app.bugit.networklayer.data.remote.ImageApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object ImageApiModule {

    @Provides
    fun provideImageApi(
        @Named("ImageRetrofit") retrofit: Retrofit
    ): ImageApi = retrofit.create(ImageApi::class.java)
}