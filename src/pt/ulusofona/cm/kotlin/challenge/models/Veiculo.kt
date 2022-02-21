package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo() : Movimentavel {
    var identificador: String = ""
    var posicao = Posicao()
    var dataDeAquisicao = Date()

    constructor(identificador: String) : this() {
        this.identificador = identificador
    }

    fun alterarDataAquisicao() {
        dataDeAquisicao = Date()
    }

    abstract fun requerCarta() : Boolean

    override fun toString(): String {
        return "Veiculo | $identificador | ${Pessoa.formatarDatas(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }


}