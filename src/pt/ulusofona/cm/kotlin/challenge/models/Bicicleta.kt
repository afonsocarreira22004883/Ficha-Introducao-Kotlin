package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Bicicleta(identificador: String) : Veiculo(identificador) {
    //constructor(identificador: String,dataDeAquisicao: Date) : this(identificador,Posicao(),dataDeAquisicao)

    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x:Int, y:Int) {
        posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | ${Pessoa.formatarDatas(dataDeAquisicao)} | Posicao | ${posicao.x} | ${posicao.y}"
    }


}