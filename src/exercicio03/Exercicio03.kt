// Descrição: o programa envia interrupções para as threads dos exercícios anteriores.
// Autor: Jorge Rossi.

package exercicio03

import java.io.File
import kotlin.random.Random

fun main() {

    val thread1 = Thread {
        try {
            val randomValue = Random.nextLong(5000, 10000)

            println("Thread ${Thread.currentThread().id}: esperando $randomValue milissegundos.")
            Thread.sleep(randomValue)
            println("Thread ${Thread.currentThread().id}: terminou a execução.")
        } catch (ex: InterruptedException) {
            println("Thread ${Thread.currentThread().id} foi interrompida.")
        }
    }

    val thread2 = Thread {
        try {
            val lines = File("src/exercicio02/quotes.txt").readLines()

            while (true) {
                println(lines.random())
                Thread.sleep(10000)
            }
        } catch (ex: InterruptedException) {
            println("Thread ${Thread.currentThread().id} foi interrompida.")
        }
    }

    thread1.start()
    thread2.start()

    Thread.sleep(3000)
    thread1.interrupt()

    Thread.sleep(3000)
    thread2.interrupt()
}