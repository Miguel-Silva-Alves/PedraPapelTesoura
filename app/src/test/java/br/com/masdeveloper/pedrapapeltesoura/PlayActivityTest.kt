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
    }
}