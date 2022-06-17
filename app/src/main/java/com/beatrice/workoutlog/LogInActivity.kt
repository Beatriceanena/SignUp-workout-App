package com.beatrice.workoutlog

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.beatrice.workoutlog.databinding.ActivityLoginBinding

class LogInActivity : AppCompatActivity() {
   lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
    }

    fun castViews(){
       binding.tvSignUp.setOnClickListener{
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogIn.setOnClickListener{
            validateLogin()
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }

    fun validateLogin(){

        var email=binding.etEmail.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmail.error="Not a valid address"

        }

        var password=binding.etPassword.text.toString()
        if (password.isBlank()){
            binding.tilPassword.error="Password is required"
        }
}
}