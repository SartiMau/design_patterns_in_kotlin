package com.murosar.designpatternsinkotlin.behavioral

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

// Before: without the pattern

class CeilingFanPullChainBefore {
    private var currentState = 0
    fun pull() {
        when (currentState) {
            0 -> {
                currentState = 1
                println("low speed")
            }
            1 -> {
                currentState = 2
                println("medium speed")
            }
            2 -> {
                currentState = 3
                println("high speed")
            }
            else -> {
                currentState = 0
                println("turning off")
            }
        }
    }
}

class StateClientBefore {

    fun doSomething() {
        val chain = CeilingFanPullChainBefore()
        while (true) {
            print("Press ENTER")
            line
            chain.pull()
        }
    }

    private val line: String?
        get() {
            val value = BufferedReader(InputStreamReader(System.`in`))
            var line: String? = null
            try {
                line = value.readLine()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
            return line
        }

    // Print:
    // Press ENTER
    //    low speed
    // Press ENTER
    //    medium speed
    // Press ENTER
    //    high speed
    // Press ENTER
    //    turning off
    // Press ENTER
    //    low speed
    // Press ENTER
    //    medium speed
    // Press ENTER
    //    high speed
    // Press ENTER
    //    turning off
}
//-----------------------------------------------------------------------------------------------------------------------------------------

// After: with the pattern

interface State {
    fun pull(wrapper: CeilingFanPullChain)
}

class CeilingFanPullChain {
    private var currentState: State
    fun setState(s: State) {
        currentState = s
    }

    fun pull() {
        currentState.pull(this)
    }

    init {
        currentState = Off()
    }
}

class Off : State {
    override fun pull(wrapper: CeilingFanPullChain) {
        wrapper.setState(Low())
        println("low speed")
    }
}

class Low : State {
    override fun pull(wrapper: CeilingFanPullChain) {
        wrapper.setState(Medium())
        println("medium speed")
    }
}

class Medium : State {
    override fun pull(wrapper: CeilingFanPullChain) {
        wrapper.setState(High())
        println("high speed")
    }
}

class High : State {
    override fun pull(wrapper: CeilingFanPullChain) {
        wrapper.setState(Off())
        println("turning off")
    }
}

class StateClient {

    fun doSomething() {
        val chain = CeilingFanPullChain()
        while (true) {
            print("Press ENTER")
            line
            chain.pull()
        }
    }

    private val line: String?
        get() {
            val value = BufferedReader(InputStreamReader(System.`in`))
            var line: String? = null
            try {
                line = value.readLine()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
            return line
        }

    // Print:
    // Press ENTER
    //    low speed
    // Press ENTER
    //    medium speed
    // Press ENTER
    //    high speed
    // Press ENTER
    //    turning off
    // Press ENTER
    //    low speed
    // Press ENTER
    //    medium speed
    // Press ENTER
    //    high speed
    // Press ENTER
    //    turning off
}
