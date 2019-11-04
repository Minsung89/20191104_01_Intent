package com.tjoeum.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_edit_user_info.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val REQ_CODE_FOR_NAME = 1000
    val REQ_CODE_FOR_PHONE = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInputBtn.setOnClickListener {

            var intent = Intent(this,EditUserInfoActivity::class.java)

            startActivityForResult(intent, REQ_CODE_FOR_NAME)
        }

        phoneNumInputBtn.setOnClickListener {
            var intent = Intent(this, EditPhoneActivity::class.java)

            startActivityForResult(intent, REQ_CODE_FOR_PHONE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE_FOR_NAME) {
            if (resultCode == Activity.RESULT_OK) {
                var inputNameData = data?.getStringExtra("inputName")?.toLowerCase()

                inputNameData?.let {

                    nameTxt.text = it

                }
            }
        } else if(requestCode == REQ_CODE_FOR_PHONE){
            if(resultCode == Activity.RESULT_OK){
                var inputNameData = data?.getStringExtra("inputPhoneNum")

                inputNameData?.let {

                    phoneNumTxt.text = it
                }
            }
        }
    }
}
