package com.example.quiz1.activity.alumnoActivity

import android.app.Activity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz1.R
import androidx.lifecycle.lifecycleScope
import com.example.quiz1.data.local.db.AppDatabase
import com.example.quiz1.data.local.entity.AlumnoEntity
import com.example.quiz1.data.repository.AlumnoRepository
import kotlinx.coroutines.launch

class InsertarAlumnoActivity : AppCompatActivity() {

    private lateinit var edtCedula: EditText
    private lateinit var edtNombre: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtFechaNacimiento: EditText
    private lateinit var edtIdCarrera: EditText
    private lateinit var btnGuardar: Button

    private lateinit var repository: AlumnoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_alumno)

        edtCedula = findViewById(R.id.edtCedula)
        edtNombre = findViewById(R.id.edtNombre)
        edtTelefono = findViewById(R.id.edtTelefono)
        edtEmail = findViewById(R.id.edtEmail)
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento)
        edtIdCarrera = findViewById(R.id.edtIdCarrera)
        btnGuardar = findViewById(R.id.btnGuardar)

        val db = AppDatabase.getDatabase(this)
        repository = AlumnoRepository(db.alumnoDao())

        btnGuardar.setOnClickListener { insertarAlumno() }
    }

    private fun insertarAlumno() {
        val alumno = AlumnoEntity(
            idAlumno = 0,
            cedula = edtCedula.text.toString(),
            nombre = edtNombre.text.toString(),
            telefono = edtTelefono.text.toString(),
            email = edtEmail.text.toString(),
            fechaNacimiento = edtFechaNacimiento.text.toString(),
            idCarrera = edtIdCarrera.text.toString().toIntOrNull() ?: 0
        )
        lifecycleScope.launch {
            repository.insertar(alumno)
            Toast.makeText(
                this@InsertarAlumnoActivity,
                "Alumno insertado correctamente",
                Toast.LENGTH_SHORT
            ).show()
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}
