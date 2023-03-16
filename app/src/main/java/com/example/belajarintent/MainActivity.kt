package com.example.belajarintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnintent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnintent = findViewById(R.id.btn_intent)
        val btnIntentData = findViewById<Button>(R.id.btn_pindah_data)
        val btnIntenObjek = findViewById<Button>(R.id.btn_pindah_objek)

        btnintent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnIntenObjek.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_intent -> run {
                val pindaintent = Intent ( this@MainActivity, PindahActivity::class.java)
                startActivity(pindaintent)
            }
            R.id.btn_pindah_data -> run {
               val intentData = Intent(this@MainActivity,PindahDataActivity::class.java)
               intentData.putExtra(PindahDataActivity.EXTRA_TEXT,"Halo, ayo belajar kotlin")
               startActivity(intentData)
            }
            R.id.btn_pindah_objek -> run {
                val cars = Cars(
                    "Toyota Yaris",
                    2020,
                    "Bm 2020 SAR"
                )

                val intentObjek = Intent(this@MainActivity, PindahObjekActivity::class.java)
                intentObjek.putExtra(PindahObjekActivity.EXTRA_CARS, cars)
                startActivity(intentObjek)

            }
        }
    }
}