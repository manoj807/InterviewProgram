package com.valleytech.interviewprogram.kotlin_dda

sealed class MyResult
{
    data class Success<T>(val data: T) : MyResult()
    data class Error(val exception: Exception) : MyResult()
    object Loading : MyResult()
}

object Data : MyResult();

fun getData(myResult: MyResult): MyResult? {
    // Simulating a data fetch operation
    return when(myResult) {
        is MyResult.Success<*> -> {
            // Process the success case
            println("Data fetched successfully: ${myResult.data}")
            myResult
        }
        is MyResult.Error -> {
            // Handle the error case
            println("Error occurred: ${myResult.exception.message}")
            myResult
        }

        else
        -> null


    }
}


