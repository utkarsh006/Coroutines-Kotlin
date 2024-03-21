package com.example.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {  // creates a blocking coroutine in current (main) thread
    println("Main starts : ${Thread.currentThread().name}")  // main thread

    val time = measureTimeMillis {
        val msgOne: Deferred<String> = async { taskOne()  } /* the line initiates a concurrent execution of taskOne()
                                                             within a coroutine and stores the result (once available) in a 
                                                             Deferred<String> object named msgOne.*/
        val msgTwo: Deferred<String> = async { taskTwo()  }
        println("The entire message : ${msgOne.await() + msgTwo.await()}")
    }

    println("Completed in $time ms")

    println("Main ends : ${Thread.currentThread().name}")   // main thread
}

suspend fun taskOne() : String {
    delay(1000L)   // pretend to do a task for 1s
    return "Hello"
}

suspend fun taskTwo() : String {
    delay(1000L)
    return "World"
}


/* OUTPUT , see the time decreased for executing both suspending functions
Main starts : main
The entire message : HelloWorld
Completed in 1031 ms
Main ends : main

 */
