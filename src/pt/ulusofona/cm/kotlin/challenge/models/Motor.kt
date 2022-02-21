package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos : Int,var cilindrada : Int) :Ligavel {
    var ligado  = false

    override fun estaLigado() : Boolean{
        return ligado
    }

    @Throws(VeiculoLigadoException::class)
    override fun ligar() {
        if(ligado) {
            throw VeiculoLigadoException("O veiculo já se encontra ligado")
        }
        ligado = true
    }

    @Throws(VeiculoDesligadoException::class)
    override fun desligar() {
        if(!ligado) {
            throw VeiculoDesligadoException("O veiculo já se encontra desligado")
        }
        ligado = false
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }


}