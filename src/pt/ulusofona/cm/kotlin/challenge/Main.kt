package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.Date


fun main(){
    val data = Date("2000/10/24")
    val bike = Bicicleta("a")
    val m = Motor(500,500)
    val c = Carro("b",m)
    val p = Pessoa("toy",data)
    p.comprarVeiculo(c)
    p.comprarVeiculo(bike)
    println(p)
    p.tirarCarta()
    p.carta = Carta()
    p.moverVeiculoPara("b",1,1)

}