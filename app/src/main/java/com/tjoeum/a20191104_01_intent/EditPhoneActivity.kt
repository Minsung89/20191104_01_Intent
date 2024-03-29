package com.tjoeum.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_phone.*

class EditPhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone)


        okBtn.setOnClickListener {

            var intent = Intent()
            intent.putExtra("inputPhoneNum",phoneNumEdt.text.toString())

            setResult( Activity.RESULT_OK, intent)

            finish()
        }
        cancelBtn.setOnClickListener {
            finish()
        }
    }
}
