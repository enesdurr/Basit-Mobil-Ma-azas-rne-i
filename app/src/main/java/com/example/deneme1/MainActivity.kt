package com.example.deneme1

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.deneme1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myButton: Button = findViewById(R.id.myButton)
        val editText:EditText=findViewById((R.id.editTextCity))
        val arr=arrayOf("Chester: 100 $","Oslo: 200 $","Modern Zen Chair 150 $")

        myButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
               // val arr2: Array<String?> = arrayOfNulls(15)
                val concstr=" "
                val text=editText.text
                Toast.makeText(applicationContext, "Arama Yapılıyor", Toast.LENGTH_SHORT).show()
                arr.forEach {item ->
                    if(item.contains(text.toString())){
                        Toast.makeText(applicationContext, item.toString(), Toast.LENGTH_SHORT).show()
                            //concstr+" "+item.toString()


                    }

                }

            }




        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}