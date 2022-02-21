package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

abstract class Veiculo( var identificador : String, var posicao: Posicao, var dataDeAquisicao :Date) : Movimentavel {
    constructor(identificador : String) : this(identificador,Posicao(),Date())



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

    @JvmName("getIdentificador1")
    fun getIdentificador() : String {
        return identificador
    }

    abstract fun requerCarta() : Boolean


 }