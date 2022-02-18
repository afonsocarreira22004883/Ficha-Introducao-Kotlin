package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.util.*

class Pessoa(var nome: String, var veiculos: MutableList<Veiculo>, var dataDeNascimento: Date, var carta: Carta?, var posicao: Posicao) {

    constructor(nome: String,dataDeNascimento: Date) : this (nome, emptyList<Veiculo>().toMutableList(),dataDeNascimento,null, Posicao())
    constructor(nome: String,dataDeNascimento: Date, carta: Carta?) : this (nome, emptyList<Veiculo>().toMutableList(),dataDeNascimento,carta,Posicao())

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }


    fun pesquisarVeiculo(identificador : String) : Veiculo?{

        for (i in 0 until veiculos.size) {
            if(veiculos[i].getIdentificador() == identificador) {
                return veiculos[i]
            }
        }
        return throw VeiculoNaoEncontradoException("$nome não possui o veiculo com a seguinte matricula : $identificador")
    }

    fun venderVeiculo(veiculo: Veiculo,comprador : Pessoa) : Boolean{
        /*if(pesquisarVeiculo(veiculo.getIdentificador()) == null) {
            return false
        } else {
            comprador.comprarVeiculo(veiculo)
            for (i in 0 until veiculos.size) {
                if(veiculos[i].getIdentificador() == veiculo.getIdentificador()) {
                    veiculos.removeAt(i)
                }
            }
            return true
        }*/

        try {
            pesquisarVeiculo(veiculo.getIdentificador())
            veiculo.alterarDataAquisicao()
            comprador.comprarVeiculo(veiculo)
            for (i in 0 until veiculos.size) {
                if(veiculos[i].getIdentificador() == veiculo.getIdentificador()) {
                    veiculos.removeAt(i)
                }
            }
            return true
        } catch (e : VeiculoNaoEncontradoException) {
            println(e.message)
            return false
        }
    }

    fun eMaiorIdade() : Boolean {
        val data = Date()
        val idade = dataDeNascimento.year - data.year
        if(idade < 18) {
            throw MenorDeIdadeException("Não tem idade para tirar a carta!")
        }
        return true
    }


    fun moverVeiculoPara(identificador : String,x : Int, y : Int) {
        for (i in 0 until veiculos.size) {
            if(veiculos[i].getIdentificador() == identificador) {
                if(veiculos[i] is Carro ) {
                    try {
                        temCarta2()
                    } catch (e : PessoaSemCartaException) {
                        println(e.message)
                        return
                    }
                }
                try {
                    veiculos[i].mover(x,y)
                } catch (e : AlterarPosicaoException) {
                    println(e.message)
                    return
                }
            }
        }
    }

    fun temCarta2() {
        if(temCarta()) {
            return
        } else {
            throw PessoaSemCartaException("$nome não tem carta para poder conduzir este tipo de veiculos")
        }
    }

    fun temCarta(): Boolean {
        return carta != null
    }

    fun tirarCarta() {
        try {
            eMaiorIdade()
            carta = Carta()
        } catch (e : MenorDeIdadeException) {
            println(e.message)
        }
    }

    override fun toString(): String {
        return "Bicicleta | $nome | $dataDeNascimento | Posicao | ${posicao.x} | ${posicao.y}"
    }


}