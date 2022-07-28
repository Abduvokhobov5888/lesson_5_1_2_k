package com.example.a512k

import kotlin.properties.Delegates

class ItemModel(var lottieId: Int, var title: String, var description: String ) {

    @JvmName("getDescription1")
    fun getDescription(): String {
        return description
    }

    @JvmName("getTitle1")
    fun getTitle(): String {
        return title
    }

    @JvmName("getLottieId1")
    fun getLottieId(): Int {
        return lottieId
    }
}