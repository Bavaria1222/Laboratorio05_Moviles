package com.example.quiz1.activity

import android.content.Intent
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz1.R
import androidx.lifecycle.lifecycleScope
import com.example.quiz1.data.local.db.AppDatabase
import com.example.quiz1.data.repository.UsuarioRepository

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etCedula = findViewById<EditText>(R.id.etCedula)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegistro = findViewById<TextView>(R.id.tvRegistro)

        val prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE)

        val db = AppDatabase.getDatabase(this)
        val repository = UsuarioRepository(db.usuarioDao())

        btnLogin.setOnClickListener {
            val cedula = etCedula.text.toString()
            val clave = etContrasena.text.toString()
            if (cedula.isBlank() || clave.isBlank()) {
                Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
            } else {
                lifecycleScope.launch {
                    val user = repository.loginLocal(cedula, clave)
                    if (user != null) {
                        prefs.edit()
                            .putString("cedula", user.cedula)
                            .putString("rol", user.rol.uppercase())
                            .apply()
                        startActivity(Intent(this@LoginActivity, MenuActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        tvRegistro.setOnClickListener {
            startActivity(Intent(this, InscriptionActivity::class.java))
        }
    }
}
