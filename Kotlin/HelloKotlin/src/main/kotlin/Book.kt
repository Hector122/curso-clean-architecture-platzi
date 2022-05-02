import kotlin.random.Random

/*
1. Create a class, Book, with a title and an author.
2- Add a method, readPage(), that increases the value of a private variable, currentPage, by 1.
3- Create a subclass of Book; name it eBook.
eBook also takes in a format, which defaults to "text".
In eBooks, counting words makes more sense than pages. Override the readPage() method to increase the word count by 250, the average number of words per page from typewriter days.
 */
const val MAXIMUM_BOOKS = 7

object Constants {
    const val BASE_URL = "www.prueba/testbooks.com/"
}

fun Book.weight(): Double {
    return pages * 1.5
}

fun Book.tornPages(tornPages: Int) {
    if (pages >= tornPages) {
        this.pages -= tornPages
    } else this.pages = 0;
}

open class Book(var title: String, var author: String, var year: Int, var pages: Int) {
    companion object {
        const val BASE_URL = "www.prueba/testbooks.com/"
    }

    private var currentPage: Int = 0

    open fun readPage() {
        currentPage.inc()
    }

    fun getTitleAndAuthor(): Pair<String, String> {
        return title to author
    }

    fun getTitleAuthorAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }


    fun canBorrow(borrowed: Int): Boolean {
        return borrowed < MAXIMUM_BOOKS
    }

    fun printUrl() {
        println(Constants.BASE_URL + "$title.html")
    }
}

class eBook(title: String, author: String, var format: String = "text", year: Int, pages: Int) :
    Book(title, author, year, pages) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}


class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random.nextInt(10) + 1)
    }
}

fun main(args: Array<String>) {

    val book = Book("Atomic Habit", "James clear", 2012, 250)
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
    moreBooks.getOrPut("Jungle book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)

    book.printUrl()

    val puppy = Puppy()
    val book3 = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    while (book3.pages > 0) {
        puppy.playWithBook(book3)
        println("${book3.pages} left in ${book3.title}")
    }
    println("Sad puppy, no more pages in ${book3.title}. ")
}