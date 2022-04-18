package com.ajgroup.json

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ajgroup.json.databinding.ActivityMainBinding
import com.ajgroup.json.model.GetMovieDiscovery
import com.ajgroup.json.model.Result
import com.ajgroup.json.service.ApiClient
import com.ajgroup.json.service.ApiClientMovie
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchAllData()
        setupView()
//        val myJSONObject = JSONObject()
//        myJSONObject.put("AppName","Sulka")
//        myJSONObject.put("Date",2022)
//        myJSONObject.put("Sign",true)
//        myJSONObject.put("Default", null)
//        Log.d("Kumra 1",myJSONObject.toString())
//        val jsonSharp = JSONObject()
//            .put("SKU","AH-A5UCY")
//            .put("Type","Standard")
//            .put("Daya",350)
//            .put("Ukuran",0.5)
//            .put("MadeIn","China")
//        val jsonDaikin = JSONObject()
//            .put("SKU","FTKQ25UVM4")
//            .put("Type","Inverter")
//            .put("Daya",920)
//            .put("Ukuran",1)
//            .put("MadeIn","Thailand")
//        val jsonGree = JSONObject()
//            .put("SKU","GWC-12C3E")
//            .put("Type","Low Watt")
//            .put("Daya",1034)
//            .put("Ukuran",1.5)
//            .put("MadeIn","China")
//        val jsonAkira = JSONObject()
//            .put("SKU","A-05D5PLW")
//            .put("Type","Plasma")
//            .put("Daya",360)
//            .put("Ukuran",0.5)
//            .put("MadeIn","Indonesia")
//        val jsonArrayListAc = JSONArray()
//        jsonArrayListAc.put(jsonSharp)
//        jsonArrayListAc.put(jsonGree)
//        jsonArrayListAc.put(jsonDaikin)
//        jsonArrayListAc.put(jsonAkira)
//        val myJSONArray = JSONObject()
//        myJSONArray.put("list_ac",jsonArrayListAc)
//    Log.d("Kumra 2",myJSONArray.toString())
//        Log.d("Kumra 3", myJSONArray.getJSONArray("list_ac").getJSONObject(0).getString("SKU"))
//        Log.d("Kumra 4", myJSONArray.getJSONArray("list_ac").getJSONObject(3).getString("SKU"))
    }

    private fun setupView() {
        binding.fab.setOnClickListener {
            startActivity(Intent(this@MainActivity,RegisterActivity::class.java))
        }
    }

    private fun fetchAllData(){
    ApiClientMovie.instace.gettDiscovery()
        .enqueue(object  : retrofit2.Callback<GetMovieDiscovery>{
            //            override fun onResponse(
//                call: Call<List<GetMovieDiscovery>>,
//                response: Response<List<GetMovieDiscovery>>
//            ) {
//               val body = response.body()
//                val code = response.code()
//                if (code == 200){
//                    showList(body)
//                    binding.pbLoading.visibility = View.GONE
//                    Toast.makeText(this@MainActivity, "Data Berhasil Di Load", Toast.LENGTH_SHORT).show()
//                } else{
//                    binding.pbLoading.visibility = View.GONE
//                }
//            }
//
//            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
//                binding.pbLoading.visibility = View.GONE
//                Toast.makeText(this@MainActivity, "Data Tidak Berhasil Di Load", Toast.LENGTH_SHORT).show()
//            }
            override fun onResponse(
                call: Call<GetMovieDiscovery>,
                response: Response<GetMovieDiscovery>
            ) {
                val body = response.body()
                val code = response.code()
                                if (code == 200){
                                    body?.results?.let { showList(it) }
                    binding.pbLoading.visibility = View.GONE
                    Toast.makeText(this@MainActivity, "Data Berhasil Di Load", Toast.LENGTH_SHORT).show()
                } else{
                    binding.pbLoading.visibility = View.GONE
                }

            }

            override fun onFailure(call: Call<GetMovieDiscovery>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
}
    private fun showList(data: List<Result>){
        val adapter  = MainAdapter(object : MainAdapter.OnClickListener {
            override fun onClickItem(data: Result) {
            }
        })
        adapter.submitData(data)
        binding.rvList.adapter = adapter
    }
}
