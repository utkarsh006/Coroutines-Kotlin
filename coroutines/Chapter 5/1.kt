package com.example.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    println("runBlocking : $this")

    launch {
        println("launch : $this")
    }

    async {
        println("async : $this")
    }
    
    println("...some other code....")
}

/* OUTPUT

runBlocking : BlockingCoroutine{Active}@3108bc
...some other code....
launch : StandaloneCoroutine{Active}@3224f60b
async : DeferredCoroutine{Active}@1efed156

 */

// --------------------------------------------------------------------------------------


fun main() = runBlocking {

    println("runBlocking : $this")

    launch {
        println("launch : $this")

        launch {
            println("child launch : $this")
        }
    }

    async {
        println("async : $this")
    }

    println("...some other code....")
}

 /* OUTPUT, launch and child launch have different hex values which means that they both 
 are different objects.
 
 runBlocking : BlockingCoroutine{Active}@3108bc
...some other code....
launch : StandaloneCoroutine{Active}@3224f60b
async : DeferredCoroutine{Active}@1efed156
child launch : StandaloneCoroutine{Active}@72b6cbcc

 */