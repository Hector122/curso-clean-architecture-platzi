package ORelly

import java.io.Serializable


fun main() {
    val button = Button()
    button.showoff()
    button.setFocus(true)
    button.onClick()
}

interface Clickable {
    fun onClick()

    //default implementation
    fun showoff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus.")
    }

    fun showoff() = println("I'm focusable!")
}


class Button : Clickable, Focusable {
    override fun onClick() = print("I was clicked")
    override fun showoff() {
        super<Focusable>.showoff()
        super<Clickable>.showoff()
    }
}

internal open class TalkativeButton : Focusable {
    private fun yell() = println("!Hey!")
    protected fun whisper() = println("Let's talk")
}

//fun TalkativeButton.giveSpeech(){
//    //can not access it is private and protected.
//    yell()
//
//    whisper()
//}


interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {

    }
}

class ButtonX : View {
    override fun getCurrentState(): State {
        TODO("Not yet implemented")
    }

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

   class ButtonState : State {

    }
}