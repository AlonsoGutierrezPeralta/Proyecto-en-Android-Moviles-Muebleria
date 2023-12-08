package com.example.mantenedores.entity.data

sealed class ResultJSON<out T> {
    data class Exito<out T: Any>(val data: T) : ResultJSON<T>()
    data class Problema(val error : Error) : ResultJSON<Nothing>()
}