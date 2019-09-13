package com.example.prueba3lab4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_inventory.view.*


class InventoryFragment : Fragment() {

    private lateinit var peluchitos: Peluchitos

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inventory,container,false)
        if(arguments!=null){
            var peluchitos: Peluchitos? = arguments!!.getParcelable(ARG_PARAM)
            var nombre = peluchitos!!.nombre
            var id = peluchitos!!.id
            var cantidad = peluchitos.cantidad
            var precio = peluchitos.precio
            view.tNombre.text= nombre
            view.tId.text= id
            view.tCantidad.text=cantidad
            view.tPrecio.text=precio
        }
        return view
       // return inflater.inflate(R.layout.fragment_inventory, container, false)
    }

    companion object{
        private  val ARG_PARAM = "MyObject"

        fun newInstance(peluchitos: Peluchitos): InventoryFragment{
            val inventoryFragment = InventoryFragment()
            val args = Bundle()
            args.putParcelable(ARG_PARAM,peluchitos)
            inventoryFragment.arguments = args
            return inventoryFragment
        }
    }

}
