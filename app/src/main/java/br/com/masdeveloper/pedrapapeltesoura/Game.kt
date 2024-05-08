package br.com.masdeveloper.pedrapapeltesoura

fun jokenpo(lista: List<String>): String {

    if (lista[0] == lista[1] && lista[1] == lista[2]) {
        return "Empate"  // Empate
    }

    if(lista[0] == "pedra"){
        if(lista.count { it == "pedra" } == 2 && (lista.contains("spock") || lista.contains("papel"))) return "Você perdeu"
        if(lista.count { it == "spock" } == 2 || lista.count { it == "papel" } == 2 || (lista.contains("spock") && lista.contains("papel"))) return "Você perdeu"
        if(lista.count { it == "tesoura" } == 2 || lista.count { it == "lagarto" } == 2 || (lista.contains("tesoura") && lista.contains("lagarto"))) return "Você ganhou"
    }

    if(lista[0] == "papel"){
        if(lista.count { it == "papel" } == 2 && (lista.contains("tesoura") || lista.contains("lagarto"))) return "Você perdeu"
        if(lista.count { it == "tesoura" } == 2 || lista.count { it == "lagarto" } == 2 || (lista.contains("tesoura") && lista.contains("lagarto"))) return "Você perdeu"
        if(lista.count { it == "pedra" } == 2 || lista.count { it == "spock" } == 2 || (lista.contains("pedra") && lista.contains("spock"))) return "Você ganhou"
    }

    if(lista[0] == "tesoura"){
        if(lista.count { it == "tesoura" } == 2 && (lista.contains("pedra") || lista.contains("spock"))) return "Você perdeu"
        if(lista.count { it == "pedra" } == 2 || lista.count { it == "spock" } == 2 || (lista.contains("pedra") && lista.contains("spock"))) return "Você perdeu"
        if(lista.count { it == "papel" } == 2 || lista.count { it == "lagarto" } == 2 || (lista.contains("papel") && lista.contains("lagarto"))) return "Você ganhou"
    }

    if(lista[0] == "lagarto"){
        if(lista.count { it == "lagarto" } == 2 && (lista.contains("tesoura") || lista.contains("pedra"))) return "Você perdeu"
        if(lista.count { it == "tesoura" } == 2 || lista.count { it == "pedra" } == 2 || (lista.contains("tesoura") && lista.contains("pedra"))) return "Você perdeu"
        if(lista.count { it == "papel" } == 2 || lista.count { it == "spock" } == 2 || (lista.contains("papel") && lista.contains("spock"))) return "Você ganhou"
    }

    if(lista[0] == "spock"){
        if(lista.count { it == "spock" } == 2 && (lista.contains("papel") || lista.contains("lagarto"))) return "Você perdeu"
        if(lista.count { it == "papel" } == 2 || lista.count { it == "lagarto" } == 2 || (lista.contains("papel") && lista.contains("lagarto"))) return "Você perdeu"
        if(lista.count { it == "pedra" } == 2 || lista.count { it == "tesoura" } == 2 || (lista.contains("pedra") && lista.contains("tesoura"))) return "Você ganhou"
    }
    return "Empate"
}

