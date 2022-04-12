package com.thefear.pal.ui.login

import com.thefear.pal.domain.UserRepository
import com.thefear.pal.ui.user.UserFragment
import java.lang.Thread.sleep

class LoginPresenter(private val repository: UserRepository) : LoginContract.Presenter {

    private var view: LoginContract.View? = null
    private var isSuccess: Boolean = false
    private var errorText: String = ""
    private val errorCredentialsText = "Не верный логин или пароль"

    override fun onAttach(view: LoginContract.View) {
        this.view = view
        if (isSuccess) {
            view.setSuccess()
        } else {
            view.setError(errorText)
        }
    }

    override fun onLogin(login: String, password: String) {
        view?.showProgress()
        view?.getHandler()?.post {
            sleep(3_000L)
            repository.getUser(login, password)
            view?.hideProgress()
            if (checkCredentials(login, password)) {
                view?.setSuccess()
                isSuccess = true
                errorText = ""
            } else {
                view?.setError(errorCredentialsText)
                isSuccess = false
                errorText = errorCredentialsText
            }
        }
    }

    private fun checkCredentials(login: String, password: String): Boolean {
        return login == "qwer" || password == "123"
    }
}