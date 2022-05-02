class PairBook(var title: String, var author: String, var year: Int) {


    fun getTitleAndAuthor(): Pair<String, String> {
        return title to author
    }

    fun getTitleAuthorAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}


fun main(args: Array<String>) {

    val book = PairBook("Atomic Habit", "James clear", 2012)
    var bookTitleAuthor = book.getTitleAndAuthor()
    var bookTitleAuthorYear = book.getTitleAuthorAndYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    println(
        "Here is your book ${bookTitleAuthorYear.first} " +
                "by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}"
    )


    //1 - Create a Set of book titles called allBooks, for example, by William Shakespeare.
    val allBooks = setOf("Romeo and Juliet", "Macbeth", "Hamlet", "Hamlet")

    //2 - Create a Map called library that associates the set of books, allBooks, to the author.
    //val library = mutableMapOf("Wiliam Shakespeare" to allBooks)
    var library: Map<String, Set<String>> = mapOf("" to allBooks)

    //3-  Use the collections function any() on library to see if any of the books are “Hamlet’
    library.any { it.value.contains("Hamlet") }

    //4 - Create a MutableMap called moreBooks, and add one title/author to it.
    val moreBooks = mutableMapOf("Wilhelm Tell" to "Schiller")

    //5 - Use getOrPut() to see whether a title is in the map,
    // and if the title is not in the map, add it
    moreBooks.getOrPut("Jungle book"){"Kipling"}
    moreBooks.getOrPut("Hamlet"){"Shakespeare"}
    println(moreBooks)
}
