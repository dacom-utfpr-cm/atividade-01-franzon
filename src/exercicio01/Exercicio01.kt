// Descrição: o programa cria 3 threads e espera um tempo aleatório em cada thread para terminar.
// Autor: Jorge Rossi.

package exercicio01

import kotlin.random.Random

fun main() {
    for (i in 1..3) {
        Thread {
            val randomValue = Random.nextLong(0, 5000)

            println("Thread ${Thread.currentThread().id}: esperando $randomValue milissegundos.")
            Thread.sleep(randomValue)
            println("Thread ${Thread.currentThread().id}: terminou a execução.")
        }.start()
    }
}