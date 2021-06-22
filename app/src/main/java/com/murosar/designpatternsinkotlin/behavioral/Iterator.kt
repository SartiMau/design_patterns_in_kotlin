package com.murosar.designpatternsinkotlin.behavioral

import java.util.Enumeration
import java.util.Hashtable

class IntSet {
    private val ht: Hashtable<Int, String> = Hashtable<Int, String>()

    // 1. Design an internal "iterator" class for the "collection" class
    class Iterator(private val set: IntSet) {

        private var enum: Enumeration<Int>? = null
        private var current: Int? = null

        fun first() {
            enum = set.ht.keys()
            next()
        }

        val isDone: Boolean
            get() = current == null

        fun currentItem(): Int? {
            return current
        }

        operator fun next() {
            current = try {
                enum?.nextElement()
            } catch (e: NoSuchElementException) {
                null
            }
        }
    }

    fun add(key: Int) {
        ht[key] = "null"
    }

    fun isMember(i: Int): Boolean {
        return ht.containsKey(i)
    }

    val hashtable: Hashtable<Int, String>
        get() = ht

    // 2. Add a createIterator() member to the collection class
    fun createIterator(): Iterator {
        return Iterator(this)
    }
}

class IteratorClient {

    fun doSomething() {
        val set = IntSet()
        run {
            for (i in 2..9 step 2) {
                set.add(i)
            }
        }
        for (i in 1..8) {
            print(i.toString() + "-" + set.isMember(i) + "  ")
        }

        // 3. Clients ask the collection object to create many iterator objects
        val it1 = set.createIterator()
        val it2 = set.createIterator()

        // 4. Clients use the first(), isDone(), next(), currentItem() protocol
        print("\nIterator:    ")
        it1.first()
        it2.first()
        while (!it1.isDone) {
            print(it1.currentItem().toString() + " " + it2.currentItem() + "  ")
            it1.next()
            it2.next()
        }

        print("\nEnumeration: ")
        val e: Enumeration<Int> = set.hashtable.keys()
        while (e.hasMoreElements()) {
            print(e.nextElement().toString() + "  ")
        }
        println()
    }

    // Print:
    // 1-false  2-true  3-false  4-true  5-false  6-true  7-false  8-true
    // Iterator:    8 8  6 6  4 4  2 2
    // Enumeration: 8  6  4  2
}
