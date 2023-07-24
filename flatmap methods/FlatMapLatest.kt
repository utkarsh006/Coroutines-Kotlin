fun main() {
    flatMapLatestOperator()
}

fun flatMapLatestOperator() = runBlocking {
    val startTime = System.currentTimeMillis()

    (1..3).asFlow().onEach { delay(1000) }
        .flatMapLatest { getFlow(it) }
        .collect {
            println("$it, Time Taken : ${System.currentTimeMillis()-startTime} ms")
        }
}

// This function will return the flow of integers
fun getFlow(value: Int): Flow<String> = flow {
    emit("First Emitted value : $value")
    delay(5000)
    emit("Second Emitted value : $value")

}

/* Previous processing gets cancelled and for element 3, latestoperator will wait for 5s, but since 
no other element is left to be processed, it will print its second emitted value.

The flatMapLatest operator is a powerful tool in Kotlin Flow for handling real-time updates. 
By tracking the latest data and canceling ongoing operations, 
it helps to keep your data processing efficient and in sync with the latest changes. 

First Emitted value : 1, Time Taken : 1089 ms
First Emitted value : 2, Time Taken : 2107 ms
First Emitted value : 3, Time Taken : 3122 ms
Second Emitted value : 3, Time Taken : 8132 ms
 */