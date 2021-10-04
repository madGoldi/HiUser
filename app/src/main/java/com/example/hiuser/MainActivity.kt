package com.example.hiuser

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Registration.isEnabled = false
    }

    fun calendar(view: View) {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val birhtday = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, y, m, d ->
            Date.setText("$d.${m+1}.$y")
        }, year, month, day)
        birhtday.datePicker.maxDate = System.currentTimeMillis()
        birhtday.show()
    }

    fun registr(view: View) {
        var name = Name.text.toString()
        var surname = SurName.text.toString()
        var date = Date.text.toString()
        var password = Password.text.toString()
        var passwordre = PasswordRe.text.toString()
        var notname = "1234567890+=!@#$%^&*()_-/?.,><\'\"\\;][}{|№/"
        var notpass = "йцукенгшщзхъфывапролджэячсмитьбюЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ<>\'\" "
        var k=0
        var err=0;
        if (name == "") {
            NameErr.visibility = View.VISIBLE
            err++
        }
        else {
            NameErr.visibility = View.INVISIBLE
            for (i in name.indices) {
                for (j in notname.indices) {
                    if (name[i] == notname[j]) {
                        NameErr.visibility=View.VISIBLE
                        k=1
                        break
                    }
                }
                if (k==1) {
                    err++
                    break
                }
                else {
                    NameErr.visibility=View.INVISIBLE
                }
            }
        }
        if (surname == "") {
            SurNameErr.visibility = View.VISIBLE
            err++
        }
        else {
            SurNameErr.visibility = View.INVISIBLE
            k=0
            for (i in surname.indices) {
                for (j in notname.indices) {
                    if (surname[i] == notname[j]) {
                        SurNameErr.visibility=View.VISIBLE
                        k=1
                        break
                    }
                }
                if (k==1) {
                    err++
                    break
                }
                else {
                    SurNameErr.visibility=View.INVISIBLE
                }
            }
        }
        if (date == "") {
            DateErr.visibility = View.VISIBLE
            err++
        }
        else
            DateErr.visibility=View.INVISIBLE
        if (password == "") {
            PasswordErr.visibility = View.VISIBLE
            err++
        }
        else {
            PasswordErr.visibility = View.INVISIBLE
            k=0
            for (i in password.indices) {
                for (j in notpass.indices) {
                    if (password[i] == notpass[j]) {
                        PasswordErr.visibility=View.VISIBLE
                        k=1
                        break
                    }
                }
                if (k==1) {
                    err++
                    break
                }
                else {
                    PasswordErr.visibility=View.INVISIBLE
                }
            }
        }
        if (passwordre == "") {
            PasswordReErr.visibility = View.VISIBLE
            err++
        }
        else {
            PasswordErr.visibility = View.INVISIBLE
            if (password != passwordre) {
                PasswordReErr.visibility=View.VISIBLE
                err++
            }
            else {
                PasswordReErr.visibility=View.INVISIBLE
            }
        }

        if (err==0) {
            val HiName = Intent (this, SecondActivity::class.java)
            HiName.putExtra(SecondActivity.TOTAL, name)
            startActivity(HiName)
        }
    }
}