package com.thefear.pal

import android.app.Application
import android.content.Context
import com.thefear.pal.data.MockUserRepositoryImpl
import com.thefear.pal.domain.UserRepository

class App : Application() {
    val repository: UserRepository by lazy { MockUserRepositoryImpl() }
}

val Context.app: App
    get() {
        return applicationContext as App
    }