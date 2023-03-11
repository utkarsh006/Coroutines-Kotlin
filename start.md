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

- Visit [how to create threads?](https://github.com/utkarsh006/Coroutines-Kotlin/blob/main/code/1.kt)
- In case of threads, the application **waits for all the background threads** to complete.
- But when a coroutine is launched, app doesn't know that it has to wait for the coroutine to end its work.
- [Implement coroutines](https://github.com/utkarsh006/Coroutines-Kotlin/blob/main/code/2.kt)
