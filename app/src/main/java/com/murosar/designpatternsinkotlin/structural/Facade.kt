package com.murosar.designpatternsinkotlin.structural

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

// 1. Subsystem
class PointCartesian(var x: Double, var y: Double) {

    fun move(x: Int, y: Int) {
        this.x += x.toDouble()
        this.y += y.toDouble()
    }

    override fun toString(): String {
        return "($x,$y)"
    }
}

// 1. Subsystem
class PointPolar(private val radius: Double, private var angle: Double) {
    fun rotate(angle: Int) {
        this.angle += (angle % 360).toDouble()
    }

    override fun toString(): String {
        return "[$radius@$angle]"
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// 1. Desired interface: move(), rotate()
class Point(x: Double, y: Double) {
    // 2. Design a "wrapper" class
    private var pointCartesian: PointCartesian

    init {
        pointCartesian = PointCartesian(x, y)
    }

    // 4. Wrapper maps
    fun move(x: Int, y: Int) {
        pointCartesian.move(x, y)
    }

    fun rotate(angle: Int, o: Point) {
        val x = pointCartesian.x - o.pointCartesian.x
        val y = pointCartesian.y - o.pointCartesian.y
        val pointPolar = PointPolar(sqrt(x * x + y * y), atan2(y, x) * 180 / Math.PI)

        // 4. Wrapper maps
        pointPolar.rotate(angle)
        println("  PointPolar is $pointPolar")
        val str = pointPolar.toString()
        val i = str.indexOf('@')
        val r = str.substring(1, i).toDouble()
        val a = str.substring(i + 1, str.length - 1).toDouble()
        pointCartesian = PointCartesian(
            r * cos(a * Math.PI / 180) + o.pointCartesian.x,
            r * sin(a * Math.PI / 180) + o.pointCartesian.y
        )
    }

    override fun toString(): String {
        return pointCartesian.toString()
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class Line(private val o: Point, private val e: Point) {
    fun move(x: Int, y: Int) {
        o.move(x, y)
        e.move(x, y)
    }

    fun rotate(angle: Int) {
        e.rotate(angle, o)
    }

    override fun toString(): String {
        return "origin is $o, end is $e"
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class FacadeClient {

    fun doSomething() {
        // 3. Client uses the Facade
        val lineA = Line(Point(2.0, 4.0), Point(5.0, 7.0))
        lineA.move(-2, -4)
        println("after move:  $lineA")

        lineA.rotate(45)
        println("after rotate: $lineA")

        val lineB = Line(Point(2.0, 1.0), Point(2.866, 1.5))
        lineB.rotate(30)
        println("30 degrees to 60 degrees: $lineB")
    }

    // Print:
    // after move:  origin is (0.0,0.0), end is (3.0,3.0)
    // PointPolar is [4.242640687119285@90.0]
    // after rotate: origin is (0.0,0.0), end is (2.5978681687064796E-16,4.242640687119285)
    // PointPolar is [0.9999779997579947@60.000727780827376]
    // 30 degrees to 60 degrees: origin is (2.0,1.0), end is (2.499977999677324,1.8660127018922195)
}
