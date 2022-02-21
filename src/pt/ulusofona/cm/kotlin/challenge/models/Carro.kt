package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import java.util.*

class Carro(var motor: Motor, identificador: String) : Veiculo(identificador) {
    //constructor(motor: Motor,identificador: String,dataDeAquisicao: Date) : this(motor,identificador,Posicao(),dataDeAquisicao)

    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x:Int, y:Int) {
        if(motor.estaLigado()) {
            posicao.alterarPosicaoPara(x,y)
        } else {
            motor.ligar()
            posicao.alterarPosicaoPara(x,y)
            motor.desligar()
        }
    }

    fun estaLigado() : Boolean {
        return motor.estaLigado()
    }

    fun ligar() {
        try {
            motor.ligar()
        } catch (e : VeiculoLigadoException) {
            println(e.message)
        }
    }

    fun desLigar() {
        try {
            motor.desligar()
        } catch (e : VeiculoDesligadoException) {
            println(e.message)
        }
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | $dataDeAquisicao | Posicao | ${posicao.x} | ${posicao.y}"
    }


}