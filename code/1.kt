package com.example.coroutines

import kotlin.concurrent.thread

// code within the thread is executed completely then only our main function ended
fun main() {
    println("Main starts : ${Thread.currentThread().name}")
    thread{
        println("Fake work starts : ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work ends : ${Thread.currentThread().name}")
    }

    println("Main ends : ${Thread.currentThread().name}")
}

/* OUTPUT 

Main starts : main
Main ends : main
Fake work starts : Thread-0
Fake work ends : Thread-0  

*/
