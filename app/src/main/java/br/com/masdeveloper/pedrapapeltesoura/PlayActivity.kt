package br.com.masdeveloper.pedrapapeltesoura

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View.INVISIBLE
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import br.com.masdeveloper.pedrapapeltesoura.Constantes.PARAMETRO_EXTRA
import br.com.masdeveloper.pedrapapeltesoura.Constantes.TWO_PLAYERS
import br.com.masdeveloper.pedrapapeltesoura.databinding.ActivityPlayBinding
import kotlinx.coroutines.delay
import java.lang.reflect.Field

class PlayActivity : AppCompatActivity() {

    private val apb: ActivityPlayBinding by lazy {
        ActivityPlayBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        var mode = TWO_PLAYERS
        intent.getStringExtra(PARAMETRO_EXTRA)?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            mode = it
        }

        if(mode == TWO_PLAYERS){
            apb.layoutPlayer3.visibility = INVISIBLE
        }

        apb.imbPedra.setOnClickListener{
            game("imgPedra", mode)
        }

        apb.imbPapel.setOnClickListener{
            game("imgPapel", mode)
        }

        apb.imbTesoura.setOnClickListener{
            game("imgTesoura", mode)
        }

    }

    // Layout Function to mark some choice
    fun setMarkChoiceRobot(path: String){
        val field: Field = apb::class.java.getDeclaredField(path)
        val imageButton = field.get(apb) as ImageButton
        // Defina o padding com a cor de fundo
        imageButton.setBackgroundColor(Color.RED)
    }

    fun unMarkChoiceRobot(path: String){
        val field: Field = apb::class.java.getDeclaredField(path)
        val imageButton = field.get(apb) as ImageButton
        // Defina o padding com a cor de fundo
        imageButton.setBackgroundColor(Color.TRANSPARENT)
    }

    // Function to get the Result
    fun decideGameEndStatus(humanChoice: String, robot1Choice: String, robot2Choice: String): String{
        var result = "";
        if (robot2Choice.isEmpty()){
            // Two Players
            if(humanChoice == robot1Choice){
                result = "Empate"
            }else if((humanChoice == "Pedra" && robot1Choice == "Tesoura") || (humanChoice == "Papel" && robot1Choice == "Pedra")) {

                result = "Você ganhou"

            }else if((robot1Choice == "Pedra" && humanChoice == "Tesoura") || (robot1Choice == "Papel" && humanChoice == "Pedra")){
                result = "Você ganhou"
            }else{
                result = "Você perdeu"
            }
        }else{
            // Theree Players
            result = "Not Implemented yet"
        }
        return result

    }


    // Main Function to control de game
    fun game(choiceUser: String, mode: String){

        var _choiceUser = choiceUser
        var originalPath2 = generateChoiceofPlayerRobot("2")
        var originalPath3 = generateChoiceofPlayerRobot("3")

        // Change String of Center to loading
        apb.txtCenter.text = "Robô pensando..."

        // Cria um Handler associado ao Looper principal
        val handler = Handler(Looper.getMainLooper())

        // Adiciona um atraso de 2 segundos
        handler.postDelayed({
            setMarkChoiceRobot(originalPath2)
            setMarkChoiceRobot(originalPath3)
            // Tratando os Valores
            _choiceUser = _choiceUser.replace("img", "")
            var imgPlayer2 = originalPath2.replace("img", "").replace("Player", "").replace("2", "")
            var imgPlayer3 = originalPath3.replace("img", "").replace("Player", "").replace("3", "")

            // 2 Players
            if(mode == TWO_PLAYERS){
                imgPlayer3 = ""
            }

            apb.txtCenter.text = decideGameEndStatus(_choiceUser, imgPlayer2, imgPlayer3)

            handler.postDelayed({
                // Remove a marcação
                unMarkChoiceRobot(originalPath2)
                unMarkChoiceRobot(originalPath3)
            }, 2000)
        }, 2000)



    }

    fun generateChoiceofPlayerRobot(player: String): String {
        val lista = listOf("imgPedraPlayer", "imgPapelPlayer", "imgTesouraPlayer")
        val elementoAleatorio = lista.random()
        println("O elemento escolhido aleatoriamente é: $elementoAleatorio")
        return elementoAleatorio + player
    }

}