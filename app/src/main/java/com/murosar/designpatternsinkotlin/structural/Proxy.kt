package com.murosar.designpatternsinkotlin.structural

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import java.util.Scanner

// 1. Create a "wrapper" for a remote, or expensive, or sensitive target
// 2. Encapsulate the complexity/overhead of the target in the wrapper
// 3. The client deals with the wrapper
// 4. The wrapper delegates to the target
// 5. To support plug-compatibility of wrapper and target, create an interface

//-----------------------------------------------------------------------------------------------------------------------------------------

// 5. To support plug-compatibility between the wrapper and the target, create an interface
interface SocketInterface {
    fun readLine(): String?
    fun writeLine(str: String?)
    fun dispose()
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class SocketProxy(host: String?, port: Int, wait: Boolean) : SocketInterface {
    // 1. Create a "wrapper" for a remote, expensive, or sensitive target
    private lateinit var socket: Socket
    private lateinit var inBufferedReader: BufferedReader
    private lateinit var out: PrintWriter

    init {
        try {
            socket = if (wait) {
                // 2. Encapsulate the complexity/overhead of the target in the wrapper
                val server = ServerSocket(port)
                server.accept()
            } else {
                Socket(host, port)
            }
            inBufferedReader = BufferedReader(InputStreamReader(socket.getInputStream()))
            out = PrintWriter(socket.getOutputStream(), true)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun readLine(): String? {
        var line: String? = null
        try {
            line = inBufferedReader.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return line
    }

    override fun writeLine(str: String?) {
        // 4. The wrapper delegates to the target
        out.println(str)
    }

    override fun dispose() {
        try {
            socket.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class ProxyClient {

    fun doSomething(args: Array<String>) {
        // 3. The client deals with the wrapper
        val socket: SocketInterface = SocketProxy("127.0.0.1", 8080, args[0] == "first")
        var line: String?
        var skip = true

        while (true) {
            if (args[0] == "second" && skip) {
                skip = !skip
            } else {
                line = socket.readLine()
                println("Receive - $line")
                if (line == null) {
                    break
                }
            }
            print("Send ---- ")
            line = Scanner(System.`in`).nextLine()
            socket.writeLine(line)
            if (line == "quit") {
                break
            }
        }
        socket.dispose()
    }
}
