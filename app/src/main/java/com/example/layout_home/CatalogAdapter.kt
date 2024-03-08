package com.example.layout_home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layout_home.databinding.ItemCatalogBinding
import com.example.layout_home.model.Catalog

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    private var data = mutableListOf<Catalog>()

    fun submitData(items: List<Catalog>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val binding = ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class CatalogViewHolder(private val binding: ItemCatalogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(catalog: Catalog) {
            binding.ivCatalogImage.setImageResource(catalog.image)
            binding.tvCatalogName.text = catalog.name
            binding.tvCatalogPrice.text = String.format("Rp%.2f", catalog.price)
        }
    }
}
