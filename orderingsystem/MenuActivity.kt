package com.example.orderingsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_menu.*
import java.io.*

class MenuActivity : AppCompatActivity(), menuAdapter.MenuClickListener {
//    data class Menus(val name: String?, val price: Float, val url: String?, var totalInCart: Int)
//    class MenusList(var checkList: List<Menus>)
    private var arraylist:ArrayList<Menus>? = null
    private var MenuData: List<Menus?>? = null
    private var MenuCheck: List<Menus?>? = null
    private  var menuAdapter: menuAdapter? = null
    private  var itemsInTheCartList: MutableList<Menus?>? = null
    private  var totalItemInCartCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //获取菜单数据
        MenuData = getMenuData()
        initRecyclerView(MenuData)

        //购物车监听器
        checkoutButton.setOnClickListener {
            if(itemsInTheCartList != null && itemsInTheCartList!!.size <= 0){
                Toast.makeText(this@MenuActivity, "请先添加商品到购物车", Toast.LENGTH_LONG).show()
            }else{
                MenuCheck = itemsInTheCartList
                val intent = Intent(this@MenuActivity, OrderActivity::class.java)
                var count = 0
                for ( m in MenuCheck!!){
                    count++
                    val s = "MenuCheck"+count
                    intent.putExtra("${s}",m)
                }
                intent.putExtra("number",count)
                startActivityForResult(intent, 1000)
            }
        }
    }

    private fun initRecyclerView(menuList: List<Menus?>?) {
        menuRecyclerView.layoutManager = GridLayoutManager(this, 2)
        menuAdapter = menuAdapter(menuList!!,this)
        menuRecyclerView.adapter = menuAdapter
    }

    private fun getMenuData(): List<Menus?>? {
        val inputStream: InputStream = resources.openRawResource(R.raw.menu)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStream,"UTF-8"))
            var n: Int
            while(reader.read(buffer).also{ n = it } != -1){
                writer.write(buffer,0,n)

            }
        }catch (e:Exception){}
        val jsonStr: String = writer.toString()
        val gson = Gson()
        val MenusData = gson.fromJson(jsonStr,Array<Menus>::class.java).toList()
//        Log.d("I/O:MenusData: ", "$MenusData")
        return MenusData
    }

    override fun addToCartClickListener(menu: Menus) {
        if(itemsInTheCartList == null){
            itemsInTheCartList = ArrayList()
        }
        itemsInTheCartList?.add(menu)
        totalItemInCartCount = 0
        for(menu in itemsInTheCartList!!){
            totalItemInCartCount = totalItemInCartCount + menu?.totalInCart!!
        }
        checkoutButton.text = "Checkout (" + totalItemInCartCount +") Items"
    }

    override fun updateCartClickLitener(menu: Menus) {
        val index = itemsInTheCartList!!.indexOf(menu)
        itemsInTheCartList?.removeAt(index)
        itemsInTheCartList?.add(menu)
        totalItemInCartCount = 0
        for (menu in itemsInTheCartList!!){
            totalItemInCartCount = totalItemInCartCount + menu?.totalInCart!!
        }
        checkoutButton.text = "Checkout (" + totalItemInCartCount + ") Items"
    }

    override fun removeFromCartClickListener(menu: Menus) {
        if(itemsInTheCartList!!.contains(menu)){
            itemsInTheCartList?.remove(menu)
            totalItemInCartCount = 0
            for (menu in itemsInTheCartList!!){
                totalItemInCartCount = totalItemInCartCount + menu?.totalInCart!!
            }
            checkoutButton.text = "Checkout (" + totalItemInCartCount + ") Items"
        }
    }

}