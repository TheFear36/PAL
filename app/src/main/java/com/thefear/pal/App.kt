package com.thefear.pal

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.thefear.pal.data.LoginUsecaseImpl
import com.thefear.pal.data.MockUserRepositoryImpl
import com.thefear.pal.domain.LoginUsecase
import com.thefear.pal.domain.UserRepository

class App : Application() {
    private val repository: UserRepository by lazy { MockUserRepositoryImpl() }
    val loginUsecase: LoginUsecase by lazy { LoginUsecaseImpl(app.repository, Handler(Looper.getMainLooper())) }
}

val Context.app: App
    get() {
        return applicationContext as App
    }