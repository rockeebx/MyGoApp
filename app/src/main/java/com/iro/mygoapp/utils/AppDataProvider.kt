package com.iro.mygoapp.utils

import com.iro.mygoapp.R


val getWalkData = listOf(
    IntroModel(
        image = R.drawable.ic_logo,
        title = "Real-time \nlocation tracking",
        description = "Stay connected and share your location with friends and family."
    ),
    IntroModel(
        image = R.drawable.ic_logo,
        title = "Share your \nprecise location",
        description = "Easily share your exact location with others for meetups and gatherings."
    ),
    IntroModel(
        image = R.drawable.ic_logo,
        title = "Track your \nfriends and family",
        description = "Keep an eye on your loved ones and know their whereabouts at all times."
    )
)

data class IntroModel(
    var image: Int,
    var title: String,
    var description: String
)

