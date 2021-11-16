package dmitry.mysenko.clean.domain.response

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class GenericError(val throwable: Throwable): ResultWrapper<Nothing>()
}