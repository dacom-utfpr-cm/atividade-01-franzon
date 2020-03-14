// Descrição: o programa cria uma thread que faz a soma de n números digitados pelo usuário
// Autor: Jorge Rossi.

package exercicio05

import java.util.*

class SumThread : Runnable {
    var sum = 0

    override fun run() {
        print("Quantidade de números: ")

        val reader = Scanner(System.`in`)
        val n = reader.nextInt()

        for (i in 0 until n) {
            print("-> ")
            sum += reader.nextInt()
        }
    }
}

fun main() {
    val runnable = SumThread()
    val thread = Thread(runnable)

    thread.start()
    thread.join()

    println("Soma: " + runnable.sum)
}