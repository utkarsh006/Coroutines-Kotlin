package com.example.coroutines

import kotlinx.coroutines.*


fun main() = runBlocking {  // creates a blocking coroutine in current (main) thread
    println("Main starts : ${Thread.currentThread().name}")  // main thread

        val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { taskOne()  }
        val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { taskTwo()  }
        //println("The entire message : ${msgOne.await() + msgTwo.await()}")


    println("Main ends : ${Thread.currentThread().name}")   // main thread
}

suspend fun taskOne() : String {
    delay(1000L)   // pretend to do a task for 1s
    println("After working in taskOne()")
    return "Hello"
}

suspend fun taskTwo() : String {
    delay(1000L)
    println("After working in taskTwo()")
    return "World"
}


/* OUTPUT, the last two suspending functions are not executed since we are not using msgOne and msgTwo 
in our code. If we use these values (uncomment next line) then only the two async coroutines 
will get executed.

Main starts : main
Main ends : main

 */