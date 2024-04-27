package br.com.masdeveloper.pedrapapeltesoura

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.masdeveloper.pedrapapeltesoura.Constantes.PARAMETRO_EXTRA
import br.com.masdeveloper.pedrapapeltesoura.Constantes.THREE_PLAYERS
import br.com.masdeveloper.pedrapapeltesoura.Constantes.TWO_PLAYERS
import br.com.masdeveloper.pedrapapeltesoura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var parl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.mainTb.apply {
            title = getString(R.string.app_name)
            subtitle = this@MainActivity.javaClass.simpleName
            setSupportActionBar(this)
        }

        amb.doisJogadores.setOnClickListener{
            val viewContactIntent = Intent(this@MainActivity, PlayActivity::class.java)
            viewContactIntent.putExtra(PARAMETRO_EXTRA, TWO_PLAYERS)
            startActivity(viewContactIntent)
        }

        amb.tresJogadores.setOnClickListener{
            val viewContactIntent = Intent(this@MainActivity, PlayActivity::class.java)
            viewContactIntent.putExtra(PARAMETRO_EXTRA, THREE_PLAYERS)
            startActivity(viewContactIntent)
        }
//        parl = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == RESULT_OK) {
//                result.data?.getStringExtra(PARAMETRO_EXTRA)?.let {
//                    amb.parametroTv.text = it
//                }
//            }
//        }
    }
}