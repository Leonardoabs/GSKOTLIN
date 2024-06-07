package br.com.example.leonardoalves_rm93868

data class ItemOceano (
    val nomePraia : String,
    val nomeCidade : String,
    val nomeEstado : String,
    val onRemove : (ItemOceano) -> Unit
)