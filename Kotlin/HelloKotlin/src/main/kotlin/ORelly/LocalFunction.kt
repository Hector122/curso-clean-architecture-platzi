package ORelly

import java.lang.Exception
import java.lang.IllegalArgumentException

fun main() {
    saveUserTwo(User(4, "Alberto", ""))
}

data class User(val id: Int, val name: String, val address: String)

//save user in a DB
fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id} : Empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id} : Empty Address")
    }

    //Save user to the DB
}


//using local function/ ugly
fun saveUserTwo(user: User) {

    fun validateUser(user: User, value: String, valueName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user ${user.id} : Empty $valueName")
    }

    //validate user
    validateUser(user, user.name, "Name")
    validateUser(user, user.address, "Address")
    //save User to the DB
}

//using local func
fun savaUserThree(user: User) {
    fun validateUser(value: String, valueName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user ${user.id} : Empty $valueName")
    }

    //validate user
    validateUser(user.name, "Name")
    validateUser(user.address, "Address")
}

//move the validation logic into an extension function
fun User.validateBeforeSave() {
    fun validateUser(value: String, valueName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user ${this.id} : Empty $valueName")
    }

    //validate user
    validateUser(this.name, "Name")
    validateUser(this.address, "Address")
}


//using extensions function
fun saveUserFour(user: User) {
    //validate user
    user.validateBeforeSave()

    //save User to the DB
}

class OuterName {

    inner class Inner {
        fun getOuterClass() = this@OuterName
    }
}