package com.murosar.designpatternsinkotlin.behavioral

class StackChar {
    private val arr = CharArray(9)
    private var sp = -1

    private val isFull: Boolean
        get() = sp == arr.size - 1
    val isEmpty: Boolean
        get() = sp == -1

    fun push(ch: Char) {
        if (!isFull) {
            arr[++sp] = ch
        }
    }

    fun pop(): Char {
        return if (isEmpty) {
            '\u0000'
        } else {
            arr[sp--]
        }
    }
}

class StackInt {
    private val arr = IntArray(9)
    private var sp = -1

    private val isFull: Boolean
        get() = sp == arr.size - 1
    private val isEmpty: Boolean
        get() = sp == -1

    fun push(ch: Int) {
        if (!isFull) {
            arr[++sp] = ch
        }
    }

    fun pop(): Int {
        return if (isEmpty) {
            0
        } else {
            arr[sp--]
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class InterpreterClient {

    private fun precedence(a: Char, b: Char): Boolean {
        val high = "*/"
        val low = "+-"
        if (a == '(') {
            return false
        }
        if (a == ')' && b == '(') {
            println(")-(")
            return false
        }
        if (b == '(') {
            return false
        }
        if (b == ')') {
            return true
        }
        if (high.indexOf(a) > -1 && low.indexOf(b) > -1) {
            return true
        }
        if (high.indexOf(a) > -1 && high.indexOf(b) > -1) {
            return true
        }
        return low.indexOf(a) > -1 && low.indexOf(b) > -1
    }

    private fun convertToPostfix(expression: String): String {
        val operationsStack = StackChar()
        val out = StringBuilder()
        val operations = "+-*/()"
        var topSymbol = '+'
        var empty: Boolean
        for (i in expression.indices) {
            if (operations.indexOf(expression[i]) == -1) out.append(expression[i]) else {
                while (!operationsStack.isEmpty.also { empty = it }
                    && precedence(operationsStack.pop().also { topSymbol = it }, expression[i])) out.append(topSymbol)
                if (!empty) {
                    operationsStack.push(topSymbol)
                }
                if (empty || expression[i] != ')') {
                    operationsStack.push(expression[i])
                } else topSymbol = operationsStack.pop()
            }
        }
        while (!operationsStack.isEmpty) {
            out.append(operationsStack.pop())
        }
        return out.toString()
    }

    private fun evaluate(expression: String): Int {
        val stackInt = StackInt()
        val operations = "+-*/"
        var a: Int
        var b: Int
        var i = 0
        while (i < expression.length) {
            if (operations.indexOf(expression[i]) == -1) {
                stackInt.push(expression[i].toInt() - 48)
            } else {
                b = stackInt.pop()
                a = stackInt.pop()
                if (expression[i] == '+') {
                    a += b
                }
                if (expression[i] == '-') {
                    a -= b
                }
                if (expression[i] == '*') {
                    a *= b
                }
                if (expression[i] == '/') {
                    a /= b
                }
                stackInt.push(a)
            }
            i++
        }
        return stackInt.pop()
    }

    fun doSomething(expressions: Array<String>) {
        for (expression in expressions) {
            print(expression)
            val postfix = convertToPostfix(expression)
            print(" -- $postfix")
            println(" -- " + evaluate(postfix))
        }
    }

    // Print:
    // 2+3*4-5+6 -- 234*+5-6+ -- 15
    // (2+3)*4-5+6 -- 23+4*5-6+ -- 21
    // 2+3*(4-5)+6 -- 2345-*+6+ -- 5
    // 2+3*((4-5)+6) -- 2345-6+*+ -- 17
    // (3-(4*(5+6))/(7-8))*9/4 -- 3456+*78-/-9*4/ -- 105
}
