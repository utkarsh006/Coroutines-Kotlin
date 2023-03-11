package com.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// But why the both lines are not printed inside the launch function? Reason is that we launched coroutine
// Hence, app doesn't know that it has to wait for the coroutine to end its work.

fun main() {
    println("Main starts : ${Thread.currentThread().name}")

    // launch creates a background coroutine that runs on a background thread
    GlobalScope.launch{
        println("Fake work starts : ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work ends : ${Thread.currentThread().name}")
    }

    println("Main ends : ${Thread.currentThread().name}")
}


/* OUTPUT

Main starts : main
Main ends : main

*/


// How we can make main function to wait for our coroutine? 
// We can do it manually as shown below 

    GlobalScope.launch{
        println("Fake work starts : ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work ends : ${Thread.currentThread().name}")
    }

    Thread.sleep(2000)  // blocks the current main thread and wait for the coroutine to finish (not a right way to wait)
    println("Main ends : ${Thread.currentThread().name}")
    
    
/* OUTPUT

Main starts : main
Fake work starts : DefaultDispatcher-worker-2
Fake work ends : DefaultDispatcher-worker-2
Main ends : main

*/
