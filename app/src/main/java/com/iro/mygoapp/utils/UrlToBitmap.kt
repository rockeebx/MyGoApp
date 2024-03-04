package com.iro.mygoapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

suspend fun urlToBitmap(
    scope: CoroutineScope,
    imageURL: String,
    context: Context
): Bitmap? {
    val deferred = CompletableDeferred<Bitmap?>()
    scope.launch(Dispatchers.IO) {
        val loader = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data(imageURL)
            .allowHardware(false)
            .build()
        val result = loader.execute(request)
        if (result is SuccessResult) {
            val bitmap = (result.drawable as BitmapDrawable).bitmap
            deferred.complete(bitmap)
        } else {
            deferred.complete(null)
        }
    }
    return deferred.await()
}


