package com.murosar.designpatternsinkotlin.behavioral

abstract class Generalization {
    // 1. Standardize the skeleton of an algorithm in a "template" method
    fun findSolution() {
        stepOne()
        stepTwo()
        stepThree()
        stepFour()
    }

    // 2. Common implementations of individual steps are defined in base class
    private fun stepOne() {
        println("Generalization.stepOne")
    }

    // 3. Steps requiring peculiar implementations are "placeholders" in the base class
    abstract fun stepTwo()
    abstract fun stepThree()
    open fun stepFour() {
        println("Generalization.stepFour")
    }
}

abstract class Specialization : Generalization() {
    // 4. Derived classes can override placeholder methods
    // 1. Standardize the skeleton of an algorithm in a "template" method
    override fun stepThree() {
        step3_1()
        step3_2()
        step3_3()
    }

    // 2. Common implementations of individual steps are defined in base class
    private fun step3_1() {
        println("Specialization.step3_1")
    }

    // 3. Steps requiring peculiar implementations are "placeholders" in the base class
    protected abstract fun step3_2()
    private fun step3_3() {
        println("Specialization.step3_3")
    }
}

class Realization : Specialization() {
    // 4. Derived classes can override placeholder methods
    override fun stepTwo() {
        println("Realization.stepTwo")
    }

    override fun step3_2() {
        println("Realization.step3_2")
    }

    // 5. Derived classes can override implemented methods
    // 6. Derived classes can override and "call back to" base class methods
    override fun stepFour() {
        println("Realization.stepFour")
        super.stepFour()
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class TemplateMethodClient {

    fun doSomething() {
        val algorithm: Generalization = Realization()
        algorithm.findSolution()
    }

    // Print:
    // Generalization.stepOne
    // Realization.stepTwo
    // Specialization.step3_1
    // Realization.step3_2
    // Specialization.step3_3
    // Realization.stepFour
    // Generalization.stepFour
}
