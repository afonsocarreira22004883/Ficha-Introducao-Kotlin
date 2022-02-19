package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import pt.ulusofona.cm.kotlin.challenge.models.Posicao
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date

class Main {
}



fun main(){
    var d = Date()
    val motor = Motor(1500,1500)
    var pos = Posicao()
    var carro = Carro(motor,"AA-11-AA",pos,d)
    var carro2 = Carro(motor,"BB-22-BB",pos,d)
    var pessoa = Pessoa("jorge",d)
    var pessoa2 = Pessoa("tropa",d)
    pessoa.comprarVeiculo(carro)
    //println(pessoa.veiculos[0].getIdentificador())
    //pessoa.moverVeiculoPara("AA-11-AA",0,12)
    pessoa.pesquisarVeiculo("AA-11-AA")
    pessoa.venderVeiculo(carro2,pessoa2)
    println(carro2.dataDeAquisicao)

}