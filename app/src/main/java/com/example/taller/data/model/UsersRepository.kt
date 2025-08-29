package com.example.taller.data.model

import com.example.taller.data.api.UsersApi

class UsersRepository(
    private val api: UsersApi = UsersApi()
) {
    private var cache: List<User>? = null

    suspend fun getUsers(): List<User> {
        if (cache == null) cache = api.fetchUsers().users
        return cache!!
    }

    fun getUserById(id: Int): User? = cache?.firstOrNull { it.id == id }
}

