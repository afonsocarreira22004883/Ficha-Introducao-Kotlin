package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

class Pessoa(val nome: String, val dataDeNascimento: Date) :Movimentavel {
    var veiculos: MutableList<Veiculo> = emptyList<Veiculo>().toMutableList()
    var carta: Carta? = null
    var posicao: Posicao = Posicao()

    companion object {
        fun formatarDatas(data : Date) : String {
            val f = SimpleDateFormat("dd-MM-yyyy")
            val d = f.format(data)
            return d
        }
    }

    override fun moverPara(x: Int, y: Int) {
        try {
            posicao.alterarPosicaoPara(x,y)
        } catch (e : AlterarPosicaoException) {
            throw e
        }
    }

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculo.alterarDataAquisicao()
        veiculos.add(veiculo)
    }



    fun pesquisarVeiculo(identificador : String) : Veiculo{
        for (i in 0 until veiculos.size) {
            if(veiculos[i].identificador == identificador) {
                return veiculos[i]
            }
        }
        return throw VeiculoNaoEncontradoException("$nome não possui o veiculo com a seguinte matricula : $identificador")
    }


    fun venderVeiculo(identificador: String,comprador : Pessoa) : Boolean{
            for (i in 0..veiculos.size) {
                if(veiculos[i].identificador == identificador) {
                    veiculos[i].alterarDataAquisicao()
                    comprador.comprarVeiculo(veiculos[i])
                    veiculos.remove(veiculos[i])
                    return true
                }
            }
        return false
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
            if(veiculos[i].identificador == identificador) {
                if(veiculos[i] is Carro ) {
                    try {
                        temCarta2()
                    } catch (e : PessoaSemCartaException) {
                        println(e.message)
                        throw e
                    }
                }
                try {
                    veiculos[i].moverPara(x,y)
                } catch (e : AlterarPosicaoException) {
                    println(e.message)
                    throw e
                }
            }
        }
    }

    fun temCarta2() {
        if(temCarta()) {
            return
        } else {
            throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
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
            throw e
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${formatarDatas(dataDeNascimento)} | Posicao | ${posicao.x} | ${posicao.y}"
    }


}