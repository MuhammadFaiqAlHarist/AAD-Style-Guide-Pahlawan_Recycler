package com.faiq.pahlawanindonesia

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.faiq.pahlawanindonesia.data.DaftarPahlawanItem
import com.faiq.pahlawanindonesia.data.Response
import com.faiq.pahlawanindonesia.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerview.apply {
            val pahindo = Gson().fromJson(
                getJsonFromAsset(applicationContext, "pahlawan_nasional.json").toString(),
                Response::class.java
            ).daftarPahlawan as List<DaftarPahlawanItem>
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = namaAdapter(pahindo)

        }
    }
}

fun getJsonFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioExpection: IOException) {
        // Memberitahu error
        ioExpection.printStackTrace()
        return null
    }
    return jsonString

}