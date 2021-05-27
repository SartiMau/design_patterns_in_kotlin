package com.murosar.designpatternsinkotlin.creational

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.Enumeration
import java.util.Hashtable

abstract class ObjectPool<T> {
    private val expirationTime: Long = 30000
    private val locked = Hashtable<T, Long>()
    private val unlocked = Hashtable<T, Long>()

    protected abstract fun create(): T
    abstract fun validate(o: T?): Boolean
    abstract fun expire(o: T?)

    @Synchronized
    fun checkOut(): T? {
        val now = System.currentTimeMillis()
        var t: T?

        if (unlocked.size > 0) {
            val enum: Enumeration<T> = unlocked.keys()

            while (enum.hasMoreElements()) {
                t = enum.nextElement()

                t = if (now - unlocked[t]!! > expirationTime) {
                    // object has expired
                    unlocked.remove(t)
                    expire(t)
                    null
                } else {
                    if (validate(t)) {
                        unlocked.remove(t)
                        locked[t] = now
                        return t
                    } else {
                        // object failed validation
                        unlocked.remove(t)
                        expire(t)
                        null
                    }
                }
            }
        }

        // no objects available, create a new one
        t = create()
        locked[t] = now
        return t
    }

    @Synchronized
    fun checkIn(t: T) {
        locked.remove(t)
        unlocked[t] = System.currentTimeMillis()
    }

    init {
        // 30 seconds
    }
}

//The three remaining methods are abstract and therefore must be implemented by the subclass
class JDBCConnectionPool(driver: String, dsn: String, user: String, password: String) : ObjectPool<Connection?>() {

    private val dsn: String
    private val user: String
    private val password: String

    init {
        try {
            Class.forName(driver).newInstance()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        this.dsn = dsn
        this.user = user
        this.password = password
    }

    override fun create(): Connection? {
        return try {
            DriverManager.getConnection(dsn, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    override fun expire(o: Connection?) {
        try {
            (o as Connection).close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    override fun validate(o: Connection?): Boolean {
        return try {
            !(o as Connection).isClosed
        } catch (e: SQLException) {
            e.printStackTrace()
            false
        }
    }
}
//-----------------------------------------------------------------------------------------------------------------------------------------

class ObjectPoolClient {
    fun doSomething() {
        // Do something...

        // Create the ConnectionPool (optionally we can give the pool a maxSize):
        val pool = JDBCConnectionPool("org.hsqldb.jdbcDriver", "jdbc:hsqldb://localhost/mydb", "sa", "secret")

        // Get a connection:
        val con = pool.checkOut()

        // Use the connection

        // Return the connection:
        pool.checkIn(con)
    }
}
