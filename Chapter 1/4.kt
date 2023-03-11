package com.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{  //executes in main thread

        println("Main starts : ${Thread.currentThread().name}")  // runs on main thread

        GlobalScope.launch{    // Thread T1 is created
            println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on T1
            helper(1000)  // coroutine is suspended but thread T1 is free
            println("Fake work ends : ${Thread.currentThread().name}") // This statement can runs on any thread
        }


       helper(2000) // runs on main thread and in the scope of runBlocking function, wait for coroutine to finish (not a right way to wait)
        println("Main ends : ${Thread.currentThread().name}")  // runs on main thread

}

suspend fun helper(time: Long){
    delay(time)
}


/* OUTPUT
Main starts : main
Fake work starts : DefaultDispatcher-worker-1
Fake work ends : DefaultDispatcher-worker-1
Main ends : main
 */