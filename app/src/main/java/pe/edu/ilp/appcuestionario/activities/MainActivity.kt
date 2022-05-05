package pe.edu.ilp.appcuestionario.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pe.edu.ilp.appcuestionario.R
import pe.edu.ilp.appcuestionario.model.Pregunta

class MainActivity : AppCompatActivity() {
    var preguntas=ArrayList<Pregunta>()
    var posicionActual=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //lista de preguntas
        cargarPreguntas()
        //muestra las preguntas
        mostrarPreguntas()

        val btnVerdadero = findViewById<android.view.View>(R.id.button)
        btnVerdadero.setOnClickListener{
            if(preguntas[posicionActual].respuesta)
            Toast.makeText(this,"La repuesta es correcta", Toast.LENGTH_SHORT).show()
            else
            Toast.makeText(this,"La repuesta es incorrecta", Toast.LENGTH_SHORT).show()
        }
        val btnFalso = findViewById<android.view.View>(R.id.button2)
        btnFalso.setOnClickListener {
            if(!preguntas[posicionActual].respuesta)
                Toast.makeText(this, "La repuesta es correcto", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "La repuesta es incorrecto", Toast.LENGTH_SHORT).show()
        }
        val btnBack = findViewById<Button>(R.id.atras)
        val btnNext = findViewById<Button>(R.id.siguente)
        btnNext.setOnClickListener{
           try{
               btnBack.isEnabled=true
               posicionActual++
               mostrarPreguntas()

           }catch (e:Exception){
               Toast.makeText(this, "NO EXISTE MAS PREGUNTAS", Toast.LENGTH_SHORT).show()
               btnNext.isEnabled=false
           }
        }



        btnBack.setOnClickListener{
            try{
                btnNext.isEnabled=true
                posicionActual--
                mostrarPreguntas()
            }catch (e:Exception){
                Toast.makeText(this, "NO EXISTE MAS PREGUNTAS", Toast.LENGTH_SHORT).show()
                btnBack.isEnabled=false
            }

        }
        des()
        area()
        fac()

    }


    private fun mostrarPreguntas() {
        val textoPregunta = findViewById<TextView>(R.id.text_idPregunta)
        textoPregunta.text = preguntas[posicionActual].enunciando
    }

    private fun cargarPreguntas() {
        preguntas.add(Pregunta("Caracas en la capital de Venezuela",true))
        preguntas.add(Pregunta("Piura es un departamento que pertenece a Ecuador",false))
        preguntas.add(Pregunta("Uruguay es un pais Latinoamericano",true))
        preguntas.add(Pregunta("Lima es la capital de Chile",false))

    }
fun des(){
    for (i in 50 downTo 1 step 2){
        println("inverso : $i")
    }
   }
    fun area(){
        var altura =10
        var base=20
        var rest =0
        rest=(base*altura)/2
        println("la Area es :$rest")
    }
    fun fac(){
        val nume =10
        var facto:Long=1
        for (i in 1..nume){
            facto*=i.toLong()
        }
        println("factorial del numero: $nume es igula a :$facto")
    }
}
