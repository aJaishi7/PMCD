package com.college.pmcd

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import android.widget.Toast.makeText
import com.college.pmcd.model.User
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername: EditText;
    private lateinit var etPassword: EditText;
    private lateinit var btnLogin: Button;
    private lateinit var registerInfo: TextView;

    private val username: String = String();
    private val password: String = String();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide();
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        registerInfo = findViewById(R.id.registerInfo);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        registerInfo.setOnClickListener(this);

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {

                if (isValid()) {

                    val username = etUsername.text.toString();
                    val password = etPassword.text.toString();
                    //Function that Check Username and Password
                    checkLogin(username = username, password = password);

                }
            }
            R.id.registerInfo -> {
                startActivity(Intent(this, RegisterActivity::class.java));
            }
        }
    }

    private fun isValid(): Boolean {
        if (TextUtils.isEmpty(etUsername.text.toString())) {
            etUsername.error = "Required";
            etUsername.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etPassword.text.toString())) {
            etPassword.error = "Required";
            etPassword.requestFocus();
            return false;
        }
        return true;
    }


    private fun checkLogin(username: String, password: String): Boolean {

        val login: User = User();
        if (login.isLogin(username, password)) {
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            return true
        } else {
            Toast.makeText(this, "Enter Valid Credentials", Toast.LENGTH_SHORT)
                .show();
            return false
        }

    }
}

