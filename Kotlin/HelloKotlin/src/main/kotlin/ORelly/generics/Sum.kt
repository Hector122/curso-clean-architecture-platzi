package ORelly.generics

import java.lang.IllegalArgumentException

interface Expr
class Num(var num: Int) : Expr
class Sum(var left: Expr, var rigth: Expr) : Expr


fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.num
        is Sum -> eval(e.rigth) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("Num: ${e.num}")
            e.num
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val rigth = evalWithLogging(e.rigth)
            println("Sum: ${left} + ${rigth}")
            left + rigth
        }
        else -> throw IllegalArgumentException("Unknown")
    }


fun main() {
    print(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(9))))
}