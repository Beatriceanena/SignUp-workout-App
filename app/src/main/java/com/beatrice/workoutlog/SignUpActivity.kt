package com.beatrice.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.beatrice.workoutlog.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogin.setOnClickListener{
            var intent= Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
       validateSignup()
        }

    }
    fun validateSignup(){
        var error=false
        binding.tilEmail1.error=null
        binding.tilPassword.error=null

        var firstname= binding.etFirstname.text.toString()
        var lastname= binding.etLastname.text.toString()
        var email=binding.etEmail.text.toString()
        var password= binding.etPassword.text.toString()
        var confirm= binding.etConfirmPassword.text.toString()

        if (firstname.isBlank()){
            binding.etFirstname.error="First name is required"
            error=true
        }

        if(lastname.isBlank()){
            binding.tilLastname.error="Last name is required"
            error=true
        }

        if (email.isBlank()){
            binding.tilEmail1.error="Email is required"
            error=true
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmail1.error="Not a valid address"
            error=true
        }

        if (password.isBlank()){
            binding.tilPassword.error= "Password is required"
            error=true

        }

        if (confirm.isBlank()){
            binding.tilConfirm.error="Confirm Password"
            error=true

        }

        if (password!=confirm){
            binding.tilConfirm.error="should match"
            error=true
        }

    }
}