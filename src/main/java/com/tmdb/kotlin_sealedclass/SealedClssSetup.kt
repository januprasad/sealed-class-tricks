package com.tmdb.kotlin_sealedclass


sealed class Color {
    object Read : Color() {
        object Pay : Variant()
        object Collect : Variant()
    }

    object Write : Color() {
        object Android : Variant()
        object Ios : Variant()
    }

    object Print : Color() {
        object Exynos : Variant()
        object Snpag : Variant()
    }
}

sealed class Variant

fun main() {
    val c: Variant = Color.Read.Pay
    val color = getColorFromTType(c)
    println(color)
}

fun getColorFromTType(c: Variant): String {
    return when (c) {
        Color.Write.Android -> {
            "Pink"
        }
        Color.Read.Collect -> {
            "Magenta"
        }
        Color.Print.Exynos -> {
            "White"
        }
        Color.Write.Ios -> {
            "Cyan"
        }
        Color.Read.Pay -> {
            "Blue"
        }
        Color.Print.Snpag -> {
            "Red"
        }
    }
}
