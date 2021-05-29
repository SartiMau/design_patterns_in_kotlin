package com.murosar.designpatternsinkotlin.structural

import kotlin.math.sqrt

/* The OLD */
class SquarePeg(var width: Double)

//-----------------------------------------------------------------------------------------------------------------------------------------

/* The NEW */
class RoundHole(val radius: Int) {

    init {
        println("RoundHole: max SquarePeg is " + radius * sqrt(2.0))
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// Design a "wrapper" class that can "impedance match" the old to the new
internal class SquarePegAdapter(width: Double) {
    // The adapter/wrapper class "has a" instance of the legacy class
    private val squarePeg: SquarePeg = SquarePeg(width)

    // Identify the desired interface
    fun makeFit(roundHole: RoundHole) {
        // The adapter/wrapper class delegates to the legacy object
        val amount = squarePeg.width - roundHole.radius * sqrt(2.0)
        println("reducing SquarePeg " + squarePeg.width + " by " + (if (amount < 0) 0 else amount) + " amount")

        if (amount > 0) {
            squarePeg.width = squarePeg.width - amount
            println("   width is now " + squarePeg.width)
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class AdapterClient {

    fun doSomething() {
        val roundHole = RoundHole(5)
        var squarePegAdapter: SquarePegAdapter

        for (i in 6..9) {
            squarePegAdapter = SquarePegAdapter(i.toDouble())
            // The client uses (is coupled to) the new interface
            squarePegAdapter.makeFit(roundHole)
        }
    }
}
