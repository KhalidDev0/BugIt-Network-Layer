package app.bugit.networklayer.data.model

sealed class Resource<T : Any>{
    class Loading<T : Any> : Resource<T>()
    data class Success<T : Any>(val data: T) : Resource<T>()
    data class Error<T : Any>(val error: ApiError) : Resource<T>()
}
