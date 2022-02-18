package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import pt.ulusofona.cm.kotlin.challenge.models.Posicao
import java.util.Date

class Main {
}

fun main(){
    var d = Date()
    val motor = Motor(1500,1500)
    var pos = Posicao()
    var carro = Carro(motor,"AA-11-BB",pos,d)
    var pessoa = Pessoa("jorge",d)
    println(pessoa.veiculos)
    pessoa.comprarVeiculo(carro)
    println(pessoa.veiculos[0].getIdentificador())
    pessoa.moverVeiculoPara("AA-11-BB",0,12)
}