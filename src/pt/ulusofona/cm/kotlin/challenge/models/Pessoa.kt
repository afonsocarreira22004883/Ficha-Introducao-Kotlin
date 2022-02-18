package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.util.*

class Pessoa(var nome: String, var veiculos: MutableList<Veiculo>, var dataDeNascimento: Date, var carta: Carta?, var posicao: Posicao?) {

    constructor(nome: String,dataDeNascimento: Date) : this (nome, emptyList<Veiculo>().toMutableList(),dataDeNascimento,null,null)
    constructor(nome: String,dataDeNascimento: Date, carta: Carta?) : this (nome, emptyList<Veiculo>().toMutableList(),dataDeNascimento,carta,null)

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador : String) : Veiculo?{
        for (i in 0 until veiculos.size) {
            if(veiculos[i].getIdentificador() == identificador) {
                return veiculos[i]
            }
        }
        return null
    }

    fun venderVeiculo(veiculo: Veiculo,comprador : Pessoa) : Boolean{
        if(pesquisarVeiculo(veiculo.getIdentificador()) == null) {
            return false
        } else {
            comprador.comprarVeiculo(veiculo)
            for (i in 0 until veiculos.size) {
                if(veiculos[i].getIdentificador() == veiculo.getIdentificador()) {
                    veiculos.removeAt(i)
                }
            }
            return true
        }
    }


    fun moverVeiculoPara(identificador : String,x : Int, y : Int) {
        for (i in 0 until veiculos.size) {
            if(veiculos[i].getIdentificador() == identificador) {
                try {
                    veiculos[i].mover(x,y)
                } catch (e : AlterarPosicaoException) {
                    println(e.message)
                    return
                }
            }
        }
    }

    fun temCarta(): Boolean {
        return carta != null
    }

    fun tirarCarta() {
        carta = Carta()
    }


}