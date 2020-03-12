package exercicio02

import java.io.File

fun main() {
    Thread {
        val lines = File("src/exercicio02/quotes.txt").readLines()

        while (true) {
            println(lines.random())
            Thread.sleep(10000)
        }
    }.start()
}