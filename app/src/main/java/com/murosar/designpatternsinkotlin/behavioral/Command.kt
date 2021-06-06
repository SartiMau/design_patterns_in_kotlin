package com.murosar.designpatternsinkotlin.behavioral

interface Command {
    fun execute()
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class DomesticEngineer : Command {
    override fun execute() {
        println("take out the trash")
    }
}

class Politician : Command {
    override fun execute() {
        println("take money from the rich, take votes from the poor")
    }
}

class Programmer : Command {
    override fun execute() {
        println("sell the bugs, charge extra for the fixes")
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class CommandClient {

    fun doSomething() {
        val queue = produceRequests()
        workOffRequests(queue)
    }

    companion object {
        private fun produceRequests(): List<Command> {
            val queue: MutableList<Command> = ArrayList()
            queue.add(DomesticEngineer())
            queue.add(Politician())
            queue.add(Programmer())
            return queue
        }

        private fun workOffRequests(queue: List<Command>) {
            for (command in queue) {
                command.execute()
            }
        }
    }
}
