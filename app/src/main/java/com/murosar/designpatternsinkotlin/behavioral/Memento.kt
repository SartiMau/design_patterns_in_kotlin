package com.murosar.designpatternsinkotlin.behavioral

class Memento(val state: String)

//-----------------------------------------------------------------------------------------------------------------------------------------

class Originator(var state: String) {

    fun save(): Memento {
        println("Originator: Saving to Memento. State = $state")
        return Memento(state)
    }

    fun restore(m: Memento) {
        state = m.state
        println("Originator: State after restoring from Memento: $state")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class Caretaker {
    private val mementoList: ArrayList<Memento> = ArrayList()

    fun addMemento(memento: Memento) {
        mementoList.add(memento)
    }

    fun restore(index: Int): Memento = mementoList[index]
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class MementoClient {

    fun doSomething() {
        val originator = Originator("Initial state")
        val caretaker = Caretaker()

        originator.state = "State--1"
        originator.state = "State--2"
        caretaker.addMemento(originator.save())

        originator.state = "State--3"
        caretaker.addMemento(originator.save())

        originator.state = "State--4"
        println("Current State: " + originator.state)

        originator.restore(caretaker.restore(1))
        println("Second saved state: " + originator.state)

        originator.restore(caretaker.restore(0))
        println("First saved state: " + originator.state)
    }

    // Print:
    // Originator: Saving to Memento. State = State--2
    // Originator: Saving to Memento. State = State--3
    // Current State: State--4
    // Originator: State after restoring from Memento: State--3
    // Second saved state: State--3
    // Originator: State after restoring from Memento: State--2
    // First saved state: State--2
}
