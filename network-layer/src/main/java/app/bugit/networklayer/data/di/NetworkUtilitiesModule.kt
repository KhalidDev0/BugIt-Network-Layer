package app.bugit.networklayer.data.di

import android.content.Context
import app.bugit.networklayer.data.utils.NetworkUtilities
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkUtilitiesModule {

    @Provides
    @Singleton
    fun provideNetworkUtilities(
        @ApplicationContext context: Context
    ): NetworkUtilities =
        NetworkUtilities(context)
}