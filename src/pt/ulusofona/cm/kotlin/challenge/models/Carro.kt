package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Carro(identificador: String, posicao: Posicao, dataDeAquisicao: Date, motor: Motor) :
    Veiculo(identificador, posicao, dataDeAquisicao) {
}