- When user interacts with our app a default thread (Main Thread) is created It contains small operations (UI Interaction, button click etc.)

- If we perform long operations on the Main Thread (File downlaod, Database queries, Image loading etc.) it can get blocked and the app gets creashed.

<div align="center"> <img width="300" src="https://user-images.githubusercontent.com/94545831/224466403-20ec361f-8ffc-4809-8ee5-11ed230b41f3.png" /> </div>

- Create **Worker/Background Threads** for separate operations. But we can't create more threads as our device can run **out of memory** and our **app can shut down**.
Also, the cost of doing this so expensive.

### Here comes the role of Coroutines 😎

- Create one background thread and launch various coroutines on this thread to perform various operations. Memory consumption would be of one thread and so many tasks
can be done.

- Coroutines are `light weight threads` , run in parallel, wait for each other and communicate with each other.
- But **COROUTINES != THREAD**
- We can create 100 coroutines without any memory issue but can't do the same with threads.


### Creating Threads

- Visit [how to create threads?](/Coroutines-Kotlin/Chapter%201/1.kt)
- In case of threads, the application **waits for all the background threads** to complete.
- But when a coroutine is launched, app doesn't know that it has to wait for the coroutine to end its work.
- [Implement coroutines](/Coroutines-Kotlin/Chapter%201/2.kt)

### Use of Delay Function

- Read about using [Delay function](/Coroutines-Kotlin/Chapter%201/3.kt)

- Delay is a suspend function as shown below.

```
public suspend fun delay(timeMillis: Long) {
    if (timeMillis <= 0) return // don't delay
    return suspendCancellableCoroutine sc@ { cont: CancellableContinuation<Unit> ->
        // if timeMillis == Long.MAX_VALUE then just wait forever like awaitCancellation, don't schedule.
        if (timeMillis < Long.MAX_VALUE) {
            cont.context.delay.scheduleResumeAfterDelay(timeMillis, cont)
        }
    }
}

```
<br>

### Suspend Functions

- A function with a suspend modifier is called as suspending function.

- These functions are only allowed to be called from a coroutine or from another suspending function.

- These functions can't be called from outside a coroutine.

- Refer [this](/Coroutines-Kotlin/Chapter%201/3.kt) code file once again, for **runBlocking**

- Create custom suspending functions. Learn [Here](/Coroutines-Kotlin/Chapter%201/4.kt)