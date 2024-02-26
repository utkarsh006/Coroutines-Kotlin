## Coroutine Builders : launch, runBlocking, Async

- Coroutine builders are the functions used for creating coroutines.
-  If lifecycle of a screen is over then coroutine's lifecycle also gets over.

### Launch 

- Also called as **Fire and Forget**, since it won’t return the result to the caller (So, in simple terms, "fire and forget" in coroutines means starting a task and not worrying about its outcome. You just trust that it will get done without waiting around for it).
- GlobalScope.launch{}, this is a companion object which creates coroutines at global(app) level. These are top level coroutines and can survive the entire life of the application.
- Not blocks the thread in which it operates.
- Visit [this file](/Coroutines-Kotlin/Chapter%202/launch.kt) to see how to use launch.

``` 
//creates coroutine at global level. This method is highly discouraged.

GlobalScope.launch{
    //file download, play music
}

// creates coroutine at local scope

launch{
    //some data computation, login operations
}

```

- Launch function returns a reference to the **job object**. Visit [this](/Coroutines-Kotlin/Chapter%202/launch.kt)

- Using Job object we can cancel the coroutine or wait for it to finish.

<br>

### Async 

- Visit [this file](/Coroutines-Kotlin/Chapter%202/async.kt) to see the use of async.
- Returns a reference to the Deferred<T> object.
- Not blocks the thread in which it operates.

### runBlocking 

- Runblocking is generally used to write testcases to test the suspending functions.
- Always **block the thread** in which it operates.

