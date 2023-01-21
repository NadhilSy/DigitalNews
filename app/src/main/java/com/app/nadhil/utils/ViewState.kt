package com.app.nadhil.utils

sealed class ViewState<out T>(val data : T? = null, val errorMessage : String? = null) {
    class Success<T>(data: T?) : ViewState<T>(data, null)
    object Loading : ViewState<Nothing>()
    class Error<T>(errorMessage: String?) : ViewState<T>(null, errorMessage)
}