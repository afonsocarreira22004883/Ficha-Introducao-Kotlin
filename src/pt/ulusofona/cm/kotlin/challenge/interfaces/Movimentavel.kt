package pt.ulusofona.cm.kotlin.challenge.interfaces

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

interface Movimentavel {
    @Throws(AlterarPosicaoException::class)
    abstract fun moverPara(x : Int,y : Int)
}