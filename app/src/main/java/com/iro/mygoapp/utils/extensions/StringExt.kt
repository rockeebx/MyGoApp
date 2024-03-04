package com.iro.mygoapp.utils.extensions

import android.util.Log

// String null check extension
fun String?.validate(value: String = ""): String {
    return this ?: value
}

//Log
fun String.log(debugKey: String = "Value"): Int {
    return Log.d(debugKey, this)
}

