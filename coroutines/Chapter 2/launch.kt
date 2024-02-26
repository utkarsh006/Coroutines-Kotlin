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
and runs on the main thread. So ek hi main thread pr chalega bcz globalscope ek coroutine builder hai agar whi nahi
rahega toh corouyine hi nahi banega. */


// JOB OBJECT (We can control launch function through this object) ----------------------------------
// Read Job docs(https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-job/)

fun main() = runBlocking{

        println("Main starts : ${Thread.currentThread().name}")  // runs on main thread

        val job : Job = launch{    // Thread main
            println("Fake work starts : ${Thread.currentThread().name}")  // This statement runs on main
            delay(1000)  // coroutine is suspended but thread main is free
            println("Fake work ends : ${Thread.currentThread().name}") // This statement can runs on any thread or main
        }

        job.join()  // we have used by removing the delay() bcz it wasn't the right way.
        //job.cancel() cancels the coroutine
        println("Main ends : ${Thread.currentThread().name}")  // runs on main thread

}

// Output remains the same


/*
In the context of coroutines in Kotlin's launch function, a "job" represents a handle to a coroutine. When you launch a
coroutine using the launch builder, it returns a reference to the coroutine job, which allows you to control, cancel, and
interact with the coroutine.

Here's a brief overview of what you can do with a coroutine job:

-> Start: When you launch a coroutine, you receive a job object that represents the coroutine's lifecycle. 
   This job is automatically started when the coroutine is launched.

-> Cancellation: You can cancel a coroutine by calling the cancel() method on its job. This will interrupt the execution
   of the coroutine, typically causing its suspended functions to throw CancellationException.

-> Joining: You can wait for a coroutine to complete by calling the join() method on its job. This suspends the calling
   coroutine until the target coroutine completes its execution, whether normally or due to cancellation.

-> Exception Handling: You can handle exceptions thrown by a coroutine using its job. You can attach an exception handler 
   using CoroutineExceptionHandler to the coroutine context or use invokeOnCompletion on the job to handle exceptions.

-> Parent-Child Relationship: Jobs form a parent-child relationship. When you launch a coroutine within another coroutine using a coroutine scope, the outer coroutine's job becomes the parent of the inner coroutine's job. This allows for hierarchical structuring and management of coroutines.

Overall, a job object in coroutines provides a way to manage and interact with individual coroutine instances, giving you control over their lifecycle and execution.
