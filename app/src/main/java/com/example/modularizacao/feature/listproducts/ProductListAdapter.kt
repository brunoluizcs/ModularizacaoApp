package com.example.modularizacao.feature.listproducts

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Product
import com.example.modularizacao.R
import com.example.modularizacao.extension.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_row.view.*

class ProductListAdapter(
    private val picasso: Picasso
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    var products: List<Product> = listOf()

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.product_row)) {

        fun bind(product: Product) = with(itemView) {
            tvTitleProduct.text = product.name
            tvDescriptionProduct.text = product.description
            picasso.load(product.imageURL).into(ivPhotoProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun getItemCount(): Int = products.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(products[position])
}