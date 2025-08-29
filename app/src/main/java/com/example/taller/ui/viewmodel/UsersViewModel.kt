package com.example.taller.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taller.data.model.UsersRepository
import com.example.taller.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class UsersUiState(
    val loading: Boolean = true,
    val users: List<User> = emptyList(),
    val error: String? = null
)

class UsersViewModel(
    private val repository: UsersRepository = UsersRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(UsersUiState())
    val state: StateFlow<UsersUiState> = _state

    init {
        viewModelScope.launch {
            try {
                val data = repository.getUsers()
                _state.value = UsersUiState(loading = false, users = data)
            } catch (e: Exception) {
                _state.value = UsersUiState(loading = false, error = e.message)
            }
        }
    }

    fun userById(id: Int): User? = repository.getUserById(id)
}
