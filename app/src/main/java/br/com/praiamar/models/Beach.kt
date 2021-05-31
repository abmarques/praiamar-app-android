package br.com.praiamar.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Beach(var Nome: String, var Preview: String,
    var Descricao: String, var SmallImagem: Int, var LargeImagem: Int) : Parcelable {
}