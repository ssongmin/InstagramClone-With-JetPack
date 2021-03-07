package com.example.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.instagramclone.databinding.ActivityLoginBinding
import com.example.instagramclone.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    var auth : FirebaseAuth? = null
    private var mBinding : ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

        auth = FirebaseAuth.getInstance()

        mBinding?.loginactivityEmailLoginBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding?.loginactivityEmailLoginBtn ->
                signInAndSignUp()
        }
    }

    fun signInAndSignUp() {
        auth?.createUserWithEmailAndPassword(mBinding?.loginactivityEmailEditText?.text.toString(), mBinding?.loginactivityPwdEditText?.text.toString())
            ?.addOnCompleteListener { task->
                if(task.isSuccessful) {
                    moveMainPage(task.result?.user)
                } else {
                    signInEmail()
                }
            }
    }

    fun signInEmail() {
        auth?.signInWithEmailAndPassword(mBinding?.loginactivityEmailEditText?.text.toString(), mBinding?.loginactivityPwdEditText?.text.toString())
            ?.addOnCompleteListener {task ->
                if(task.isSuccessful){
                    moveMainPage(task.result?.user)
                }else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }

            }

    }

    private fun moveMainPage(user: FirebaseUser?){
        if(user != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}