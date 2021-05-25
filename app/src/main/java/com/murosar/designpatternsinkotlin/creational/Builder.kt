package com.murosar.designpatternsinkotlin.creational

/* "Product" */
class Pizza {
    private var dough = ""
    private var sauce = ""
    private var topping = ""

    fun setDough(dough: String) {
        this.dough = dough
    }

    fun setSauce(sauce: String) {
        this.sauce = sauce
    }

    fun setTopping(topping: String) {
        this.topping = topping
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

/* "Abstract Builder" */
abstract class PizzaBuilder {
    var pizza: Pizza? = null

    fun createNewPizzaProduct() {
        pizza = Pizza()
    }

    abstract fun buildDough()
    abstract fun buildSauce()
    abstract fun buildTopping()
}

//-----------------------------------------------------------------------------------------------------------------------------------------

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder : PizzaBuilder() {
    override fun buildDough() {
        pizza?.setDough("cross")
    }

    override fun buildSauce() {
        pizza?.setSauce("mild")
    }

    override fun buildTopping() {
        pizza?.setTopping("ham+pineapple")
    }
}

/* "ConcreteBuilder" */
internal class SpicyPizzaBuilder : PizzaBuilder() {
    override fun buildDough() {
        pizza?.setDough("pan baked")
    }

    override fun buildSauce() {
        pizza?.setSauce("hot")
    }

    override fun buildTopping() {
        pizza?.setTopping("pepperoni+salami")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

/* "Director" */
internal class Waiter {
    private var pizzaBuilder: PizzaBuilder? = null

    fun setPizzaBuilder(pb: PizzaBuilder?) {
        pizzaBuilder = pb
    }

    val pizza: Pizza?
        get() = pizzaBuilder?.pizza

    fun constructPizza() {
        pizzaBuilder?.createNewPizzaProduct()
        pizzaBuilder?.buildDough()
        pizzaBuilder?.buildSauce()
        pizzaBuilder?.buildTopping()
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

/* A customer ordering a pizza. */
class PizzaBuilderDemo {

    fun doSomething() {
        val waiter = Waiter()

        // If want a Hawaiian pizza I get the
        val hawaiianPizzaBuilder: PizzaBuilder = HawaiianPizzaBuilder()

        // If want a Hawaiian pizza
        val spicyPizzaBuilder: PizzaBuilder = SpicyPizzaBuilder()

        // Here we set the builder
        waiter.setPizzaBuilder(hawaiianPizzaBuilder)
        waiter.constructPizza()

        val pizza = waiter.pizza
    }
}
