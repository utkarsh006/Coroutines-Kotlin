package com.example.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {  // creates a blocking coroutine in current (main) thread
    println("Main starts : ${Thread.currentThread().name}")  // main thread

    val time = measureTimeMillis {
        val msgOne = taskOne()
        val msgTwo = taskTwo()
        println("The entire message : ${msgOne + msgTwo}")
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


/* OUTPUT, 1s to execute each suspending function

Main starts : main
The entire message : HelloWorld
Completed in 2038 ms
Main ends : main

 */