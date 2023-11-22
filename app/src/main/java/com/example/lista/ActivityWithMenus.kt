package com.example.lista

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Filterable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenus: AppCompatActivity() {
    companion object{
        var actividadActual = 0;
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Relacionamos la clase con el layout del menu que hemos creado:
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)

        // Desactivar la opcion de la actividad en la que ya estamos:
        for (i in 0 until  menu.size()) {
            if(i== actividadActual) menu.getItem(i).isEnabled = false
            else menu.getItem(i)?.isEnabled = true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.Peliculas -> {
                actividadActual = 0
                // Hacemos que se abra la pantalla del listado de peliculas:
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            R.id.search -> {
                val buscarEditText = findViewById<EditText>(R.id.buscar)

                // Verificar si el EditText está visible
                if (buscarEditText.visibility == View.VISIBLE) {
                    // Si está visible, ocultarlo
                    buscarEditText.visibility = View.INVISIBLE
                } else {
                    // Si está oculto, mostrarlo
                    buscarEditText.visibility = View.VISIBLE
                }

                true

            }


            R.id.exit -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmación")
                    .setMessage("¿Desea salir de la aplicación?")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, { dialog, which ->
                        Toast.makeText(applicationContext, "OK", Toast.LENGTH_SHORT).show()
                    })
                    .setNegativeButton(android.R.string.cancel,  { dialog, which ->
                        Toast.makeText(applicationContext, "CANCEL", Toast.LENGTH_SHORT).show()
                    })
                    .show()

                return true // Indica que el evento ha sido manejado
            }

            R.id.EditarPelicula -> {
                actividadActual = 2
                // Hacemos que se abra la pantalla de Añadir Peliculas:
                val intent = Intent(this, EditarPeliculasActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            R.id.App -> {
                actividadActual = 3
                // Hacemos que se abra la pantalla de Añadir Peliculas:
                val intent = Intent(this, InfoActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)


        }


    }


}