// Descrição: o programa monitora quais threads foram interrompidas
// Autor: Jorge Rossi.

package exercicio04

class MasterThread(private val threads: List<Thread>) : Runnable {
    override fun run() {
        while (true) {
            for (thread in threads) {
                if (thread.isInterrupted) {
                    println("[MasterThread] A thread ${thread.id} foi interrompida.")
                }
            }
        }
    }
}

fun main() {

    val threads = arrayListOf<Thread>()

    for (i in 1..5) {
        threads.add(
            Thread {
                try {
                    println("Thread ${Thread.currentThread().id} iniciada.")
                    while (true) {
                        Thread.sleep(100)
                    }
                } catch (ex: InterruptedException) {
                }
            }.apply { start() }
        )
    }

    // Thread que monitora as outras threads
    Thread(MasterThread(threads)).start()

    for (i in 0..4) {
        Thread.sleep(1000)
        println("Interrompendo thread ${threads[i].id}")
        threads[i].interrupt()
    }
}