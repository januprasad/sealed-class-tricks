package com.tmdb.kotlin_sealedclass

enum class State {
    READ,
    WRITE,
    PRINT
}

enum class Type {
    PAY,
    COLLECT,
    MANDATE
}

fun main() {

    val state = State.PRINT
    val type = Type.PAY
    val color = when (state) {
        State.READ -> {
            when (type) {
                Type.PAY, Type.COLLECT -> "black"
                Type.MANDATE -> "red"
            }
        }
        State.WRITE -> {
            when (type) {
                Type.PAY, Type.COLLECT, Type.MANDATE -> "blue"
            }
        }
        State.PRINT -> {
            when (type) {
                Type.PAY -> "black"
                Type.COLLECT -> "cyan"
                Type.MANDATE -> "black"
            }
        }
    }
    println(color)

}
