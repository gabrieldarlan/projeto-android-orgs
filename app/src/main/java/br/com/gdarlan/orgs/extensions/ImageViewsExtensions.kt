package br.com.gdarlan.orgs.extensions

import android.widget.ImageView

import coil.load

fun ImageView.tentaCarregarImagem(url: String? = null) {
    load(url) {
        fallback(br.com.gdarlan.orgs.R.drawable.erro) //! mostra um conteudo alternativo caso a imagem seja null
        error(br.com.gdarlan.orgs.R.drawable.erro) //! mostra um conteudo alternativo caso ocorra um erro
        placeholder(br.com.gdarlan.orgs.R.drawable.placeholder) //! mostra um conteudo alternativo enquanto carrega a image
    }
}