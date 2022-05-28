package ORelly

import com.sun.source.tree.BinaryTree
import java.util.*


fun buzzFizz(int: Int) = when {
    int % 15 == 0 -> "BuzzFezz "
    int % 5 == 0 -> "Buzz "
    int % 3 == 0 -> "Fezz "
    else -> "$int "
}

fun printBinaryTree() {
    val binaryTreeMap = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        binaryTreeMap[c] = Integer.toBinaryString(c.toInt())
    }

    for((K,V) in binaryTreeMap){
        println("$K = $V")
    }
}

fun main(args: Array<String>) {
    for (i in 100 downTo 1 step 2) {
        print(buzzFizz(i))
    }

    printBinaryTree()
}
