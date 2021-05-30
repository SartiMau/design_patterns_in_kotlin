package com.murosar.designpatternsinkotlin.structural

// 1. "lowest common denominator"
interface Widget {
    fun draw()
}

// 3. "Core" class with "is a" relationship
class TextField(private val width: Int, private val height: Int) : Widget {

    override fun draw() {
        println("TextField: $width, $height")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// 2. Second level base class with "isa" relationship
abstract class Decorator(
    private val widget: Widget // 4. "has a" relationship
) : Widget {

    // 5. Delegation
    override fun draw() {
        widget.draw()
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// 6. Optional embellishment
class BorderDecorator(widget: Widget) : Decorator(widget) {

    override fun draw() {
        // 7. Delegate to base class and add extra stuff
        super.draw()
        println("   BorderDecorator")
    }
}

// 6. Optional embellishment
class ScrollDecorator(widget: Widget) : Decorator(widget) {

    override fun draw() {
        // 7. Delegate to base class and add extra stuff
        super.draw()
        println("   ScrollDecorator")
    }
}

// 6. Optional embellishment
class ColorDecorator(widget: Widget) : Decorator(widget) {

    override fun draw() {
        // 7. Delegate to base class and add extra stuff
        super.draw()
        println("   ColorDecorator")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class DecoratorClient {

    fun doSomething() {
        // 8. Client has the responsibility to compose desired configurations
        val widget: Widget = BorderDecorator(ColorDecorator(ScrollDecorator(TextField(80, 24))))
        widget.draw()
    }
}
