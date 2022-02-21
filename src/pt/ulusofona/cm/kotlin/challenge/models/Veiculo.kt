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


    /*fun ajeitarData(data : String) : List<String>{
        return data.split(" ") as MutableList<String>
    }

    fun alterarDataAquisicao() {
        val sdf = SimpleDateFormat("dd M yyyy")
        val currentDate = sdf.format(Date())
        val datasAjeitadas = ajeitarData(currentDate)
        dataDeAquisicao = Date(datasAjeitadas[0].toInt(),datasAjeitadas[1].toInt(),datasAjeitadas[2].toInt())
    }*/

    fun alterarDataAquisicao() {
        dataDeAquisicao = Date()
    }

    /*@JvmName("getIdentificador1")
    fun getIdentificador() : String {
        return identificador
    }*/

    abstract fun requerCarta() : Boolean

    override fun toString(): String {
        return "Veiculo | $identificador | $dataDeAquisicao | Posicao | ${posicao.x} | ${posicao.y}"
    }


}