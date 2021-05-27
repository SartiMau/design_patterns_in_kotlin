package com.murosar.designpatternsinkotlin.creational

// This can be a class with a companion object that will have the private instance and the public getInstance
object Singleton {

    @Volatile
    private var instance: Singleton? = null

    fun getInstance(): Singleton? {
        if (instance == null) {
            synchronized(Singleton::class.java) {
                if (instance == null) {
                    instance = Singleton
                }
            }
        }
        return instance
    }
}

class SingletonClient {

    fun doSomething() {
        val singleton = Singleton.getInstance()
        // do whatever you want with the single instance.
    }
}
