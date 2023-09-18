package com.example.ramdomdock

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
lateinit var datas:ArrayList<model_class>
lateinit var myrec:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datas= arrayListOf()
        myrec=findViewById(R.id.myrecyc)
        GlobalScope.launch {
            for (i in 1..10) {
                apiCall(this@MainActivity)
                Log.d("safihai", datas.toString())
            }
        }
        Log.d("safihai",datas.toString())









    }

    private fun apiCall( context:Context) {
        val apiR=Retrofit.Builder()
            .baseUrl("https://random-d.uk/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitIn::class.java)

        apiR.getImages().enqueue(object : Callback<model_class?> {
            override fun onResponse(call: Call<model_class?>, response: Response<model_class?>) {
                Log.d("karna",response.toString())
                datas.add(response.body()!!)
                val adaptor=myAdaptor(this@MainActivity,datas)
                myrec.adapter=adaptor
                adaptor.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<model_class?>, t: Throwable) {
                Log.d("karna","sorry faild ${t.message.toString()}")
            }
        })
    }

    fun getmore(view: View) {
        datas.clear()
        for (i in 1..10){
            apiCall(this@MainActivity)
        }
    }

}