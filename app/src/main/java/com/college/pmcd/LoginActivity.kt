package com.college.pmcd

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast.makeText
import android.widget.ViewAnimator
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnLogin: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide();
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
             Snackbar.make(v.rootView, "Login Success", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}