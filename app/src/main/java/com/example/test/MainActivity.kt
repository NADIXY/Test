package com.example.test

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.test.adaptar.ItemAdaptar
import com.example.test.data.Datasource
import com.example.test.data.model.GoShopping
import com.example.test.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var textEingabe: ListView
    private lateinit var floatingAcctonButton2: FloatingActionButton
    private lateinit var platzhalter: ArrayList<String>
    private lateinit var itemAdaptar: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textEingabe = findViewById(R.id.textEingabe)
        floatingAcctonButton2 = findViewById(R.id.floatingActionButton2)
        platzhalter = ArrayList()

        platzhalter.add("Glühwhein")


        itemAdaptar = ArrayAdapter(this, android.R.layout.simple_list_item_1, platzhalter)
        textEingabe.adapter = itemAdaptar

        textEingabe.setOnItemLongClickListener { arg0, arg1, pos, id ->
            platzhalter.removeAt(pos)
            itemAdaptar.notifyDataSetChanged()
            Toast.makeText(applicationContext, "Element gelöscht", Toast.LENGTH_SHORT).show()
            true

        }

        floatingAcctonButton2.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Hinzufügen")

            var input = EditText(this)
            input.hint = "Text eingeben"
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            builder.setPositiveButton("OK") { dialog, which ->
                platzhalter.add(input.text.toString())
                itemAdaptar.notifyDataSetChanged()
            }


            builder.setNegativeButton("Abbrechen") { dialog, which ->
                Toast.makeText(applicationContext, "Abgebrochen", Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }




        //Dataset laden und testweise ausgeben
        val dataset: List<GoShopping> = Datasource().loadGoShopping()
        Log.d("DatasetLog", "$dataset")

        //Adapter erstellen und zuweisen
        val adapter = ItemAdaptar(this, dataset)
        binding.textRV.adapter = adapter





    }

}

