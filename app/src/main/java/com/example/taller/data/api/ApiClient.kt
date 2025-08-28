package com.example.taller.data.remote

import com.example.taller.data.model.UsersList
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

object ApiClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getUsers(): UsersList {
        return client.get("https://dummyjson.com/users").body()
    }
}
