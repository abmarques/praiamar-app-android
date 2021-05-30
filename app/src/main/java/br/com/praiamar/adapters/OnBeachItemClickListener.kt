package br.com.praiamar.adapters

import br.com.praiamar.models.Beach

interface OnBeachItemClickListener {
    fun  onItemClick(item: Beach, position: Int)
}