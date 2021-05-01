package com.example.instagramclone.utils

fun String?.isJsonObject():Boolean {
    return this?.startsWith("{") == true && this?.endsWith("}")
}

fun String?.isJsonArray() : Boolean {
    return this?.startsWith("[") == true && this.endsWith("]")
}
