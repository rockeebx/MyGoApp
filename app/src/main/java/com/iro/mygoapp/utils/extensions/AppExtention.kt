package com.iro.mygoapp.utils.extensions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.core.content.ContextCompat
import com.iro.mygoapp.R
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun LoadNetworkImage(
    image: String,
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.FillBounds,
    alignment: Alignment = Alignment.TopStart,
) {
    GlideImage(
        imageModel = image,
        contentScale = contentScale,
        placeHolder = ImageBitmap.imageResource(R.drawable.ic_logo),
        alignment = alignment,
        modifier = modifier
    )
}


fun Context.hasLocationPermission(): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}
