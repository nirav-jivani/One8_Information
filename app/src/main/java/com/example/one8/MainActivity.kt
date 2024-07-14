package com.example.one8

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.one8.R.id

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(id.buttonV)
        val textView1 : TextView = findViewById(id.textView)
        var flag : String = ""
        val textView2 : TextView = findViewById(id.textView2)

        val spinnerval : Spinner = findViewById(id.spinnerV)
        val options = arrayOf("Athleisure","FootWear", "StreetWear","CasualWear")
        spinnerval.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        button.setOnClickListener { view ->
            textView1.text = "Rockstar Brands in $flag Category"
            var brands : List<String> = listOf();
            when (flag) {
                "Athleisure" -> {
                    brands = listOf("Nike", "Adidas", "Lululemon", "Under Armour", "Puma")
                }
                "Footwear" -> {
                    brands = listOf("Nike", "Adidas", "New Balance", "Converse", "Vans")
                }
                "StreetWear" -> {
                    brands = listOf("Supreme", "Off-White", "A Bathing Ape (BAPE)", "Stussy", "Palace")
                }
                else -> {
                    brands = listOf("Uniqlo", "H&M", "Zara", "Gap", "Levi's")
                }
            }
            var i=1;
            var tp: String=""
            for(name in brands)
            {
                tp += ">\t$name";
                if(i == 1)
                    tp+=" (#Bestseller on Amazon)";
                tp+="\n\n"
                i += 1;
            }
            textView2.text=tp;
        }
        spinnerval.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}