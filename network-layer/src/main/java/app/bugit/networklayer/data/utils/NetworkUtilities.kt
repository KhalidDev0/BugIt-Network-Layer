package app.bugit.networklayer.data.utils

import android.content.Context
import android.net.ConnectivityManager
import app.bugit.networklayer.data.model.ApiError
import app.bugit.networklayer.data.model.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkUtilities @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    private fun isOnline(): Boolean {
        val connectivityManager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) != null
    }

    fun <T : Any> safeApiCall(
        apiToBeCalled: suspend () -> T,
    ): Flow<Resource<T>> = flow {
        try {
            if (!isOnline())
                return@flow emit(Resource.Error(
                    ApiError(
                        NetworkError.NO_INTERNET.code, context.getString(
                            androidx.appcompat.R.string.abc_action_bar_home_description
                        )
                    )
                ))

            emit(Resource.Loading())

            val response = apiToBeCalled()
            emit(Resource.Success(response))

        } catch (ex: Exception) {
            emit(
                Resource.Error(
                    ApiError(
                        NetworkError.UNKNOWN_ERROR.code, context.getString(
                            androidx.appcompat.R.string.abc_action_bar_home_description
                        )
                    )
                )
            )
        }
    }

    enum class NetworkError(val code: Int) {
        NO_INTERNET(1000),
        UNKNOWN_ERROR(3000),
    }
}