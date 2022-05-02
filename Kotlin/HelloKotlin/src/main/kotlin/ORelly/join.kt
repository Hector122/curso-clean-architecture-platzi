@file:JvmName("StringFunctions") //Annotation to specifies the class name.

package ORelly // the package statement follow the file annotation

import java.lang.StringBuilder

@JvmOverloads
fun <T> Collection<T>.jointToString(
    collection: Collection<T>,
    prefix: String = "",
    separator: String = " - ",
    postfix: String = ""
): String {
    val value = StringBuilder(prefix)
    for ((i, e) in this.withIndex()) {
        if (i > 0) value.append(separator)

        value.append(e)
    }
    value.append(postfix)
    return value.toString()
}