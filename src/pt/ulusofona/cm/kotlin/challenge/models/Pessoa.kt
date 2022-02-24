package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

data class Pessoa(val nome: String, val dataDeNascimento: Date) : Movimentavel {
    var veiculos: MutableList<Veiculo> = emptyList<Veiculo>().toMutableList()
    var carta: Carta? = null
    var posicao: Posicao = Posicao(0,0)

    companion object {
        fun formatarDatas(data: Date): String {
            val f = SimpleDateFormat("dd-MM-yyyy")
            val d = f.format(data)
            return d
        }
    }

    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
            posicao.alterarPosicaoPara(x, y)
    }

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculo.alterarDataAquisicao()
        veiculos.add(veiculo)
    }


    @Throws(VeiculoNaoEncontradoException::class)
    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (i in 0 until veiculos.size) {
            if (veiculos[i].identificador == identificador) {
                return veiculos[i]
            }
        }
        return throw VeiculoNaoEncontradoException("$nome não possui o veiculo com a seguinte matricula : $identificador")
    }


    fun venderVeiculo(identificador: String, comprador: Pessoa): Boolean {
        for (i in 0 until veiculos.size) {
            if (veiculos[i].identificador == identificador) {
                veiculos[i].alterarDataAquisicao()
                comprador.comprarVeiculo(veiculos[i])
                veiculos.remove(veiculos[i])
                return true
            }
        }
        return false
    }

    @Throws(MenorDeIdadeException::class)
    fun eMaiorIdade(): Boolean {
        val data = Date()
        val idade = data.year - dataDeNascimento.year
        if (idade < 18) {
            throw MenorDeIdadeException("Não tem idade para tirar a carta!")
        }
        return true
    }


    @Throws(AlterarPosicaoException::class,PessoaSemCartaException::class)
    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for (i in 0 until veiculos.size) {
            if (veiculos[i].identificador == identificador) {
                if (veiculos[i].requerCarta() && !temCarta()) {
                    throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
                }
                veiculos[i].moverPara(x, y)
            }
        }
    }


    fun temCarta(): Boolean {
        return carta != null
    }

    @Throws(MenorDeIdadeException::class)
    fun tirarCarta() {
        if(eMaiorIdade()) {
            carta = Carta()
        }
    }

    fun ligarCarro(carro: Carro) {
        carro.motor.ligar()
    }

    fun desligarCarro(carro: Carro) {
        carro.motor.desligar()
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${formatarDatas(dataDeNascimento)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }


}