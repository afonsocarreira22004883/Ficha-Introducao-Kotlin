package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel


class Carro(identificador: String, var motor: Motor) : Veiculo(identificador), Ligavel {


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


    override fun ligar() {
        motor.ligar()
    }


    override fun desligar() {
        motor.desligar()
    }

    override fun toString(): String {
        return "Carro | $identificador | ${Pessoa.formatarDatas(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }


}