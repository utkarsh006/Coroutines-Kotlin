## Coroutines : Scope, Dispatchers and Builders

- **Scope :** By Scope, we can easily keep track of the coroutines.
- Start coroutines in some scope to avoid coroutine leaks.
- Type of scopes : Global Scope, Coroutine Scope, ViewModel Scope etc.
- **Dispatchers :** It describes the kind of thread where the coroutine should run.
  - **Dispatchers.Main :** Launch coroutine in Main or UI Thread.
  - **Dispatchers.IO :** Launch coroutine in background thread.
  - **Dispatchers.Default :** For CPU Intensive/ logical tasks.
  
- **Builders :** Coroutine builders are the extension functions of coroutine scopes which are used to launch coroutines.
  - **Launch :** Launch a new coroutine without blocking the current thread. 
  - **Async/Await :** If we want to get some result as a return value, then we use it else use launch.
