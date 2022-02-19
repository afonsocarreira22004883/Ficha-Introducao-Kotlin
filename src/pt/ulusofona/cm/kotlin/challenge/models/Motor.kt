package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException

class Motor(var cavalos : Int,var cilindrada : Int,var ligado : Boolean) {
    constructor(cavalos : Int,cilindrada : Int) : this(cavalos,cilindrada,false)
    fun estaLigado() : Boolean{
        return ligado
    }

    fun ligar() {
        if(ligado) {
            throw VeiculoLigadoException("O veiculo já se encontra ligado")
        }
        ligado = true
    }

    fun desligar() {
        if(!ligado) {
            throw VeiculoDesligadoException("O veiculo já se encontra desligado")
        }
        ligado = false
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }


}