package com.murosar.designpatternsinkotlin.behavioral

interface Element {
    fun accept(visitor: Visitor)
}

class ElementFOO : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    val fOO: String
        get() = "FOO"
}

class ElementBAR : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    val bAR: String
        get() = "BAR"
}

class ElementBAZ : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    val bAZ: String
        get() = "BAZ"
}

//-----------------------------------------------------------------------------------------------------------------------------------------

interface Visitor {
    fun visit(foo: ElementFOO)
    fun visit(bar: ElementBAR)
    fun visit(baz: ElementBAZ)
}

class UpVisitor : Visitor {
    override fun visit(foo: ElementFOO) {
        println("do Up on ${foo.fOO}")
    }

    override fun visit(bar: ElementBAR) {
        println("do Up on ${bar.bAR}")
    }

    override fun visit(baz: ElementBAZ) {
        println("do Up on ${baz.bAZ}")
    }
}

class DownVisitor : Visitor {
    override fun visit(foo: ElementFOO) {
        println("do Down on ${foo.fOO}")
    }

    override fun visit(bar: ElementBAR) {
        println("do Down on ${bar.bAR}")
    }

    override fun visit(baz: ElementBAZ) {
        println("do Down on ${baz.bAZ}")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class VisitorClient {

    fun doSomething() {
        val list = arrayOf(ElementFOO(), ElementBAR(), ElementBAZ())
        val up = UpVisitor()
        val down = DownVisitor()

        for (element in list) {
            element.accept(up)
        }

        for (element in list) {
            element.accept(down)
        }
    }

    // Print:
    // do Up on FOO
    // do Up on BAR
    // do Up on BAZ
    // do Down on FOO
    // do Down on BAR
    // do Down on BAZ
}
