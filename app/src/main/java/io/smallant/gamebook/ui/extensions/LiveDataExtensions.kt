package io.smallant.gamebook.ui.extensions

import androidx.lifecycle.LiveData
import io.smallant.gamebook.ui.utils.observer.MultilpleTimeObserver
import io.smallant.gamebook.ui.utils.observer.OneTimeObserver

fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
    val observer = OneTimeObserver(handler = onChangeHandler)
    observe(observer, observer)
}

fun <T> LiveData<T>.observeInfinite(onChangeHandler: (T) -> Unit) {
    val observer = MultilpleTimeObserver(handler = onChangeHandler)
    observe(observer, observer)
}
