package com.iro.mygoapp.data.model


data class SectionModel(
    val type: String,
    val content: Content
) {
    data class Content(
        val image: String? = null,
        val name: String? = null,
        val email: String? = null,
        val title: String? = null,
        val pin: String? = null,
        val lat: Double? = null,
        val lng: Double? = null,
        val source: String? = null,
        val value: String? = null
    )
}
