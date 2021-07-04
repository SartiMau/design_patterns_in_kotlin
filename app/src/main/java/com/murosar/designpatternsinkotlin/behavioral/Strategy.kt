package com.murosar.designpatternsinkotlin.behavioral

// 1. Define the interface of the algorithm
interface Strategy {
    fun solve()
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// 2. Bury implementation
abstract class StrategySolution : Strategy {
    // 3. Template Method
    override fun solve() {
        start()
        while (nextTry() && !isSolution) { }
        stop()
    }

    abstract fun start()
    abstract fun nextTry(): Boolean
    abstract val isSolution: Boolean
    abstract fun stop()
}

class FOO : StrategySolution() {
    private var state = 1
    override fun start() {
        print("Start  ")
    }

    override fun stop() {
        println("Stop")
    }

    override fun nextTry(): Boolean {
        print("NextTry-${state++}  ")
        return true
    }

    override val isSolution: Boolean
        get() {
            print("IsSolution-${state == 3}  ")
            return state == 3
        }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// 2. Bury implementation
abstract class StrategySearch : Strategy {

    // 3. Template Method
    override fun solve() {
        while (true) {
            preProcess()
            if (search()) {
                break
            }
            postProcess()
        }
    }

    abstract fun preProcess()
    abstract fun search(): Boolean
    abstract fun postProcess()
}

class BAR : StrategySearch() {
    private var state = 1
    override fun preProcess() {
        print("PreProcess  ")
    }

    override fun postProcess() {
        print("PostProcess  ")
    }

    override fun search(): Boolean {
        print("Search-${state++}  ")
        return state == 3
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// 4. Clients couple strictly to the interface
class StrategyClient {
    fun doSomething() {
        val algorithms = arrayOf(BAR(), FOO())
        for (algorithm in algorithms) {
            execute(algorithm)
        }
    }

    // client code here
    private fun execute(strategy: Strategy) {
        strategy.solve()
    }

    // Print:
    // PreProcess  Search-1  PostProcess  PreProcess  Search-2
    // Start  NextTry-1  IsSolution-false  NextTry-2  IsSolution-true  Stop
}
