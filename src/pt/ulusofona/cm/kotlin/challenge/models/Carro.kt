package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Carro(var motor: Motor, identificador: String, posicao: Posicao, dataDeAquisicao: Date) : Veiculo(identificador, posicao, dataDeAquisicao) {
}