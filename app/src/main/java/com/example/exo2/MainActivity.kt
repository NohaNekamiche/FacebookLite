package com.example.exo2

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connect.setOnClickListener {
            val email_val=email.text.toString()
            val pwd_val=pwd.text.toString()
            if(isValidEmail(email_val)){
                if(!pwd_val.isEmpty()){
                    if(email_val=="test@gmail.com" && pwd_val=="test"){
                        Toast.makeText(this, "la connexion est etablir", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        alertDialog("verifier que vous avez entrer votre email ou mot de passes  correctement")
                    }
                }
                else{
                    alertDialog("verifier que vous avez entrer votre mot de passe correctement")
                }
            }else{
                alertDialog("verifier que vous avez entrer votre email correctement")

            }
        }


    }


   private fun isValidEmail(email_val: CharSequence?): Boolean {
        return !TextUtils.isEmpty(email_val) && Patterns.EMAIL_ADDRESS.matcher(email_val)
            .matches()
    }
    private fun alertDialog(msg :String){
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle(R.string.title)
        //set message for alert dialog
        builder.setMessage(msg)
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        //performing positive action
        builder.setPositiveButton("Oui"){dialogInterface, which ->
            Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
        }
        //performing cancel action
        builder.setNeutralButton("Ignorer"){dialogInterface , which ->
            Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
        }
        //performing negative action
        builder.setNegativeButton("Non"){dialogInterface, which ->
            Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}