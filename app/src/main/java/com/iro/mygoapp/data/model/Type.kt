package com.iro.mygoapp.data.model


enum class SectionType {
    PROFILE,
    MAP,
    DATA
}

fun String.toSectionType(): SectionType? {
    return when (this) {
        "profile" -> SectionType.PROFILE
        "map" -> SectionType.MAP
        "data" -> SectionType.DATA
        else -> null
    }
}