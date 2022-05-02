import kotlin.test.assertEquals

class Box<T>(t: T) {
    var value = t
}

//covariance
fun copy(from: Array<out Any>, to: Array<Any?>) {
    assert(from.size == to.size)
    for (i in 0..2) {
        to[i] = from[i]
    }
}

//contravariance
fun fill(dest: Array<in Int>, value: Int) {
    dest[0] = value
}


fun main() {
    val box = Box<String>("Hello")
    val box2 = Box(45)

    val ints = arrayOf(1, 2, 3)
    val anys: Array<Any?> = arrayOfNulls(3)

    copy(ints, anys)

    val objects: Array<Any?> = arrayOfNulls(3)
    fill(objects, 45)
    assertEquals(objects[0], 1)
}

