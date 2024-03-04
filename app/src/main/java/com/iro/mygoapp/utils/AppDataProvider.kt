package com.iro.mygoapp.utils

import com.iro.mygoapp.R


val getWalkData = listOf(
    IntroModel(
        image = R.drawable.ic_logo,
        title = "Brand new \ncurriculum",
        description = "This is the first online education platform designed by the world's top"
    ),
    IntroModel(
        image =  R.drawable.ic_logo,
        title = "Bring a fun \natmosphere",
        description = "This is the first online education platform designed by the world's top"
    ),
    IntroModel(
        image = R.drawable.ic_logo,
        title = "Easy to join \nthe lesson",
        description = "This is the first online education platform designed by the world's top"
    ),
)

data class IntroModel(
    var image: Int,
    var title: String,
    var description: String
)

