package com.tjoeum.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
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

        phoneNumDialBtn.setOnClickListener {
            var uri = Uri.parse("tel:01053194080") //띄어쓰기 하면 안됨.

            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        phoneCallBtn.setOnClickListener {
//            var uri = Uri.parse("tel:01053194080") //띄어쓰기 하면 안됨.
//
//            var intent = Intent(Intent.ACTION_CALL, uri)
//            startActivity(intent)
        }

        snsBtn.setOnClickListener {

            var uri = Uri.parse("smsto:01053194080")

            var intent = Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("sms_body", "내가 만들었다 이시끼야")
            startActivity(intent)

        }

        webLinkBtn.setOnClickListener {
            var uri = Uri.parse("http://www.naver.com")

            var intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        storeLinkBtn.setOnClickListener {
            var uri = Uri.parse("market://details?id=com.kakao.talk")

            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        googleMapBtn.setOnClickListener {
            var uri = Uri.parse("geo:37.123, 127.567") //위도, 경도값 대입

            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
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
