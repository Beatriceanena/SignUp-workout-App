package com.beatrice.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText
    lateinit var btnLogIn:Button
    lateinit var tvSignUp:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        castViews()
    }

    fun castViews(){
        tilEmail=findViewById(R.id.tilEmail)
        etEmail=findViewById(R.id.etEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etPassword=findViewById(R.id.etPassword)
        btnLogIn=findViewById(R.id.btnLogIn)
        tvSignUp=findViewById(R.id.tvSignUp)


        tvSignUp.setOnClickListener{
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        btnLogIn.setOnClickListener{
            validateLogin()
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }

    fun validateLogin(){

        var email=etEmail.text.toString()
        if (email.isBlank()){
            tilEmail.error="Email is required"
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tilEmail.error="Not a valid address"

        }

        var password=etPassword.text.toString()
        if (password.isBlank()){
            tilPassword.error="Password is required"
        }
      // if (!error){
        //    startActivity(Intent(this,HomeActivity::class.java))
        //}

    }
}