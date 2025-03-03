package com.example.ejemplosupabase.model

import kotlinx.serialization.Serializable

@Serializable
data class Instrument (
    val id: Int = 0,
    val name: String,
)

