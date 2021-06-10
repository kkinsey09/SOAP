package us.cpwa.firedept

import javax.swing.WindowConstants

fun main() {
    with(SOAP()) {
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        setSize(630, 290)
        isVisible = true
    }
}