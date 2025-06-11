package com.example.quiz1.activity.cursoActivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz1.R
import androidx.lifecycle.lifecycleScope
import com.example.quiz1.data.local.db.AppDatabase
import com.example.quiz1.data.local.entity.CursoEntity
import com.example.quiz1.data.repository.CursoRepository
import kotlinx.coroutines.launch

class InsertarCursoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_curso)

        val edtCodigo = findViewById<EditText>(R.id.edtCodigoCurso)
        val edtNombre = findViewById<EditText>(R.id.edtNombreCurso)
        val edtCreditos = findViewById<EditText>(R.id.edtCreditosCurso)
        val edtHoras = findViewById<EditText>(R.id.edtHorasCurso)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarCurso)

        val db = AppDatabase.getDatabase(this)
        val repository = CursoRepository(db.cursoDao())

        btnGuardar.setOnClickListener {
            val nuevoCurso = CursoEntity(
                idCurso = 0,
                codigo = edtCodigo.text.toString(),
                nombre = edtNombre.text.toString(),
                creditos = edtCreditos.text.toString().toIntOrNull() ?: 0,
                horasSemanales = edtHoras.text.toString().toIntOrNull() ?: 0
            )

            lifecycleScope.launch {
                repository.insertar(nuevoCurso)
                Toast.makeText(
                    this@InsertarCursoActivity,
                    "Curso insertado",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
}
