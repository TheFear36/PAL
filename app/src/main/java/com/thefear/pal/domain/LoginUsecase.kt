package com.thefear.pal.domain

import com.thefear.pal.data.UserDTO

interface LoginUsecase {
    fun login(
        login: String,
        password: String,
        callback: (UserDTO) -> Unit
    )
}