package com.example.prueba3lab4


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    var interfaz: comunicador?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
       view.bEnviar.setOnClickListener{
           var nombre = view.eNombre.text.toString()
           var id = view.eId.text.toString()
           var cantidad = view.eCantidad.text.toString()
           var precio = view.ePrecio.text.toString()
           interfaz?.enviarDatos(nombre, id, cantidad, precio)
       }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            interfaz = context!! as comunicador
        }   catch (e: ClassCastException){
            Log.d("exception", e.toString())
        }
    }


}
