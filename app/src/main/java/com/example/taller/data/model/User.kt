package com.example.taller.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val age: Int,
    val gender: String,
    val birthDate: String,
    val height: Double,
    val weight: Double,
    val image: String,
    val company: Company
)

@Serializable
data class Company(
    val name: String
)
