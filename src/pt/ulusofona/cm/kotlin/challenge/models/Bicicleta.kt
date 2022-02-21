package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Bicicleta(identificador: String, posicao: Posicao, dataDeAquisicao: Date) : Veiculo(identificador, posicao, dataDeAquisicao) {
    //constructor(identificador: String,dataDeAquisicao: Date) : this(identificador,Posicao(),dataDeAquisicao)

    override fun mover(x:Int, y:Int) {
        posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | $dataDeAquisicao | Posicao | ${posicao.x} | ${posicao.y}"
    }


}