## Coroutine Cancellation 

### Why to cancel a coroutine? 

- Result no longer needed.
- Coroutine is taking too longer to respond.

- To cancel a coroutine, it should be cooperative.
- If the coroutine is cooperative then cancel it, else wait for coroutine to finish.

### Ways to make a Coroutine cooperative

- **First Way :** Periodically invoke a suspending function that checks for cancellation. Visit [this](/Chapter%203/cancel.kt)
- Only those suspending functions that belongs to `kotlinx.coroutines` package will make coroutine cooperative.
- Use `delay(), yield(), withContext(), withTimeout()` functions to make the coroutine cooperative.
- yield function is faster than delay.

- **Second Way :** Explicitly check for cancellation status within the coroutine.
    - Use 'CoroutineScope.isActive` boolean flag.


### Handling Exceptions
 
- The above functions (delay, yield etc.) throw Cancellation Exception on the coroutine cancellation.
- We **can't execute a suspending function from the finally block** because the coroutine running this code is already cancelled.
- If we want to execute a suspending function from a finally block then, wrap the code within `withContext(NonCancellable)` function.
- job.cancel(CancellationException("My own crash message"))  to print your own exception message.

### Timeouts

- Timeouts are of 2 types : `withTimeout` and `withTimeoutOrNull`
- `withTimeoutOrNull` doesn't throw any exception.
- These are like launch and async and creates separate coroutines.
- Visit [this file](/Chapter%203/timeouts.kt) for timeouts.