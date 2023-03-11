package com.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {  // creates a blocking coroutine that executes in current thread (main)

    println("Main starts : ${Thread.currentThread().name}")   // main thread

    withTimeout(2000){
        for (i in 0..100){
            print("$i.")
            delay(500)
        }
    }
    println("\n Main ends : ${Thread.currentThread().name}")  // main thread
}

// handle the exceptions using try-catch block

/* OUTPUT, after 2s our coroutine failed to finish hence TimeoutCancellationException was thrown because
the timeout function waited for 2000ms

Main starts : main
0.1.2.3.Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 2000 ms
	at kotlinx.coroutines.TimeoutKt.TimeoutCancellationException(Timeout.kt:184)
	at kotlinx.coroutines.TimeoutCoroutine.run(Timeout.kt:154)
	at kotlinx.coroutines.EventLoopImplBase$DelayedRunnableTask.run(EventLoop.common.kt:508)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:284)
	at kotlinx.coroutines.DefaultExecutor.run(DefaultExecutor.kt:108)
    
 */