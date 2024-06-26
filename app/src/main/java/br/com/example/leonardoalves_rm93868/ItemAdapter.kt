package br.com.example.leonardoalves_rm93868

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemOceano>()

    fun addItem(novoItem: ItemOceano) {
        items.add(novoItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemOceano) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textNew = view.findViewById<TextView>(R.id.textNew)
        val btnExcluir = view.findViewById<ImageButton>(R.id.btnExcluir)

        fun bind(item: ItemOceano) {
            textNew.text = "${item.nomePraia}, ${item.nomeCidade}, ${item.nomeEstado}"

            btnExcluir.setOnClickListener {
                item.onRemove(item)
            }
        }
    }

}