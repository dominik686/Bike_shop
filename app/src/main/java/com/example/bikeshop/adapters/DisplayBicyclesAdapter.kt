package com.example.bikeshop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeshop.R
import com.example.bikeshop.databinding.DisplayBicyclesRecyclerviewItemBinding
import com.example.bikeshop.models.Bicycle
import com.example.bikeshop.singletons.Basket

class DisplayBicyclesAdapter(private val bicycles : List<Bicycle>) : RecyclerView.Adapter<DisplayBicyclesAdapter.BicycleViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicycleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.display_bicycles_recyclerview_item,
            parent,false)
        return BicycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BicycleViewHolder, position: Int) {
        holder.bind(bicycles[position])
    }

    override fun getItemCount(): Int {
        return bicycles.count()
    }

    class BicycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private var _binding = DisplayBicyclesRecyclerviewItemBinding.bind(itemView)
        private lateinit var bicycle : Bicycle
        fun bind(bicycle: Bicycle)
        {
            this.bicycle = bicycle
            setName(bicycle.name)
            setBrand(bicycle.brand)
            setColour(bicycle.colour)
            setPrice(bicycle.price)
            createAddToCartButtonListener()
        }

        private fun setName(name : String)
        {
            _binding.name.text = name
        }
        private fun setBrand(brand : String)
        {
            _binding.brand.text = brand
        }
        private fun setColour(colour : String)
        {
            _binding.colour.text = colour
        }
        private fun setPrice(price : Int)
        {
            _binding.price.text = price.toString() + " zł"
        }

        private fun createAddToCartButtonListener()
        {
            _binding.addToCartButton.setOnClickListener {
                addBicycleToCart()
            }
        }
        private fun addBicycleToCart()
        {
            Basket.addToBasket(bicycle)
        }

    }


}