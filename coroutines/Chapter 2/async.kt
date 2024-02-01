package com.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking{

        println("Main starts : ${Thread.currentThread().name}")  // runs on main thread

        val jobDeferred : Deferred<Int> = async{    // Thread main
            println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on main
            delay(1000)  // coroutine is suspended but thread main is free
            println("Fake work ends : ${Thread.currentThread().name}") // This statement can runs on any thread
            20
        }

        // if we want to use 20 in our code then use await function
        jobDeferred.await()
       //jobDeferred.join()
        println("Main ends : ${Thread.currentThread().name}")  // runs on main thread
    
    // await and join are suspending functions, they can be called within coroutines.

}
