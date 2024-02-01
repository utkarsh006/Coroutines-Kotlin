package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{

        println("Main starts : ${Thread.currentThread().name}")  // runs on main thread

        launch{    // Thread main
            println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on main
            helper(1000)  // coroutine is suspended but thread main is free
            println("Fake work ends : ${Thread.currentThread().name}") // Either main or any other thread
        }

       helper(2000) // runs on main thread, wait for coroutine to finish (not a right way to wait)
        println("Main ends : ${Thread.currentThread().name}")  // runs on main thread

}

suspend fun helper(time: Long){
    delay(time)
}

/* OUTPUT
Main starts : main
Fake work starts : main
Fake work ends : main
Main ends : main
 */


/* This launch coroutine builder is present within the scope of the parent runBlocking coroutine builder.
Since, runBlocking runs on the main thread, so child coroutine inherits the scope of the parent coroutine
and runs on the main thread.  */


// JOB OBJECT (We can control launch function through this object) ----------------------------------


fun main() = runBlocking{

        println("Main starts : ${Thread.currentThread().name}")  // runs on main thread

        val job : Job = launch{    // Thread main
            println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on main
            delay(1000)  // coroutine is suspended but thread main is free
            println("Fake work ends : ${Thread.currentThread().name}") // This statement can runs on any thread or main
        }

        job.join()
        //job.cancel() cancels the coroutine
        println("Main ends : ${Thread.currentThread().name}")  // runs on main thread

}

// Output remains the same
