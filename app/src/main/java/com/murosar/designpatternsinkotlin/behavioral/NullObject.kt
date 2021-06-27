package com.murosar.designpatternsinkotlin.behavioral

import java.io.OutputStream
import java.io.PrintStream

private class NullOutputStream : OutputStream() {
    override fun write(b: Int) {
        // Do nothing
    }
}

private class NullPrintStream : PrintStream(NullOutputStream())

//-----------------------------------------------------------------------------------------------------------------------------------------

private class Application(private val debugOut: PrintStream) {

    fun doSomething() {
        var sum = 0
        for (i in 0..9) {
            sum += i
            debugOut.println("i = $i")
        }
        println("sum = $sum")
    }

}

class NullObjectClient {

    fun doSomething() {
        val app = Application(NullPrintStream())
        app.doSomething()
    }

    // Print:
    // sum = 45
}
