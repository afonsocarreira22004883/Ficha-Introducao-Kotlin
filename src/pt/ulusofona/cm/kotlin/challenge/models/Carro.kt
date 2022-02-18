package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import java.util.*

class Carro(var motor: Motor, identificador: String, posicao: Posicao, dataDeAquisicao: Date) : Veiculo(identificador, posicao, dataDeAquisicao) {

    override fun mover(x:Int, y:Int) {
        if(motor.estaLigado()) {
            posicao.alterarPosicaoPara(x,y)
        } else {
            motor.ligar()
            posicao.alterarPosicaoPara(x,y)
            motor.desLigar()
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
            motor.desLigar()
        } catch (e : VeiculoDesligadoException) {
            println(e.message)
        }
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | $dataDeAquisicao | Posicao | ${posicao.x} | ${posicao.y}"
    }


}