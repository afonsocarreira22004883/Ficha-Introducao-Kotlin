package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Posicao(var x: Int, var y: Int) {


    @Throws(AlterarPosicaoException::class)
    fun alterarPosicaoPara(x: Int, y: Int) {
        if (x == this.x && y == this.y) {
            throw AlterarPosicaoException("Tentaste mover-te para a mesma posição!")
        }
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }


}