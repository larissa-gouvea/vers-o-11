package com.example.clinicaveterinaria.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pet(
    var codigo: Int,
    var nome: String,
    var raca: String,
    var peso: String,
    var dt_nasc: String,
    var cod_resp: Int
) : Parcelable

