package com.murosar.designpatternsinkotlin.behavioral

import java.util.Enumeration
import java.util.Vector

interface AlarmListener {
    fun alarm()
}

//-----------------------------------------------------------------------------------------------------------------------------------------

open class CheckList {
    // Template Method design pattern
    fun byTheNumbers() {
        localize()
        isolate()
        identify()
    }

    private fun localize() {
        println("   establish a perimeter")
    }

    protected open fun isolate() {
        println("   isolate the grid")
    }

    private fun identify() {
        println("   identify the source")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class Lighting : AlarmListener {
    override fun alarm() {
        println("lights up")
    }
}

class Gates : AlarmListener {
    override fun alarm() {
        println("gates close")
    }
}

open class Surveillance : CheckList(), AlarmListener {
    override fun alarm() {
        println("Surveillance - by the numbers:")
        byTheNumbers()
    }

    override fun isolate() {
        println("   train the cameras")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class SensorSystem {
    private val listeners: Vector<AlarmListener> = Vector()

    fun register(alarmListener: AlarmListener?) {
        listeners.addElement(alarmListener)
    }

    fun soundTheAlarm() {
        val e: Enumeration<AlarmListener> = listeners.elements()
        while (e.hasMoreElements()) {
            (e.nextElement() as AlarmListener).alarm()
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class ObserverClient {

    fun doSomething() {
        val sensorSystem = SensorSystem()

        sensorSystem.register(Gates())
        sensorSystem.register(Lighting())
        sensorSystem.register(Surveillance())

        sensorSystem.soundTheAlarm()
    }

    // Print:
    // gates close
    // lights up
    // Surveillance - by the numbers:
    //    establish a perimeter
    //    train the cameras
    //    identify the source
}
