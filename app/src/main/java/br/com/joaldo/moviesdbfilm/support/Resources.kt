package br.com.joaldo.moviesdbfilm.support

data class Resource<T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    companion object{
        fun <T>success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T>erro(message: String): Resource<T> = Resource(Status.ERRO, null, message)
        fun<T>loading(): Resource<T> = Resource(Status.LOADING, null, null)
    }
}
