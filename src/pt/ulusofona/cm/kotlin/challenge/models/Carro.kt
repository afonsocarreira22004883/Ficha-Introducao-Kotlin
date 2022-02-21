package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.util.*

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador), Ligavel {
    //constructor(motor: Motor,identificador: String,dataDeAquisicao: Date) : this(motor,identificador,Posicao(),dataDeAquisicao)

    override fun requerCarta(): Boolean {
        return true
    }

    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
        if (motor.estaLigado()) {
            posicao.alterarPosicaoPara(x, y)
        } else {
            motor.ligar()
            posicao.alterarPosicaoPara(x, y)
            motor.desligar()
        }
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    @Throws(VeiculoDesligadoException::class)
    override fun ligar() {
        motor.ligar()
    }

    @Throws(VeiculoDesligadoException::class)
    override fun desligar() {
        motor.desligar()
    }

    override fun toString(): String {
        return "Carro | $identificador | ${Pessoa.formatarDatas(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }


}