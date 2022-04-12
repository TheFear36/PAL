package com.thefear.pal.domain

import com.thefear.pal.data.UserDTO

interface UserRepository {
    fun addUser(login: String, password: String, email: String): Boolean
    fun deleteUser(): Boolean
    fun getUser(login: String, password: String): UserDTO
    fun forgotUserPassword(email: String): Boolean
}