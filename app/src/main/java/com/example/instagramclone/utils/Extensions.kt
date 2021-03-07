package com.example.instagramclone.utils

fun String?.isJsonObject():Boolean {
    if(this?.startsWith("{") == true && this?.endsWith("}")){
        return true
    }else{
        return false
    }
}

fun String?.isJsonArray() : Boolean {
    if(this?.startsWith("[") == true && this.endsWith("]")){
        return true
    } else {
        return false
    }
}
