package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.Date


fun main(){
    val bike = Bicicleta("a")
    val m = Motor(500,500)
    val c = Carro("b",m)
    val p = Pessoa("toy",Date())
    p.comprarVeiculo(c)
    p.comprarVeiculo(bike)
    p.carta = Carta()
    p.moverVeiculoPara("b",1,1)
    p.moverVeiculoPara("a",2,2)
    println(bike.posicao)
    println(c.posicao)
}