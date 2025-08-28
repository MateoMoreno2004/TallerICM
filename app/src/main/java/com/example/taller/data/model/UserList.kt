package com.example.taller.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UsersList(
    val users: List<User>,
    val total: Int
)
