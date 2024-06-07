package br.com.example.leonardoalves_rm93868

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import br.com.example.leonardoalves_rm93868.ui.theme.LeonardoAlves_RM93868Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val btnAdd = findViewById<Button>(R.id.btnAdicionar)
        val getPraia = findViewById<EditText>(R.id.textPraia)
        val getCidade = findViewById<EditText>(R.id.textCidade)
        val getEstado = findViewById<EditText>(R.id.textEstado)

        btnAdd.setOnClickListener {
            if (getPraia.text.isEmpty()) {
                getPraia.error = "Escreva a Praia"
                return@setOnClickListener
            }

            if (getCidade.text.isEmpty()) {
                getCidade.error = "Escreva a Cidade"
                return@setOnClickListener
            }

            if (getEstado.text.isEmpty()) {
                getEstado.error = "Escreva o Estado"
                return@setOnClickListener
            }

            val item = ItemOceano(
                nomePraia = getPraia.text.toString(),
                nomeCidade = getCidade.text.toString(),
                nomeEstado = getEstado.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(item)
            getPraia.text.clear()
            getCidade.text.clear()
            getEstado.text.clear()

        }

    }
}

