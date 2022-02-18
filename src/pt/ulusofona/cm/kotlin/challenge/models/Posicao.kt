package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Posicao(private var x : Int, private var y : Int) {

    constructor() : this (0,0) {
}

    fun alterarPosicaoPara(x: Int,y :Int){
        if(x == this.x || y == this.y) {
            throw AlterarPosicaoException("Tentaste mover-te para a mesma posição!")
        }
        this.x = x
        this.y = y
    }
}