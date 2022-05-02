fun main(){
    val list = listOf(11,12,13,14,15,16,17,18,19,20)
    list.reversed()
    print(reversedList(list))
}

fun reversedList(list: List<Int>) : List<Int>{
    val newList = mutableListOf<Int>()

    for (element in 0..list.size-1){
        newList.add(list[list.size - element - 1])
    }
    return newList
}


fun reversedListAgain(list: List<Int>) : List<Int>{
    val newList = mutableListOf<Int>()

    for (element in list.size -1 downTo 0){
        newList.add(list[list.size - element - 1])
    }
    return newList
}