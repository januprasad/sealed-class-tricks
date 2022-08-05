package com.tmdb.kotlin_sealedclass

sealed class StudentType {

    sealed class Payment {

    }

    object SSLC : StudentType() {
        sealed class PaymentMode {

        }

        object PaymentNotDone : Payment()
        object PaymentDone : Payment() {
            object UPI : PaymentMode()
            object CC : PaymentMode()
        }

        object PaymentWaiting : Payment()
    }

    object PlusTwo : StudentType() {
        object PaymentNotDone : Payment()
        object PaymentDone : Payment()
        object PaymentWaiting : Payment()
    }

}

fun main() {
    val s1: StudentType.Payment = StudentType.SSLC.PaymentDone
    val s2: StudentType.Payment = StudentType.SSLC.PaymentWaiting
    val mode1: StudentType.SSLC.PaymentMode = StudentType.SSLC.PaymentDone.UPI
    val mode2: StudentType.SSLC.PaymentMode = StudentType.SSLC.PaymentDone.CC

    getColorForPaymentMode(mode1)
    getColorForPaymentMode(mode2)
    getColorForStudentPayment(s1)
    getColorForStudentPayment(s2)

}

fun getColorForStudentPayment(s1: StudentType.Payment) {
    when (s1) {
        StudentType.SSLC.PaymentDone -> "white"
        StudentType.PlusTwo.PaymentDone -> "black"
        StudentType.SSLC.PaymentNotDone -> "blue"
        StudentType.PlusTwo.PaymentNotDone -> "red"
        StudentType.SSLC.PaymentWaiting -> "yellow"
        StudentType.PlusTwo.PaymentWaiting -> "pink"
    }
}

fun getColorForPaymentMode(mode1: StudentType.SSLC.PaymentMode): String {
    return when (mode1) {
        StudentType.SSLC.PaymentDone.CC -> "black"
        StudentType.SSLC.PaymentDone.UPI -> "blue"
    }
}
