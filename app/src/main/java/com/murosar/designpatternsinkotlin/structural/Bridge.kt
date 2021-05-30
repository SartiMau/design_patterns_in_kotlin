package com.murosar.designpatternsinkotlin.structural

import java.util.Random

class Node(var value: Int) {
    var prev: Node? = null
    var next: Node? = null
}

class StackList {
    private var last: Node? = null

    fun push(i: Int) {
        if (last == null) {
            last = Node(i)
        } else {
            last?.next = Node(i)
            last?.next?.prev = last
            last = last?.next
        }
    }

    val isEmpty: Boolean
        get() = last == null

    val isFull: Boolean
        get() = false

    fun top(): Int? {
        return if (isEmpty) {
            -1
        } else {
            last?.value
        }
    }

    fun pop(): Int? {
        if (isEmpty) {
            return -1
        }
        val ret = last?.value
        last = last?.prev
        return ret
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

open class StackArray {
    private var items: IntArray
    private var size = -1

    constructor() {
        items = IntArray(12)
    }

    constructor(cells: Int) {
        items = IntArray(cells)
    }

    open fun push(i: Int) {
        if (!isFull) {
            items[++size] = i
        }
    }

    val isEmpty: Boolean
        get() = size == -1

    private val isFull: Boolean
        get() = size == items.size - 1

    fun top(): Int {
        return if (isEmpty) {
            -1
        } else {
            items[size]
        }
    }

    open fun pop(): Int {
        return if (isEmpty) {
            -1
        } else {
            items[size--]
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class StackFIFO : StackArray() {
    private val stackArray = StackArray()

    override fun pop(): Int {
        while (!isEmpty) {
            stackArray.push(super.pop())
        }
        val ret = stackArray.pop()
        while (!stackArray.isEmpty) {
            push(stackArray.pop())
        }
        return ret
    }
}

class StackHanoi : StackArray() {
    private var totalRejected = 0

    fun reportRejected(): Int {
        return totalRejected
    }

    override fun push(i: Int) {
        if (!isEmpty && i > top()) {
            totalRejected++
        } else {
            super.push(i)
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class BridgeClient {

    fun doSomething() {
        val stacks = arrayOf(StackArray(), StackFIFO(), StackHanoi())
        val stackList = StackList()

        for (i in 1..15) {
            stacks[0].push(i)
            stackList.push(i)
            stacks[1].push(i)
        }

        val rn = Random()
        for (i in 1..15) {
            stacks[2].push(rn.nextInt(20))
        }

        while (!stacks[0].isEmpty) {
            print(stacks[0].pop().toString() + "  ") // print: 12  11  10  9  8  7  6  5  4  3  2  1
        }
        println()
        while (!stackList.isEmpty) {
            print(stackList.pop().toString() + "  ") // print: 15  14  13  12  11  10  9  8  7  6  5  4  3  2  1
        }
        println()
        while (!stacks[1].isEmpty) {
            print(stacks[1].pop().toString() + "  ") // print: 1  2  3  4  5  6  7  8  9  10  11  12
        }
        println()
        while (!stacks[2].isEmpty) {
            print(stacks[2].pop().toString() + "  ") // print: 0  5  10  12  13  16
        }
        println()
        println("Total rejected is ${(stacks[2] as StackHanoi).reportRejected()}") // print: Total rejected is 9
    }
}
