package com.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {  // creates a blocking coroutine that executes in current thread (main)

    println("Main starts : ${Thread.currentThread().name}")   // main thread

    val job: Job = launch(Dispatchers.Default) {

        try {
            for (i in 0..50) {
                print("$i.")
                delay(5)
            }
        } catch (ex: CancellationException){
            print("\n Exception caught safely") /* the suspending functions from kotlin.coroutines package will always throws
                                                   an exception  */
        } finally {
            print("\n Close resources in finally")
        }

    }

    delay(200)   // let's print few values before we cancel
    job.cancelAndJoin()

    println("\n Main ends : ${Thread.currentThread().name}")  // main thread
}


/* OUTPUT

Main starts : main
0.1.2.3.4.5.6.7.8.9.10.11.12.13.14.
 Exception caught safely
 Close resources in finally
 Main ends : main

 */
