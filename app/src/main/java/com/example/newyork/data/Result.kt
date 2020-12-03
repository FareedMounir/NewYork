package com.example.newyork.data

sealed class Result<out T : Any>
class Success<out T : Any>(val data: T) : Result<T>()
class Fail(val exception: Exception) : Result<Nothing>()