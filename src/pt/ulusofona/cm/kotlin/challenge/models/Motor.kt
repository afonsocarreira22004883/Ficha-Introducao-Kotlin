package pt.ulusofona.cm.kotlin.challenge.models

class Motor(var cavalos : Int,var cilindrada : Int,var ligado : Boolean) {
    constructor(cavalos : Int,cilindrada : Int) : this(cavalos,cilindrada,false)
}