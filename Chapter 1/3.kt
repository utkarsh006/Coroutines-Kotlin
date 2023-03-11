package com.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// sleep(1000) blocks your thread for 1000ms = 1s. Thread gets busy during this time.
// delay(1000) doesn't do that, it creates a coroutine attached to the thread.
// In delay, coroutine is suspended for 1s

fun main(){
    println("Main starts : ${Thread.currentThread().name}")

    GlobalScope.launch{    // Thread T1 is created
        println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on T1
        delay(1000)  // coroutine is suspended but thread T1 is free
        println("Fake work ends : ${Thread.currentThread().name}") // This statement can runs on any thread
    }

    Thread.sleep(2000)
    println("Main ends : ${Thread.currentThread().name}")
}

/* In above code if we have some suspending function in place of delay, the change of thread in the 
next line will then also be applicable. */

/* OUTPUT
Main starts : main
Fake work starts : DefaultDispatcher-worker-1
Fake work ends : DefaultDispatcher-worker-1
Main ends : main
 */


// calling delay function outside a coroutine --------------------------------

// we can call delay by wrapping it into runBlocking lambda expression in above code. Output remains same.
   
    runBlocking { // creates a coroutine that blocks the current main thread
        delay(2000)  // wait for coroutine to finish (not a right way to wait)
    }
    println("Main ends : ${Thread.currentThread().name}")


/*
GlobalScope.launch() and runBlocking() creates 2 different coroutines that run in parallel.
GlobalScope.launch() is non blocking in nature.
runBlocking() blocks the thread in which it operates.
 */ 


 // The above code can be rewritten as :------------------------------

 package com.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){  //executes in main thread
    
    runBlocking { // creates a coroutine that blocks the current main thread
        println("Main starts : ${Thread.currentThread().name}")  // runs on main thread

        GlobalScope.launch{    // Thread T1 is created
            println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on T1
            delay(1000)  // coroutine is suspended but thread T1 is free
            println("Fake work ends : ${Thread.currentThread().name}") // This statement can runs on any thread
        }


        delay(2000) // runs on main thread and in the scope of runBlocking function, wait for coroutine to finish (not a right way to wait)
        println("Main ends : ${Thread.currentThread().name}")  // runs on main thread
    }
    
}


// MORE OPTIMISED VERSION ----------------------------------------------------

fun main() = runBlocking{  //executes in main thread
    
        println("Main starts : ${Thread.currentThread().name}")  // runs on main thread

        GlobalScope.launch{    // Thread T1 is created
            println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on T1
            delay(1000)  // coroutine is suspended but thread T1 is free
            println("Fake work ends : ${Thread.currentThread().name}") // This statement can runs on any thread
        }


        delay(2000) // runs on main thread and in the scope of runBlocking function, wait for coroutine to finish (not a right way to wait)
        println("Main ends : ${Thread.currentThread().name}")  // runs on main thread

}