package com.thefear.pal.data

import android.os.Handler
import com.thefear.pal.domain.LoginUsecase
import com.thefear.pal.domain.UserRepository

class LoginUsecaseImpl(
    private val repository: UserRepository,
    private val uiHandler: Handler
) : LoginUsecase {


    override fun login(
        login: String,
        password: String,
        callback: (UserDTO) -> Unit
    ) {
        Thread {
            val result = repository.getUser(login, password)
            uiHandler.post {
                callback(result)
            }
        }.start()
    }

}