package com.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking { //Thread : main

    // Without Parameter : CONFINED DISPATCHER  -------------------------

    launch {
        // inherits the coroutine context of immediate parent

        println("C1 : ${Thread.currentThread().name}")   // Thread : main
        delay(1000)  // use of suspending function doesn't effect the thread
        println("C1 after delay : ${Thread.currentThread().name}")    // Thread : main
    }


    // With Parameter : Dispatchers.Default [similar to GlobalScope.launch {} ]  -------------------------

    launch(Dispatchers.Default) {
        // creates coroutine at the application level and executes on a separate background thread

        println("C2 : ${Thread.currentThread().name}")    // Thread : T1
        delay(1000)
        println("C2 after delay : ${Thread.currentThread().name}")  // Thread : T1 or any other thread
    }

    // With Parameter : Dispatchers.Unconfined [UNCONFINED DISPATCHER]---------------------------------------

    launch(Dispatchers.Unconfined) {

        // inherits the coroutine context of immediate parent
        println("C3 : ${Thread.currentThread().name}")   // Thread : main
        delay(1000)
        println("C3 after delay : ${Thread.currentThread().name}")  // Thread : some other thread
    }

    // use coroutineContext property to flow context from parent to child

    launch(coroutineContext) {  // parent of this coroutine is runBlocking
        
        println("C4 : ${Thread.currentThread().name}")   // Thread : main
        delay(1000)
        println("C4 after delay : ${Thread.currentThread().name}")  // Thread : main
    }

    println("Main Program")
}