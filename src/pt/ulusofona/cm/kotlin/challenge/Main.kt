package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Bicicleta
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import pt.ulusofona.cm.kotlin.challenge.models.Veiculo
import java.util.Date


fun main(){
    var bike = Bicicleta("a")
    val p = Pessoa("toy",Date())
    println(p.toString())
}