package br.com.masdeveloper.pedrapapeltesoura

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class PlayActivityTest {

    @Test
    @DisplayName("Empates")
    fun jokenpoEmpate() {

        var result = jokenpo(listOf("pedra", "papel", "tesoura")) // -> Empate
        assertEquals("Empate", result)

        var result2 = jokenpo(listOf("papel", "pedra", "tesoura")) // -> Empate
        assertEquals("Empate", result2)

        var result3 = jokenpo(listOf("pedra", "tesoura", "pedra")) // -> Empate
        assertEquals("Empate", result3)

        var result5 = jokenpo(listOf("papel", "papel", "pedra")) // -> Empate
        assertEquals("Empate", result5)

        var result4 = jokenpo(listOf("pedra", "pedra", "pedra")) // -> Empate
        assertEquals("Empate", result4)

        assertEquals("Empate", jokenpo(listOf("spock", "spock", "spock")))// -> Empate
        assertEquals("Empate", jokenpo(listOf("spock", "pedra", "papel")))// -> Empate
        assertEquals("Empate", jokenpo(listOf("spock", "tesoura", "lagarto")))// -> Empate

        assertEquals("Empate", jokenpo(listOf("lagarto", "lagarto", "lagarto")))// -> Empate
        assertEquals("Empate", jokenpo(listOf("lagarto", "spock", "tesoura")))// -> Empate
        assertEquals("Empate", jokenpo(listOf("lagarto", "papel", "pedra")))// -> Empate
    }

    @Test
    @DisplayName("Vitoria")
    fun jokenpoVitoria() {

        var result = jokenpo(listOf("pedra", "tesoura", "tesoura")) // -> Empate
        assertEquals("Você ganhou", result)

        var result2 = jokenpo(listOf("papel", "pedra", "pedra")) // -> Você ganhou
        assertEquals("Você ganhou", result2)

        var result3 = jokenpo(listOf("tesoura", "papel", "papel")) // -> Você ganhou
        assertEquals("Você ganhou", result3)

        assertEquals("Você ganhou", jokenpo(listOf("spock", "pedra", "tesoura")))// -> Você ganhou
        assertEquals("Você ganhou", jokenpo(listOf("spock", "pedra", "pedra")))// -> Você ganhou
        assertEquals("Você ganhou", jokenpo(listOf("spock", "tesoura", "tesoura")))// -> Você ganhou

        assertEquals("Você ganhou", jokenpo(listOf("lagarto", "papel", "spock")))// -> Você ganhou
        assertEquals("Você ganhou", jokenpo(listOf("lagarto", "papel", "papel")))// -> Você ganhou
        assertEquals("Você ganhou", jokenpo(listOf("lagarto", "spock", "spock")))// -> Você ganhou
    }

    @Test
    @DisplayName("Derrota")
    fun jokenpoDerrota() {

        var result = jokenpo(listOf("pedra", "papel", "papel")) // -> Empate
        assertEquals("Você perdeu", result)

        var result2 = jokenpo(listOf("papel", "papel", "tesoura")) // -> Você perdeu
        assertEquals("Você perdeu", result2)

        var result3 = jokenpo(listOf("tesoura", "pedra", "pedra")) // -> Você perdeu
        assertEquals("Você perdeu", result3)

        var resutl4 = jokenpo(listOf("papel", "tesoura", "tesoura")) // -> Você perdeu
        assertEquals("Você perdeu", resutl4)


        assertEquals("Você perdeu", jokenpo(listOf("spock", "papel", "lagarto")))// -> Você perdeu
        assertEquals("Você perdeu", jokenpo(listOf("spock", "papel", "papel")))// -> Você perdeu
        assertEquals("Você perdeu", jokenpo(listOf("spock", "lagarto", "lagarto")))// -> Você perdeu

        assertEquals("Você perdeu", jokenpo(listOf("lagarto", "tesoura", "pedra")))// -> Você perdeu
        assertEquals("Você perdeu", jokenpo(listOf("lagarto", "tesoura", "tesoura")))// -> Você perdeu
        assertEquals("Você perdeu", jokenpo(listOf("lagarto", "pedra", "pedra")))// -> Você perdeu
    }
}