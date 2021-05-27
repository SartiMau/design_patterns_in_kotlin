package com.murosar.designpatternsinkotlin.creational

// interface CPU - Central Management Unit
interface CPU

// class EmberCPU
class EmberCPU : CPU

// class EnginolaCPU
class EnginolaCPU : CPU

//-----------------------------------------------------------------------------------------------------------------------------------------

// interface MMU - Memory Management Unit
interface MMU

// class EmberMMU
class EmberMMU : MMU

// class EnginolaMMU
class EnginolaMMU : MMU

//-----------------------------------------------------------------------------------------------------------------------------------------

// class EmberFactory
class EmberToolkit : AbstractFactory {
    override fun createCPU(): CPU {
        return EmberCPU()
    }

    override fun createMMU(): MMU {
        return EmberMMU()
    }
}

// class EnginolaFactory
class EnginolaToolkit : AbstractFactory {
    override fun createCPU(): CPU {
        return EnginolaCPU()
    }

    override fun createMMU(): MMU {
        return EnginolaMMU()
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

interface AbstractFactory {
    fun createCPU(): CPU
    fun createMMU(): MMU

    companion object {
        private val enginolaToolkit = EnginolaToolkit()
        private val emberToolkit = EmberToolkit()

        // Returns a concrete factory object that is an instance of the
        // concrete factory class appropriate for the given architecture.
        fun getFactory(architecture: Architecture): AbstractFactory {
            var factory: AbstractFactory? = null

            factory = when (architecture) {
                Architecture.ENGINOLA -> enginolaToolkit
                Architecture.EMBER -> emberToolkit
            }
            return factory
        }
    }
}

enum class Architecture {
    ENGINOLA, EMBER
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class AbstractFactoryClient {

    fun doSomething() {
        val factory = AbstractFactory.getFactory(Architecture.EMBER)

        // if we need a CPU object, we obtain it on this way
        val cpu = factory.createCPU()

        // if we need a MMU object, we obtain it on this way
        val mmu = factory.createMMU()
    }
}
