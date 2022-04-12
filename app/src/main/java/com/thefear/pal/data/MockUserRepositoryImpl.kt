package com.thefear.pal.data

import com.thefear.pal.domain.UserRepository

class MockUserRepositoryImpl : UserRepository {
    override fun addUser(login: String, password: String, email: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteUser(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUser(login: String, password: String): UserDTO {
        TODO("Not yet implemented")
    }

    override fun forgotUserPassword(email: String): Boolean {
        TODO("Not yet implemented")
    }
}