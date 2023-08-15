<div align="center"><img src="https://user-images.githubusercontent.com/94545831/224503387-f2e90605-751a-48e6-a503-c010957eea64.png" /> </div>

## How to Proceed in this repo 😥

- [VIDEO LINK](https://youtu.be/lmRzRKIsn1g) to learn coroutines.
- Just watch the video and revise from this Repo 😄
- Coroutines basics are covered in **5 chapters**. 
- Each chapter has its separate folder consisting of both code and README files.
- Go to the `chapterStart` README file in each folder and begin reading.
- Projects related to coroutines are also there.

<details><summary><h2> Coroutines : Scope, Dispatchers and Builders </h2></summary>

- **Scope :** By Scope, we can easily `keep track` of the coroutines.
- Start coroutines in some scope to avoid coroutine leaks.
- Type of scopes : `Global Scope, Coroutine Scope, ViewModel Scope`
- **Dispatchers :** It describes the kind of thread where the coroutine should run.
  - **Dispatchers.Main :** Launch coroutine in Main or UI Thread.
  - **Dispatchers.IO :** Launch coroutine in background thread.
  - **Dispatchers.Default :** For CPU Intensive/ logical tasks.
  
- **Builders :** Coroutine builders are the extension functions of coroutine scopes which are used to launch coroutines.
  - **Launch :** Launch a new coroutine without blocking the current thread. 
  - **Async/Await :** If we want to get some result as a return value, then we use it else use launch.

#### Switch Coroutine b/w Threads (How to communicate with main Thread while we are on the background Thread?)

- We can't call any UI Component from the Background Thread, so the coroutines have the easiest way to switch between threads with the help of `withContext()`
- **Beauty of Coroutines :** Whenever the coroutine is suspended, the current stack frame of the function is copied and saved in the memory but whenever the function resumes after completing
its task, the stack frame is copied back from where it was saved and starts running again 😎

</details>

- Flows are used to return multiple asynchronous values. Watch [Video](https://youtu.be/emk9_tVVLcc) and [Docs](https://developer.android.com/kotlin/flow)
- Map in flows is different from map in collections, since it can call suspending functions within itself.
