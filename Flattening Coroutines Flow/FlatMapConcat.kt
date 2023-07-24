import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() {
    flatMapConcatOperator()
}

fun flatMapConcatOperator() = runBlocking {
    val startTime = System.currentTimeMillis()
    
    (1..3).asFlow().onEach { delay(1000) }
        .flatMapConcat { getFlow(it) }
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
First Emitted value : 1, Time Taken : 1048 ms
Second Emitted value : 1, Time Taken : 6053 ms
First Emitted value : 2, Time Taken : 7053 ms
Second Emitted value : 2, Time Taken : 12068 ms
First Emitted value : 3, Time Taken : 13081 ms
Second Emitted value : 3, Time Taken : 18089 ms

1048, 6053 has gap of 5s, 6053 and 7053 had gap of 1s(1000ms)
 */