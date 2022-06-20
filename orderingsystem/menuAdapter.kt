package com.example.orderingsystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class menuAdapter (val menuList: List<Menus?>, val clickListener: MenuClickListener): RecyclerView.Adapter<menuAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuAdapter.MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.acitvity_menu_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: menuAdapter.MyViewHolder, position: Int) {
        holder.bind(menuList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if(menuList == null) 0 else menuList.size
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        var thumbImage: ImageView = view.findViewById(R.id.thumbImage)
        val menuName: TextView = view.findViewById(R.id.menuName)
        val menuPrice: TextView = view.findViewById(R.id.menuPrice)
        val addToCartButton: TextView = view.findViewById(R.id.addToCartButton)
        val addMoreLayout: LinearLayout = view.findViewById(R.id.addMoreLayout)
        val imageMinus: ImageView = view.findViewById(R.id.imageMinus)
        val imageAddOne: ImageView = view.findViewById(R.id.imageAddOne)
        val tvCount: TextView = view.findViewById(R.id.tvCount)

        fun bind(menus: Menus){
            menuName.text = menus?.name
            menuPrice.text = "价格：${menus?.price} 元"
            addToCartButton.setOnClickListener {
                menus?.totalInCart = 1
                clickListener.addToCartClickListener(menus)
                addMoreLayout?.visibility = View.VISIBLE
                addToCartButton.visibility = View.GONE
                tvCount.text = menus?.totalInCart.toString()
            }
            imageMinus.setOnClickListener{
                var total: Int = menus?.totalInCart
                total--
                if(total > 0){
                    menus?.totalInCart = total
                    clickListener.updateCartClickLitener(menus)
                    tvCount.text = menus?.totalInCart.toString()
                } else{
                    menus.totalInCart = total
                    clickListener.removeFromCartClickListener(menus)
                    addMoreLayout.visibility = View.GONE
                    addToCartButton.visibility = View.VISIBLE
                }
            }
            imageAddOne.setOnClickListener{
                var total: Int = menus?.totalInCart
                total++
                if(total <= 10){
                    menus.totalInCart = total
                    clickListener.updateCartClickLitener(menus)
                    tvCount.text = total.toString()
                }
            }

            Glide.with(thumbImage)
                .load(menus?.url)
                .into(thumbImage)
        }
    }

    interface MenuClickListener {
        fun addToCartClickListener(menu: Menus)
        fun updateCartClickLitener(menu: Menus)
        fun removeFromCartClickListener(menu: Menus)
    }
}