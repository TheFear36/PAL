package com.thefear.pal

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.thefear.pal.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    private var presenter: LoginContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = restorePresenter()
        presenter?.onAttach(this)
        binding.loginButton.setOnClickListener {
            presenter?.onLogin(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }

    private fun restorePresenter(): LoginPresenter {
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        return presenter ?: LoginPresenter()
    }

    @MainThread
    override fun setSuccess() {
        binding.viewContainer.isVisible = false
    }

    @MainThread
    override fun setError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    @MainThread
    override fun showProgress() {
        binding.loginButton.isEnabled = false
        binding.progressBar.visibility = View.VISIBLE
    }

    @MainThread
    override fun hideProgress() {
        binding.loginButton.isEnabled = true
        binding.progressBar.visibility = View.GONE
    }

    override fun getHandler(): Handler {
        return Handler(Looper.getMainLooper())
    }


}