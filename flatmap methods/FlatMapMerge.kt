fun main() {
    flatMapMergeOperator()
}

fun flatMapMergeOperator() = runBlocking {
    val startTime = System.currentTimeMillis()

    (1..3).asFlow().onEach { delay(1000) }
        .flatMapMerge { getFlow(it) }
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

/*
First Emitted value : 1, Time Taken : 1070 ms
First Emitted value : 2, Time Taken : 2075 ms
First Emitted value : 3, Time Taken : 3079 ms
Second Emitted value : 1, Time Taken : 6075 ms
Second Emitted value : 2, Time Taken : 7083 ms
Second Emitted value : 3, Time Taken : 8092 ms
 */