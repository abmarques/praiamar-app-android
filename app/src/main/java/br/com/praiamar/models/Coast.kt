package br.com.praiamar.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coast(var Nome: String, var Descricao: String, var Imagem: Int, var beaches: ArrayList<Beach>) : Parcelable
