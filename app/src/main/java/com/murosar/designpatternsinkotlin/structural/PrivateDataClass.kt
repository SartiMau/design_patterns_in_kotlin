package com.murosar.designpatternsinkotlin.structural

import android.graphics.Color

// Before: without the pattern
class CircleWithoutPattern(private var radius: Double, private var color: Color, private var origin: Point) {

    fun circumference() : Double = 2 * Math.PI * this.radius

    fun diameter() : Double = 2 * this.radius

    fun draw() {
        //...
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// After: with the pattern
data class CircleData(var radius: Double, var color: Color, var origin: Point)

class Circle(radius: Double, color: Color, origin: Point) {

    private var circleData: CircleData = CircleData(radius, color, origin)

    fun circumference() : Double = 2 * Math.PI * circleData.radius

    fun diameter() : Double = 2 * circleData.radius

    fun draw() {
        //...
    }
}
