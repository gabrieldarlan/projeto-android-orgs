package br.com.gdarlan.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.gdarlan.orgs.R
import br.com.gdarlan.orgs.model.Produto
import br.com.gdarlan.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "teste 1",
                    descricao = "teste descricao 1",
                    valor = BigDecimal("19.99")
                ),
                Produto(
                    nome = "teste 2",
                    descricao = "teste descricao 2",
                    valor = BigDecimal("29.99")
                ),
                Produto(
                    nome = "teste 3",
                    descricao = "teste descricao 3",
                    valor = BigDecimal("39.99")
                ),
            )
        )
//        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}