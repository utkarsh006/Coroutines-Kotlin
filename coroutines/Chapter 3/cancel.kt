package com.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {  // creates a blocking coroutine that executes in current thread (main)

    println("Main starts : ${Thread.currentThread().name}")   // main thread

    val job: Job = launch {
        for(i in 0..50){
            print("$i.")
            delay(50)  /* this function is a part of kotlin.coroutines package which make the coroutine cooperative. If we
                         not use this and isted of this if we use Thread.sleep() then it will not cancel our task even after 
                         including job.cancel() in line 19 and will continue to work un til it finishes its task.*/ 
        }
    }

    delay(200)   // let's print few values before we cancel
    job.cancelAndJoin()

    println("\n Main ends : ${Thread.currentThread().name}")  // main thread
}

/* OUTPUT, some values are printed then the process stops

Main starts : main
0.1.2.3.
Main ends : main
 */


 // Use of Active Flag ------------------------------------------------

 
fun main() = runBlocking {  // creates a blocking coroutine that executes in current thread (main)

    println("Main starts : ${Thread.currentThread().name}")   // main thread

    val job: Job = launch(Dispatchers.Default) {
        for(i in 0..50){
            if(!isActive){
                break
            }
            print("$i.")
            delay(1)
        }
    }

    delay(200)   // let's print few values before we cancel
    job.cancelAndJoin()

    println("\n Main ends : ${Thread.currentThread().name}")  // main thread
}

// If we use return@launch in place off break, no more code inside the coroutine will be launched.


/* OUTPUT
Main starts : main
0.1.2.3.4.5.6.7.8.9.10.11.12.13.14.15.
 Main ends : main
 */
