package us.cpwa.firedept

import javax.swing.WindowConstants

fun main() {
    with(SOAP()) {
        defaultCloseOperation = WindowConstants.DO_NOTHING_ON_CLOSE
        setSize(900, 700)
        isVisible = true
    }
}