package br.com.masdeveloper.pedrapapeltesoura

fun jokenpo(lista: List<String>): String {

    if (lista[0] == lista[1] && lista[1] == lista[2]) {
        return "Empate"  // Empate
    }
    else if (lista[0] != lista[1] && lista[1] != lista[2] && lista[2] != lista[0]){
        return "Empate"
    }
    if(lista.contains("papel") && lista.contains("tesoura")){
        if(lista.count { it == "tesoura" } == 2 && lista.indexOf("tesoura") == 0) return "Empate"
        if (lista.indexOf("tesoura") == 0) return "Você ganhou" else return "Você perdeu"
    }else{

    }
    if(lista.contains("pedra") && lista.contains("papel")){
        if(lista.count { it == "papel" } == 2 && lista.indexOf("papel") == 0) return "Empate"
        if (lista.indexOf("papel") == 0) return "Você ganhou" else return "Você perdeu"
    }
    if(lista.contains("tesoura") && lista.contains("pedra")){
        if(lista.count { it == "pedra" } == 2 && lista.indexOf("pedra") == 0) return "Empate"
        if (lista.indexOf("pedra") == 0) return "Você ganhou" else return "Você perdeu"
    }
    return "Não foi possível definir um vencedor"

}