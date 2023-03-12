## Coroutine Scope, Coroutine Context and Dispatchers

- Each coroutine has its own CoroutineScope instance attached to it irrespective of being a parent or a child. `this: CoroutineScope`
- Visit [this file](/Chapter%205/1.kt) to know above fact.

<br>

- Coroutine context **can be inherited** from parent to child.
- Coroutine context has 2 components : `Dispatcher and Job`
- Dispatcher decides on which thread, the coroutine will execute.
- We can also assign name to our coroutine.
- Visit [this file](/Chapter%205/contexts.kt) to understand about coroutine contexts.

<br>

- There are **4 types** of Dispatchers : Default, Confined, Main(works on UI Objects) and IO(works on I/O Operations).