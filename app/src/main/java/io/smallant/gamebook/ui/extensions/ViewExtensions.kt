package io.smallant.gamebook.ui.extensions

import android.view.View

inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if(value) View.VISIBLE else View.GONE }

inline var View.isInsivible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) { visibility = if(value) View.INVISIBLE else View.VISIBLE }

inline var View.isGone: Boolean
    get() = visibility == View.GONE
    set(value) { visibility = if(value) View.GONE else View.VISIBLE }