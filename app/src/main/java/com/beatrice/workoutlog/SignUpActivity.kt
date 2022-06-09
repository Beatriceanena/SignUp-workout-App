package com.beatrice.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var etFirstname:TextInputEditText
    lateinit var etLastname:TextInputEditText
    lateinit var tilFirstname:TextInputLayout
    lateinit var tilLastname:TextInputLayout
    lateinit var tilEmail1:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText
    lateinit var tilConfirm:TextInputLayout
    lateinit var etConfirmPassword:TextInputEditText
    lateinit var  btnSignUp:Button
    lateinit var tvLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        etFirstname=findViewById(R.id.etFirstname)
        tilFirstname=findViewById(R.id.tilFirstname)
        tilLastname=findViewById(R.id.tilLastname)
        etLastname=findViewById(R.id.etLastname)
        tilEmail1=findViewById(R.id.tilEmail1)
        etEmail=findViewById(R.id.etEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etPassword=findViewById(R.id.etPassword)
        tilConfirm=findViewById(R.id.tilConfirm)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)
        btnSignUp=findViewById(R.id.btnSignUp)
        tvLogin=findViewById(R.id.tvLogin)

        tvLogin.setOnClickListener{
            var intent= Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener {
       validateSignup()
        }

    }
    fun validateSignup(){
        var error=false
        tilEmail1.error=null
        tilPassword.error=null

        var firstname= etFirstname.text.toString()
        var lastname= etLastname.text.toString()
        var email=etEmail.text.toString()
        var password= etPassword.text.toString()
        var confirm= etConfirmPassword.text.toString()

        if (firstname.isBlank()){
            etFirstname.error="First name is required"
            error=true
        }

        if(lastname.isBlank()){
            tilLastname.error="Last name is required"
            error=true
        }

        if (email.isBlank()){
            tilEmail1.error="Email is required"
            error=true
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tilEmail1.error="Not a valid address"
            error=true
        }

        if (password.isBlank()){
            tilPassword.error= "Password is required"
            error=true

        }

        if (confirm.isBlank()){
            tilConfirm.error="Confirm Password"
            error=true

        }

        if (password!=confirm){
            tilConfirm.error="should match"
            error=true
        }

    }
}