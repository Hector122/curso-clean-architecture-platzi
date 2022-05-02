package ORelly

import java.lang.IllegalArgumentException

fun main(){
    var percentage = -9
    if(percentage !in 0..100){
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage\"")
    }
}