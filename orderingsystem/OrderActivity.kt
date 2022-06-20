package com.example.orderingsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    var OrderAdapter: orderAdapter? = null
    var isDeliveryOn: Boolean = false
    var MenuChecking: List<Menus?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val count: Int = intent.getIntExtra("number",1000)
        Log.d("count:", "onCreate: ${count}")
        var s = "MenuCheck"
        val MenuList = mutableListOf<Menus?>(
            intent.getParcelableExtra("MenuCheck1"),
            intent.getParcelableExtra("MenuCheck2"),
            intent.getParcelableExtra("MenuCheck3"),
            intent.getParcelableExtra("MenuCheck4"),
        )
//        for (i in 2..count){
//            s += i
//            MenuList.add(intent.getParcelableExtra("${s}"))
//            Log.d("MenuList", "onCreate: ${MenuList}")
//        }
        MenuChecking = MenuList
        buttonOrder.setOnClickListener {
            onOrderButtonClick(MenuChecking)
        }

        switchDelivery.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked) {
                inputAddress.visibility = View.VISIBLE
                inputNumber.visibility = View.VISIBLE
                tvDeliveryCharge.visibility = View.VISIBLE
                tvDeliveryChargeAmount.visibility = View.VISIBLE
                isDeliveryOn = true
                calculateTotalAmount(MenuChecking)
            }else{
                inputAddress.visibility = View.GONE
                inputNumber.visibility = View.GONE
                tvDeliveryCharge.visibility = View.GONE
                tvDeliveryChargeAmount.visibility = View.GONE
                isDeliveryOn = false
                calculateTotalAmount(MenuChecking)
            }
        }

        initRecyclerView(MenuChecking)
        calculateTotalAmount(MenuChecking)
    }

    private fun initRecyclerView(MenuChecking: List<Menus?>?){
        cartItemsRecyclerView.layoutManager = GridLayoutManager(this,2)
        OrderAdapter = orderAdapter(MenuChecking)
        cartItemsRecyclerView.adapter = OrderAdapter
    }

    private fun calculateTotalAmount(menu: List<Menus?>?) {
        var subTotalAmount = 0f
        for (me in menu!!){
            subTotalAmount += me?.price!! * me?.totalInCart!!
        }
        tvSubtotalAmount.text = "￥" + String.format("%.2f", subTotalAmount)
        if(isDeliveryOn) {
            tvDeliveryChargeAmount.text = "￥5.00"
            subTotalAmount += 5.0F
        }
        tvTotalAmount.text = "￥"+ String.format("%.2f", subTotalAmount)
    }

    private fun onOrderButtonClick(Menu: List<Menus?>?){
        if(TextUtils.isEmpty(inputName.text.toString())){
            inputName.error = "请输入姓名"
            return
        }else if(isDeliveryOn && TextUtils.isEmpty(inputAddress.text.toString())){
            inputAddress.error = "请填写地址"
            return
        }else if(isDeliveryOn && TextUtils.isEmpty(inputNumber.text.toString())){
            inputAddress.error = "请填写手机号码"
            return
        }else if(TextUtils.isEmpty(inputTableNumber.text.toString())){
            inputAddress.error = "请填写要求的餐具份数"
            return
        }else if(TextUtils.isEmpty(inputInvoice.text.toString())){
            inputAddress.error = "请填写是否要求开发票"
            return
        }

        val intent = Intent(this@OrderActivity,SuccessActivity::class.java)
        startActivityForResult(intent, 10)

    }
}