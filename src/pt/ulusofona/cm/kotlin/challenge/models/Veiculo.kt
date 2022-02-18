package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.util.*

open class Veiculo(private var identificador : String, var posicao: Posicao, var dataDeAquisicao :Date) {


    fun mover(x :Int, y : Int) {
            posicao.alterarPosicaoPara(x,y)
    }

    fun getIdentificador() : String {
        return identificador
    }
 }