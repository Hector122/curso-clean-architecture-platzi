package ORelly

sealed class Expr{
    class Num(var value:Int) : Expr()
    class Sum(var left: Expr, var right:Expr) : Expr()
}

fun eval(e:Expr): Int = when(e){
    is Expr.Num -> e.value
    is Expr.Sum -> eval(e.left) + eval(e.right)
}