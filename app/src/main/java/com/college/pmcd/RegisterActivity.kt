package com.college.pmcd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.college.pmcd.model.User
import de.hdodenhof.circleimageview.CircleImageView

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etFullname: EditText;
    private lateinit var etPhone: EditText;
    private lateinit var etPassword: EditText;
    private lateinit var etReenterPassword: EditText;
    private lateinit var profileImage: CircleImageView;
    private lateinit var btnRegister: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register);

        etFullname = findViewById(R.id.etFullname);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etReenterPassword = findViewById(R.id.etCPassword);
        profileImage = findViewById(R.id.imgProfile);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegister -> {

                if (TextUtils.isEmpty(etFullname.text.toString())) {
                    etFullname.error = "Required";
                    etFullname.requestFocus();
                } else if (TextUtils.isEmpty(etPhone.text.toString())) {
                    etPhone.error = "Required";
                    etPhone.requestFocus();
                } else if (TextUtils.isEmpty(etPassword.text.toString())) {
                    etPassword.error = "Required";
                    etPassword.requestFocus();
                } else if (TextUtils.isEmpty(etReenterPassword.text.toString())) {
                    etReenterPassword.error = "Required";
                    etReenterPassword.requestFocus();
                } else if (!etPassword.text.toString().equals(etReenterPassword.text.toString())) {
                    etReenterPassword.error = "Password Doesnot Match";
                    etReenterPassword.requestFocus();
                } else {

                    val fullname = etFullname.text.toString();
                    val phone = etPhone.text.toString();
                    val password = etPassword.text.toString();

                    //Remaining to add Profile Picture
                    val signup = User(fullName = fullname, password = password, phone = phone);

                    //Intent to go back to signin page
                    startActivity(Intent(this, LoginActivity::class.java));
                }
            }
        }
    }
}