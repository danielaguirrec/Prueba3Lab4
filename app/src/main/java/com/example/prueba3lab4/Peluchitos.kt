package com.example.prueba3lab4


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Peluchitos (var nombre: String, var id: String, var cantidad: String, var precio: String) : Parcelable

