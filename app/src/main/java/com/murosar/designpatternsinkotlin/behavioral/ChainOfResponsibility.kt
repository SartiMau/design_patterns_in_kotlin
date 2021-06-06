package com.murosar.designpatternsinkotlin.behavioral

import java.util.Random

// Before: without the pattern
class HandlerBefore {

    private val id = nextID++

    fun execute(num: Int): Boolean {
        if (RANDOM.nextInt(4) != 0) {
            println("   $id-busy  ")
            return false
        }
        println("$id-handled-$num")
        return true
    }

    companion object {
        private val RANDOM = Random()
        private var nextID = 1
    }
}

class ChainClientBefore {

    fun doSomething() {
        val nodes = arrayOf(HandlerBefore(), HandlerBefore(), HandlerBefore(), HandlerBefore())
        var i = 1
        var j: Int
        while (i < 6) {
            println("Operation #$i:")
            j = 0
            while (!nodes[j].execute(i)) {
                j = (j + 1) % nodes.size
            }
            println()
            i++
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// After: with the pattern
class Handler {
    private val id = nextID++
    private var nextInChain: Handler? = null

    fun add(next: Handler?) {
        if (nextInChain == null) {
            nextInChain = next
        } else {
            nextInChain?.add(next)
        }
    }

    fun wrapAround(root: Handler?) {
        if (nextInChain == null) {
            nextInChain = root
        } else {
            nextInChain?.wrapAround(root)
        }
    }

    fun execute(num: Int) {
        if (RANDOM.nextInt(4) != 0) {
            println("   $id-busy  ")
            nextInChain?.execute(num)
        } else {
            println("$id-handled-$num")
        }
    }

    companion object {
        private val RANDOM = Random()
        private var nextID = 1
    }
}

class ChainClient {

    fun doSomething() {
        val rootChain = Handler()

        rootChain.add(Handler())
        rootChain.add(Handler())
        rootChain.add(Handler())

        rootChain.wrapAround(rootChain)

        for (i in 1..5) {
            println("Operation #$i:")
            rootChain.execute(i)
            println()
        }
    }
}
