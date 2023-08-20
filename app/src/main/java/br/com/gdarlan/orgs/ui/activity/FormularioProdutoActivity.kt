package br.com.gdarlan.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.gdarlan.orgs.R
import br.com.gdarlan.orgs.dao.ProdutosDao
import br.com.gdarlan.orgs.model.Produto
import com.blackcat.currencyedittext.CurrencyEditText
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    private val dao = ProdutosDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_botao_salvar)
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produto = produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_produto_nome)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_descricao)
        val descricao = campoDescricao.text.toString()
//        val campoValor = findViewById<EditText>(R.id.activity_formulario_valor)
//        val valorEmTexto = campoValor.text.toString()

        val campoValor =
            findViewById<CurrencyEditText>(R.id.activity_formulario_valor_currency_edit_text)
        //! pegar o valor da tela e deixar sem os pontos e virgula
        val valorRecebido = campoValor.rawValue
        Log.i("VALOR", "FormularioProduto: $valorRecebido")

        val valor = if (valorRecebido <= 0) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorRecebido)
        }
//        val valorEmTexto = campoValor.text.toString()

//        val valor = if (valorEmTexto.isBlank()) {
//            BigDecimal.ZERO
//        } else {
//            BigDecimal(valorEmTexto)
//        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }

}