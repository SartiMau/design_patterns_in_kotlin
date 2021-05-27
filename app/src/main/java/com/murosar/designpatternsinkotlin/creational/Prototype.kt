package com.murosar.designpatternsinkotlin.creational

// 1. The clone() contract
interface Prototype {
    val name: String

    fun clone(): Prototype
    fun execute()
}

//-----------------------------------------------------------------------------------------------------------------------------------------

object PrototypeModule {
    // 2. "registry" of prototypical objs
    private val prototypes: MutableList<Prototype> = ArrayList()

    // Add a feature to the Prototype attribute of the PrototypesModule class
    // obj The feature to be added to the Prototype attribute
    fun addPrototype(proto: Prototype) {
        prototypes.add(proto)
    }

    fun createPrototype(name: String): Prototype? {
        // 4. The "virtual constructor"
        for (proto in prototypes) {
            if (proto.name == name) {
                return proto.clone()
            }
        }
        println("$name: doesn't exist")
        return null
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// 5. Sign-up for the clone() contract.
// Each class calls "new" on itself FOR the client.
class PrototypeAlpha : Prototype {
    override val name = "AlphaVersion"

    override fun clone(): Prototype {
        return PrototypeAlpha()
    }

    override fun execute() {
        println("$name: does something")
    }
}

class PrototypeBeta : Prototype {
    override val name = "BetaVersion"

    override fun clone(): Prototype {
        return PrototypeBeta()
    }

    override fun execute() {
        println("$name: does something")
    }
}

class ReleasePrototype : Prototype {
    override val name = "ReleaseCandidate"

    override fun clone(): Prototype {
        return ReleasePrototype()
    }

    override fun execute() {
        println("$name: does real work")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class PrototypeClient {

    fun doSomething(args: Array<String>) {
        if (args.isNotEmpty()) {
            initializePrototypes()
            val prototypes: MutableList<Prototype> = ArrayList()
            // 6. Client does not use "new"
            for (protoName in args) {
                val prototype = PrototypeModule.createPrototype(protoName)
                if (prototype != null) {
                    prototypes.add(prototype)
                }
            }
            for (proto in prototypes) {
                proto.execute()
            }
        } else {
            println("Run again with arguments of command string ")
        }
    }

    // 3. Populate the "registry"
    private fun initializePrototypes() {
        PrototypeModule.addPrototype(PrototypeAlpha())
        PrototypeModule.addPrototype(PrototypeBeta())
        PrototypeModule.addPrototype(ReleasePrototype())
    }
}
