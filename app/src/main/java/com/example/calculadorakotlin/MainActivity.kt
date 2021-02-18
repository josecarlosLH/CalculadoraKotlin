package com.example.calculadorakotlin

import android.icu.util.UniversalTimeScale.toLong
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var esNuevaOperacion = true
    var numeroAntiguo = ""
    var modo = "hex"
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (esNuevaOperacion)
            txvInput.setText("")
        esNuevaOperacion = false

        var buttonClick = txvInput.text.toString()
        var buttonSelect = view as Button
        when(buttonSelect.id) {
            button1.id -> {
                buttonClick += "1"
            }
            button2.id -> {
                buttonClick += "2"
            }
            button3.id -> {
                buttonClick += "3"
            }
            button4.id -> {
                buttonClick += "4"
            }
            button5.id -> {
                buttonClick += "5"
            }
            button6.id -> {
                buttonClick += "6"
            }
            button7.id -> {
                buttonClick += "7"
            }
            button8.id -> {
                buttonClick += "8"
            }
            button9.id -> {
                buttonClick += "9"
            }
            button0.id -> {
                buttonClick += "0"
            }
        }
        txvInput.setText(buttonClick)
    }

    fun letterEvent(view: View) {
        if (esNuevaOperacion)
            txvInput.setText("")
        esNuevaOperacion = false

        var buttonClick = txvInput.text.toString()
        var buttonSelect = view as Button
        when (buttonSelect.id) {
            buttonA.id -> {
                buttonClick += "A"
            }
            buttonB.id -> {
                buttonClick += "B"
            }
            buttonC.id -> {
                buttonClick += "C"
            }
            buttonD.id -> {
                buttonClick += "D"
            }
            buttonE.id -> {
                buttonClick += "E"
            }
            buttonF.id -> {
                buttonClick += "F"
            }
        }
        txvInput.setText(buttonClick)
    }

    fun operatorEvent(view: View) {
        esNuevaOperacion = true
        numeroAntiguo = txvInput.text.toString()
        var buttonSelected = view as Button
        when(buttonSelected.id) {
            buttonMas.id -> {
                op = "+"
            }
            buttonMenos.id -> {
                op = "−"
            }
            buttonMultiplica.id -> {
                op = "×"
            }
            buttonDivide.id -> {
                op = "÷"
            }
        }
    }

    fun equalEvent(view: View) {
        var nuevoNumero = txvInput.text.toString()

        var resultadoDec = 0.0
        var resultadoHexBin = 0
        var resultadoString = ""

        when(op) {
            "+" -> {
                if (modo == "dec") {
                    resultadoDec = numeroAntiguo.toDouble() + nuevoNumero.toDouble()
                } else if (modo == "bin") {
                    resultadoHexBin = numeroAntiguo.toInt(2) + nuevoNumero.toInt(2)
                    resultadoString = Integer.toBinaryString(resultadoHexBin)
                } else if (modo == "hex") {
                    resultadoHexBin = numeroAntiguo.toLong(16).toInt() + nuevoNumero.toLong(16).toInt()
                    resultadoString = Integer.toHexString(resultadoHexBin)
                }
            }
            "−" -> {
                if (modo == "dec") {
                    resultadoDec = numeroAntiguo.toDouble() - nuevoNumero.toDouble()
                } else if (modo == "bin") {
                    resultadoHexBin = numeroAntiguo.toInt(2) - nuevoNumero.toInt(2)
                    resultadoString = Integer.toBinaryString(resultadoHexBin)
                } else if (modo == "hex") {
                    resultadoHexBin = numeroAntiguo.toLong(16).toInt() - nuevoNumero.toLong(16).toInt()
                    resultadoString = Integer.toHexString(resultadoHexBin)
                }
            }
            "×" -> {
                if (modo == "dec") {
                    resultadoDec = numeroAntiguo.toDouble() * nuevoNumero.toDouble()
                } else if (modo == "bin") {
                    resultadoHexBin = numeroAntiguo.toInt(2) * nuevoNumero.toInt(2)
                    resultadoString = Integer.toBinaryString(resultadoHexBin)
                } else if (modo == "hex") {
                    resultadoHexBin = numeroAntiguo.toLong(16).toInt() * nuevoNumero.toLong(16).toInt()
                    resultadoString = Integer.toHexString(resultadoHexBin)
                }
            }
            "÷" -> {
                if (modo == "dec") {
                    resultadoDec = numeroAntiguo.toDouble() / nuevoNumero.toDouble()
                } else if (modo == "bin") {
                    resultadoHexBin = numeroAntiguo.toInt(2) / nuevoNumero.toInt(2)
                    resultadoString = Integer.toBinaryString(resultadoHexBin)
                } else if (modo == "hex") {
                    resultadoHexBin = numeroAntiguo.toLong(16).toInt() / nuevoNumero.toLong(16).toInt()
                    resultadoString = Integer.toHexString(resultadoHexBin)
                }
            }
        }
        if (modo == "dec") {
            txvInput.setText(resultadoDec.toString())
        } else {
            txvInput.setText(resultadoString)
        }

    }

    fun ceEvent(view: View) {
        txvInput.setText("0")
        esNuevaOperacion = true
    }

    fun binaryEvent(view: View) {
        modo = "bin"
        txvInput.setText("0")
        esNuevaOperacion = true

        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
        buttonA.isEnabled = false
        buttonB.isEnabled = false
        buttonC.isEnabled = false
        buttonD.isEnabled = false
        buttonE.isEnabled = false
        buttonF.isEnabled = false
    }

    fun hexdecimalEvent(view: View) {
        modo = "hex"
        txvInput.setText("0")
        esNuevaOperacion = true

        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        buttonA.isEnabled = true
        buttonB.isEnabled = true
        buttonC.isEnabled = true
        buttonD.isEnabled = true
        buttonE.isEnabled = true
        buttonF.isEnabled = true
    }

    fun decimalEvent(view: View) {
        modo = "dec"
        txvInput.setText("0")
        esNuevaOperacion = true

        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        buttonA.isEnabled = false
        buttonB.isEnabled = false
        buttonC.isEnabled = false
        buttonD.isEnabled = false
        buttonE.isEnabled = false
        buttonF.isEnabled = false
    }
}