package com.example.exerciseone

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exerciseone.adapter.DataAdapter
import com.example.exerciseone.model.ModelClass
import com.example.exerciseone.model.Row
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataList: List<Row> = generateDataList()
        recyclerView.adapter = DataAdapter(dataList,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
       // recyclerView.setHasFixedSize(true)



    }
    private fun generateDataList() : List<Row>{
        val listModel = ArrayList<ModelClass>()
        val jsonString: String? = loadJSONFromAsset()
        val gson = Gson()
        val modelClass: ModelClass = gson.fromJson(jsonString, ModelClass::class.java)
        val rows: List<Row> = modelClass.rows
        return rows
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val `is` = assets.open("jsonObject.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
             String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}