package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.util.*

class Carro(identificador: String,var motor: Motor ) : Veiculo(identificador),Ligavel {
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

    override fun estaLigado() : Boolean {
        return motor.estaLigado()
    }

    override fun ligar() {
        try {
            motor.ligar()
        } catch (e : VeiculoLigadoException) {
            println(e.message)
            throw e
        }
    }

    override fun desligar() {
        try {
            motor.desligar()
        } catch (e : VeiculoDesligadoException) {
            println(e.message)
            throw e
        }
    }

    override fun toString(): String {
        return "Carro | $identificador | ${Pessoa.formatarDatas(dataDeAquisicao)} | Posicao | ${posicao.x} | ${posicao.y}"
    }


}