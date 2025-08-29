package com.example.taller.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    val users: List<User>,
    val total: Int? = null,
    val skip: Int? = null,
    val limit: Int? = null
)

@Serializable
data class User(
    val id: Int,
    @SerialName("firstName") val name: String,
    @SerialName("lastName") val lastName: String,
    val image: String,
    val phone: String,
    val email: String,
    val age: Int,
    val gender: String,
    val height: Double? = null,
    val weight: Double? = null,
    val university: String? = null,
    val company: Company
)

@Serializable
data class Company(
    val name: String,
    val title: String? = null,
    val department: String? = null
)
