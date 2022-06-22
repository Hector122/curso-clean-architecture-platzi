import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import sun.misc.Launcher
import kotlin.system.measureTimeMillis

//fun main() {
//
//     val time = measureTimeMillis {
//         for(i in 1..10_000){
//             Thread(Runnable {
//                 Thread.sleep(1)
//             }).run()
//         }
//     }
//    println("Tiempo transcurrido: $time")
//
//}

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            for (i in 1..100_000) {
                launch {
                    delay(10_000L)
                }
            }
        }
    }

    println("Tiempo transcurrido: $time")
}